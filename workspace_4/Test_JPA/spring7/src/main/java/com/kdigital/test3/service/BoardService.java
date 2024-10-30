package com.kdigital.test3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kdigital.test3.dto.BoardDTO;
import com.kdigital.test3.entity.BoardEntity;
import com.kdigital.test3.repository.BoardRepository;
import com.kdigital.test3.util.FileService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service // 스프링컨테이너와 관련해서 bean이 됨
@RequiredArgsConstructor  // final 이 입력된 변수 사용시
public class BoardService {
	final BoardRepository boardRepository;
	@Value("${user.board.pageLimit}")
	private int pageLimit ;
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	/**
	 * DB에 게시글 저장
	 * @param boardDTO : 저장해야하는 게시글
	 */
	public void insertBoard(BoardDTO boardDTO) {
		log.info("저장경로:{}" ,uploadPath);
		
		// 첨부파일 처리
		String originalFileName=null;
		String savedFileName = null ;
	
		// 파일첨부여부확인
		if(!boardDTO.getUploadFile().isEmpty()) {
			savedFileName = FileService.saveFile(boardDTO.getUploadFile(), uploadPath);
			originalFileName = boardDTO.getUploadFile().getOriginalFilename();
			boardDTO.setOriginalFileName(originalFileName);
			boardDTO.setSavedFileName(savedFileName);
		}
		log.info("오리지널 파일이름 =>{}",originalFileName);
		log.info("저장된 파일이름 =>{}",savedFileName);
		// 1) entity로변환
		
		BoardEntity boardEntity = BoardEntity.toEntity(boardDTO);
		
		// 2) save라는 메소드를 이용해서 실제로 저장해야함
		boardRepository.save(boardEntity);
		
	}
	/**
	 * 게시글 목록 요청
	 * @param pageable 
	 * @param searchWord 
	 * @param searchItem 
	 * @return
	 */
	public Page<BoardDTO> selectAll(Pageable pageable, String searchItem, String searchWord) {
		int page = pageable.getPageNumber()-1;// -1을 한 이유는 db 페이지의 위치값이0부터 시작하므로
		// 사용자가 1페이지를 요청하면 DB페이지를 가져와야한다
		
//		List<BoardDTO> list = new ArrayList<>();
		
		// 페이징 추가된 조회
		Page <BoardEntity> entityList=null;
		switch(searchItem) {
		case "boardTitle": entityList=boardRepository.findByBoardTitleContains(searchWord,PageRequest.of(page, pageLimit,Sort.by(Sort.Direction.DESC,"boardNum"))); break;
		case "boardWriter":
			 entityList=boardRepository.findByBoardWriterContains(searchWord,PageRequest.of(page, pageLimit,Sort.by(Sort.Direction.DESC,"boardNum"))); break;
		case "boardContent": entityList=boardRepository.findByBoardContentContains(searchWord,PageRequest.of(page, pageLimit,Sort.by(Sort.Direction.DESC,"boardNum"))); break;
			
		}
		log.info("데이터의 길이_{}",entityList.getSize());
	
		/*
		List<BoardEntity> entityList=null;
		//find method 만들기 규칙
		switch(searchItem) {
		case "boardTitle": entityList=boardRepository.findByBoardTitleContains(searchWord,Sort.by(Sort.Direction.DESC,"boardNum")); break;
		case "boardWriter":
			 entityList=boardRepository.findByBoardWriterContains(searchWord,Sort.by(Sort.Direction.DESC,"boardNum")); break;
		case "boardContent": entityList=boardRepository.findByBoardContentContains(searchWord,Sort.by(Sort.Direction.DESC,"boardNum")); break;
			
		}
		*/
		

		// 정렬하는 방법 포함된 => boardNum을 기준으로 반대 정렬 단순조회할 때만 사용
//		List<BoardEntity> entityList = boardRepository.findAll(Sort.by(Sort.Direction.DESC,"boardNum")) ;
		// entity를 dto로 변경
		Page<BoardDTO> list = null;
//		entityList.forEach((item)-> list.add(BoardDTO.toDTO(item))) ; // 일반 검색기능만 가지고있는 데이터
		
		// 페이징 형태의 list로 반환
		// 목록에서 사용할 필요한 데이터만 간추림 <- 생성자를 만들어서 오류복구
		list = entityList.map(board-> 
		new BoardDTO(board.getBoardNum(),
				board.getBoardTitle(),
				board.getBoardWriter(),
				board.getHitCount(),
				board.getCreateDate()	,
				board.getOriginalFileName() // 뷰단에서 사용할 파일 첨부이름
				,board.getReplyCount()
				));
			
		return list ;
	}
	/**
	 * PK에 해당하는 boardNum값을 이용해 글 한개 조회
	 * @param boardNum
	 * @return
	 */
	public BoardDTO selectOne(Long boardNum) {
		Optional<BoardEntity> entity = boardRepository.findById(boardNum);
		if(entity.isPresent()) {
			BoardEntity temp = entity.get();
			return BoardDTO.toDTO(temp) ;
		}
		return null;
	}
	/**
	 * 전달받은 글번호와 일치하는것을 삭제
	 */
	@Transactional
	public void deleteOne(Long boardNum) {
		// 글번호에 해당하는 글이 존재하는지 읽어옴
				Optional<BoardEntity> entity = boardRepository.findById(boardNum);
				if (entity.isPresent()) {
					BoardEntity board = entity.get();
					String savedFileName = board.getSavedFileName();
					
					//첨부파일이 있으면 파일을 먼저 삭제하고 나서 DB에서도 삭제
					if(savedFileName != null) {
						String fullPath = uploadPath +"/" +savedFileName ;
						boolean result = FileService.deleteFiles(fullPath);
						
						log.info("파일 삭제여부 : {}",result); // true이면 삭제됨
					}
					boardRepository.deleteById(boardNum);
				}
			}
	/**
	 * DB 에서 데이터를 ㅅ수정처리
	 * 파일이 첨부되엇을 경우 저장 작업 - 원래 글에 첨부파일이 ㅇ벗는경우
	 * 또는 삭제후 다른 파일로 수정하는 방법
	 * @param board
	 * @return
	 */
	@Transactional // 데이터베이스에 2번 접근할때?
	public void updateBoard(BoardDTO board) {
		
		MultipartFile uploadFile = board.getUploadFile();
		
		String originalFileName = null;	// 새로운 파일이 처뭅되었을 때 
		String savedFileName=null;		// 새로운 파일이 첨부되었을 때
		String oldSavedFileName = null ; // 기존에 업로드된 파일이 있을 경우 그 파일명
		// 첨부파일이 있을경우 == 수정하면서 첨부파일을 송신할경우
		if(!uploadFile.isEmpty()) {
			originalFileName = uploadFile.getOriginalFilename();
			savedFileName =FileService.saveFile(uploadFile,uploadPath);
		}
			
		
		// 1) 수정하려는 글이 존재하는지확인
		Optional<BoardEntity> entity= boardRepository.findById(board.getBoardNum());
		
		if(entity.isPresent()) {
			BoardEntity temp = entity.get();
			oldSavedFileName = temp.getSavedFileName();
			// 기존파일이 있고 수정하면서 첨부파일이 있을때
			if(oldSavedFileName!=null && !uploadFile.isEmpty()) {
				// 에전파일은 삭제
				String fullPath =uploadPath + "/" +oldSavedFileName;
				FileService.deleteFiles(fullPath);
				// 오리지널 파일명을
				temp.setOriginalFileName(originalFileName);
				temp.setSavedFileName(oldSavedFileName);
			}
				
//			// 기존파일은 없고 수정하면서 첨부파일이 있을때
			if(oldSavedFileName==null && !uploadFile.isEmpty()) {
				temp.setOriginalFileName(originalFileName);
				temp.setSavedFileName(oldSavedFileName);			
			}
			//기존 첨부파일이 없을 때 수정하면서 파일 첨부도 안하면 널값을 저장하면됨
			temp.setBoardTitle(board.getBoardTitle());  
			temp.setBoardContent(board.getBoardContent());
		
		}
		
	}
	/**
	 * 조회수 증가
	 * @param boardNum
	 */
	@Transactional
	public void incrementHitcount(Long boardNum) {
		Optional<BoardEntity> entity = boardRepository.findById(boardNum);
		if(entity.isPresent()) {
			BoardEntity temp = entity.get();
			temp.setHitCount(temp.getHitCount()+1);
		}
		
	}
	/**
	 * 게시글은 그대로 두고 파일만 삭제
	 * @param boardNum : 파일이 저장된 게시글 번호
	 */
	@Transactional
	public void deleteFile(Long boardNum) {
		// 1) 데이터조회
		Optional<BoardEntity> entity= boardRepository.findById(boardNum);
		String oldSavedFileName=null;
		//
		if(entity.isPresent()) {
			BoardEntity temp = entity.get();
			oldSavedFileName = temp.getSavedFileName();
			
			// 에전파일은 삭제
			String fullPath =uploadPath + "/" +oldSavedFileName;
			FileService.deleteFiles(fullPath);
				// 파일명을 null
			temp.setOriginalFileName(null);
			temp.setSavedFileName(null);
		

		}
	}
		
}
	


