package com.kdigital.test3.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import com.kdigital.test3.entity.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class BoardDTO {
	private Long boardNum;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private int hitCount;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	// 업로드 하는 파일을 받는 멤버변수가 필요하다
	private MultipartFile uploadFile;
	
	private String originalFileName;  // 파일원 원본 파일명
	private String savedFileName;	// 하드디스크에 저장될때 변형한 파일명
	private int replyCount;
	// 생성잔데 페이징 처리를 위해 BoardService.java 에서 Page형태로 받은 데이터 중 목록애 츌력할 멤버만 간추리기 위해 만든 생성자
	
	// 이후 여기서 replyCount를 받아서 클라이언트에 넘겨야 하므로  replyCount를 넣음
	public BoardDTO(Long boardNum, String boardTitle, String boardWriter, int hitCount, LocalDateTime createDate
			, String originalFileName,int replyCount) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter ;
		this.hitCount = hitCount;
		this.createDate = createDate ;
		this.originalFileName = originalFileName ;
		this.replyCount = replyCount;
		
	}
	// entity를 받아서 DTO로 반환해주는 변환 프로그램
	public static BoardDTO toDTO(BoardEntity boardEntity) {
		return BoardDTO.builder()
				.boardNum(boardEntity.getBoardNum())
				.boardWriter(boardEntity.getBoardWriter())
				.boardContent(boardEntity.getBoardContent())
				.boardTitle(boardEntity.getBoardTitle())
				.hitCount(boardEntity.getHitCount())
				.createDate(boardEntity.getCreateDate()) // repository에서 저장된 데이터를 불러와야 하기 때문에 실제로 입력이 되어있어야한다
				.updateDate(boardEntity.getUpdateDate()) 
				.originalFileName(boardEntity.getOriginalFileName())
				.savedFileName(boardEntity.getSavedFileName())
				.replyCount(boardEntity.getReplyCount())
				.build();
							
	}
	
}
