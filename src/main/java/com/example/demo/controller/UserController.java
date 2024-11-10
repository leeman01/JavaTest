package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AuthUserDto;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	final UserService userService;
		
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute AuthUserDto userDTO) {
		log.info("정보를 입력: {} " , userDTO.toString());
//		userDTO.setRoles("ROLE_USER");
//		userDTO.setEnabled(true);
		
		boolean result=userService.join(userDTO);
		
		log.info("회원가입 성공여부 =>{}",result);
		
		return "redirect:/" ;
	}
	
	
	/**
	 * 로그인화면 요청
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
}
