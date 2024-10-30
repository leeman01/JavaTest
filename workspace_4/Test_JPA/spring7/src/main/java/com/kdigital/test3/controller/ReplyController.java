package com.kdigital.test3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kdigital.test3.dto.ReplyDTO;
import com.kdigital.test3.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/reply")
public class ReplyController {
	final ReplyService service;
	@PostMapping("/replyInsert")
	public ReplyDTO replyInsert(@ModelAttribute ReplyDTO replyDTO) {
		log.info("제발~~~~~~~{}",replyDTO);	
		service.replyInsert(replyDTO);
		return replyDTO;
	}
	/**
	 *  전달받은 게시글의 댓글 목록전체를 조회
	 * @return
	 */
	@GetMapping("/replyAll")
	public List<ReplyDTO> replyAll(
			@RequestParam(name="boardNum") Long boardNum
	) {
		log.info("게시글 번호 ==>{}",boardNum);
		List<ReplyDTO> list = service.replyAll(boardNum);
		log.info("어디가 문제냐 =>{}",list);
		return list;
	}
	@GetMapping("/replyDelete")
	public boolean replyDelete(
			@RequestParam(name="replyNum") Long replynum
			) {
		log.info("삭제할 댓글 번호==> {}",replynum);
		
		return service.replyDelete(replynum);
	}
	
	
}
