package com.kdigital.agxtest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kdigital.agxtest.dto.GuestbookDTO;
import com.kdigital.agxtest.service.GuestbookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequiredArgsConstructor
@Slf4j
public class GusetbookController {
	final GuestbookService service;
	
	/**
	 * 방명록을 등록
	 */
	@PostMapping("/inputGuestbook")
	public String inputGuestbook(
			@ModelAttribute GuestbookDTO dto
			) {
		log.info("방명록정보 =={}" ,dto.toString());
		
		service.inputGuestbook(dto);
		return "OK";
	}
	@GetMapping("/retreieveAll")
	public List<GuestbookDTO> retreieveAll() {
		List<GuestbookDTO> list =service.retreieveAll();
		return list;
	}
	@PostMapping("/deleteguestbook")
	public String deleteGuestbook(@RequestParam(name="seq") Long seq,
			@RequestParam(name="pwd") String pwd) {
		//TODO: process POST request
		log.info("삭제할 정보 {}/{}" ,seq,pwd);
		service.deleteGuestbook(seq,pwd);
		return "ok delete";
	}
	
	
	
	
}
