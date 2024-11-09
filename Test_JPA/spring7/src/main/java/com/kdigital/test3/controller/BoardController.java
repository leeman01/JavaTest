package com.kdigital.test3.controller;


import java.io.FileInputStream;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kdigital.test3.dto.BoardDTO;
import com.kdigital.test3.dto.LoginUserDetails;
import com.kdigital.test3.service.BoardService;
import com.kdigital.test3.util.PageNavigator;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/board") // requst 메핑은 요청이 2단계로 나뉠때 사용한다
@RequiredArgsConstructor // 서비스 객체를 생성자 주입방식으로 하기 위해 

public class BoardController {
	// service 선언이 필요
	final BoardService boardService ;
	@Value("${user.board.pageLimit}") // 이건 한페이지의 게시글 수 
	private int pageLimit ; // 한페이지에 보여줄 글의 개수
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	/**
	 * 게시글 목록 조회를 위해 DB에 요청처리
	 * 1) index에서 넘어올 경우에는 searchItem, searchWord 가 없는 상태이므로 기본값 세팅(default)
	 * 2) List에서 직접 입력해서 넘어 올 경우 SearchItem/searchWord가 있으므로 그 값을 사용 
	 * @param model
	 * @return
	 */

	@GetMapping("/boardList")
	public String boardList(
			@PageableDefault(page=1) Pageable pageable,
			@AuthenticationPrincipal LoginUserDetails loginUser,
			@RequestParam(name="searchItem",defaultValue="boardTitle") String searchItem,
			@RequestParam(name="searchWord",defaultValue="") String searchWord,
			Model model) {
		log.info("searchItem:{}",searchItem);
		log.info("searchWord:{}",searchWord);
		// 검색기능 + 페이징
		Page<BoardDTO> list = boardService.selectAll(pageable,searchItem,searchWord);
		
		int totalPages= list.getTotalPages() ; // DB에서 받아온 정보에서 추출
		int page = pageable.getPageNumber() ; // 사용자가 요청한 정보에서 추출
		log.info("추출된 모든 정보_{}",totalPages);
		PageNavigator navi = new PageNavigator(pageLimit,page,totalPages);
		// 검색기능만 가능
//		List<BoardDTO> list = boardService.selectAll(pageable,searchItem,searchWord); // 글 목록을 요청하는 과정 /

//		log.info("DB에서 받은 데이터 => {}" ,list);
		model.addAttribute("list",list);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("searchWord",searchWord);
		model.addAttribute("navi",navi);
		if(loginUser != null) { // reidrect방식은 이렇게하면 안됨
			model.addAttribute("loginName",loginUser.getUserName());
		}		
		return "board/boardList";
	}
	@GetMapping("/boardWrite")
	public String boardWriter(
			@AuthenticationPrincipal LoginUserDetails loginUser,
			Model model) {
		if(loginUser != null) { // reidrect방식은 이렇게하면 안됨
			model.addAttribute("loginName",loginUser.getUserName());
		}	
		return "/board/boardWrite";
	}
	/**
	 * DB에 글을 등록 처리하는 요청
	 * 첨부파일도 포함
	 * @param entity
	 * @return
	 */
	@PostMapping("/boardWrite")
	public String boardWriter(
			@ModelAttribute BoardDTO boardDTO,
		
			Model model
			) {
		log.info("클라이언트한테서 전송된 데이터=> {} ", boardDTO.toString()); // 이제 서비스로 넘겨서 repository에 저장을 해야한다
		MultipartFile temp =boardDTO.getUploadFile();
		System.out.println(temp);
		System.out.println("컨탠트타입:" + temp.getContentType());
		System.out.println("Name: " + temp.getName());
		System.out.println("originalFileName: " + temp.getOriginalFilename());
		System.out.println("isEmpty :" + temp.isEmpty());
		System.out.println("Size: " + temp.getSize());
		boardService.insertBoard(boardDTO);  // (아직 넘기지 않음)
		
		return "redirect:/board/boardList";
	}
	/**
	 * 검색후의 정보를 전달받도록 함
	 * @param boardNum
	 * @param model
	 * @return
	 */
	@GetMapping("/boardDetail")
	public String boardDetail(
			@RequestParam(name="boardNum") Long boardNum,
			@RequestParam(name="searchItem",defaultValue="boardTitle") String searchItem,
			@RequestParam(name="searchWord",defaultValue="") String searchWord,
			@AuthenticationPrincipal LoginUserDetails loginUser
			,Model model) {
		BoardDTO board = boardService.selectOne(boardNum);
		// 조회수 증가
		boardService.incrementHitcount(boardNum);
		
		if(board==null) {
		
			return "redirect:/board/boardList" ;
		}
		model.addAttribute("board",board);
		// 검색기능이 추가되면 계속 달고다녀야함
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("searchWord",searchWord);
		// 로그인 된 사용자의 경우 로그인 아이디를 가져감
		if(loginUser!=null) {
			model.addAttribute("loginId",loginUser.getUserName());
		}
		return "/board/boardDetail" ; // "/board/boardDetail" ;
	}
	/**
	 * 전달받은 글번호(boardNum)을 받아 삭제 진행
	 * @param boardNum
	 * @return
	 */
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam(name="boardNum") Long boardNum,
			@RequestParam(name="searchItem",defaultValue="boardTitle") String searchItem,
			@RequestParam(name="searchWord",defaultValue="") String searchWord,
			RedirectAttributes rttr){
		log.info("삭제할 글 번호 =>{}",boardNum);
		boardService.deleteOne(boardNum);
		rttr.addAttribute("searchItem",searchItem);
		rttr.addAttribute("searchWord",searchWord);
		
		// 추가할내용
		return "redirect:/board/boardList";
		
	}
	/**
	 * 게시글을 수정하기위해서 화면에 출력할 내용을 조회
	 * @param boardNum
	 * @return
	 */
	@GetMapping("/boardUpdate")
	public String boardUpdate(@RequestParam(name="boardNum") Long boardNum,
			@RequestParam(name="searchItem",defaultValue="boardTitle") String searchItem,
			@RequestParam(name="searchWord",defaultValue="") String searchWord,
			@AuthenticationPrincipal LoginUserDetails loginUser,
			Model model){
		log.info("업데이트할 글 번호 =>{}",boardNum);
		BoardDTO board = boardService.selectOne(boardNum);
		log.info("수정할 글 == {}",boardNum.toString());
		model.addAttribute("board",board);
		// 검색기능이 추가되면 계속 달고다녀야함
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("searchWord",searchWord);
		if(loginUser != null) { // reidrect방식은 이렇게하면 안됨
			model.addAttribute("loginName",loginUser.getUserName());
		}
		return "board/boardUpdate";
		
	}		
	/**
	 * 게시글을 수정요청
	 * @param boardNum
	 * @return
	 */
	@PostMapping("/boardUpdate")
	public String boardUpdate(@ModelAttribute BoardDTO board,
			@RequestParam(name="searchItem",defaultValue="boardTitle") String searchItem,
			@RequestParam(name="searchWord",defaultValue="") String searchWord,
			RedirectAttributes rttr){
		log.info("수정할글 =>{}",board.toString());
		boardService.updateBoard(board);
		rttr.addAttribute("searchItem",searchItem);
		rttr.addAttribute("searchWord",searchWord);
		return "redirect:/board/boardList";
		
	}
	/**
	 * 전달받은 게시글 번호에 파일을 다운로드
	 * @return
	 */
	@GetMapping("/download")
	public String download(
			@RequestParam(name="boardNum") Long boardNum,
			HttpServletResponse response
			) {
		
		BoardDTO boardDTO= boardService.selectOne(boardNum);
		String originalFileName = boardDTO.getOriginalFileName();
		String savedFileName = boardDTO.getSavedFileName();
		
		log.info("원본파일명(download_controller) : {} " ,originalFileName) ;
		log.info("수정파일명(download_controller) : {} " ,savedFileName) ;
		log.info("저장 디렉토리(download_controller) : {} " ,uploadPath) ;
		
		try {
			String tempName = URLEncoder.encode(originalFileName, StandardCharsets.UTF_8.toString());
			response.setHeader("Content-Disposition", "attachment;filename="+tempName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fullPath = uploadPath+"/" +savedFileName ;
		
		FileInputStream filein = null ;
		ServletOutputStream fileout = null ;
		try {
			filein = new FileInputStream(fullPath);
			fileout  = response.getOutputStream();
			
			FileCopyUtils.copy(filein,fileout);
			
			fileout.close();
			filein.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	/**
	 * 게시판 수정화면에서 파일만 삭제하도록 요청
	 * @param param
	 * @return
	 */
	@GetMapping("/deleteFile")
	public String deleteFile(
			@RequestParam(name="boardNum") Long boardNum ,
			RedirectAttributes rttr) {
		
		// boardService에 파일삭제요청 (Update와 동일)
		boardService.deleteFile(boardNum);
		return  "redirect:/board/boardList";
	}
	
	

	
	
}
