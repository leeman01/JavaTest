package com.kdigital.diary.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdigital.diary.dto.UserDTO;
import com.kdigital.diary.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor

public class MainController {
	final UserService service;
	@GetMapping({"/", ""})
	public String index(Model model) {
		String username = "이동건";
		
		
		// 인덱스에서 자기이름 받음
		model.addAttribute("username", username);
	
		return "index";
	}
	@GetMapping("/diary")
	public String diary(@RequestParam(name="username") String name,
			Model model) {
		log.info("{}",name);
		LocalDate regdate=LocalDate.now();
		model.addAttribute("regdate", regdate);
		model.addAttribute("name",name); // 사용자 이름 name이라는 변수로 전달
		
		// 저장된 모든 답글을 반환하는 메소드가 필요
		List <UserDTO > list =service.retreiveAll();
		log.info("{}",list);
		model.addAttribute("list",list);
		return "diaryForm";
	}
	@GetMapping("/retrieve")
	@ResponseBody
	public List<UserDTO> retreive(Model model) {
		List <UserDTO > list =service.retreiveAll();
		
		return list;
	}
	@PostMapping("/diary")
	@ResponseBody
	public String diary(
			@ModelAttribute UserDTO userDTO
			) {
		log.info("{}",userDTO.toString());
//		userDTO.setRecords("좀 왜안되는거야 개 빡치네 그냥");
		userDTO.setUserName("이동건");
		service.insert(userDTO);
//		return "redirect:/";
		return "index";
	}
	@GetMapping("/delete")
	@ResponseBody
	public String diary1(
			@RequestParam(name="diarySeq1") int diaryseq1,
			Model model) {
		
		service.delete(diaryseq1);
		return "OK";
	}
}
