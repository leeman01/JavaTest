package com.kdigital.test3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdigital.test3.dto.UserDTO;
import com.kdigital.test3.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	final UserService userService;
	/**
	 * 회원 가입을 위한 화면요청
	 * @param param
	 * @return
	 */
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute UserDTO userDTO) {
		log.info("정보를 입력: {} " , userDTO.toString());
		userDTO.setRoles("ROLE_USER");
		userDTO.setEnabled(true);
		
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

	/**
	 * 회원가입시 사용가능한 아이디인지 비동기를 이용해 처리
	 * @param userId
	 * @return
	 */
	@PostMapping("/confirmId")
	@ResponseBody
	public boolean confirmId(@RequestParam(name="userId") String userId) {
		//TODO: process POST request
		log.info("회원가입 아이디 : {}" ,userId);
		 // 존재하지않으면 true 존재하면(중복되면) false
		return  !userService.existId(userId);
	}
	/**
	 * 로그인실패시 처리화면
	 * @param error
	 * @param errMessage
	 * @param model
	 * @return
	 */
	@GetMapping("/user/login")
	public String login(
			@RequestParam(value="error" ,required=false) String error,
			@RequestParam(value="errMessage",required=false) String errMessage,
			Model model
			) {
		System.out.println(error);
		System.out.println(errMessage);
		model.addAttribute("error",error);
		model.addAttribute("errMessage",errMessage);
		
		return "user/login";
		
		
	}
	/***
	 * 개인정보수정을 위한 요청
	 * 비밀번호를 한번더 입력하는 페이지로 Forwarding
	 * @return
	 */
	@GetMapping("/mypage")
	public String mypage() {
		return "user/pwdCheck";
	}
	/**
	 * 아이디와 비밀번호 확인처리 요청
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	
	@PostMapping("/pwdCheck")
	public String pwdCheck(
			@RequestParam(name="userId") String userId,
			@RequestParam(name="userPwd") String userPwd,
			Model model) {
		//TODO: process POST request
		log.info("정보 {} {} " ,userId,userPwd);
		UserDTO userDTO = userService.pwdCheck(userId,userPwd);
		if(userDTO!=null) { //개인정보수정화면이 null이 아닌경우에 들어가야함
			model.addAttribute("userDTO",userDTO);
			return "user/myInfoUpdate";
		}else {
			return null;
		}

	}
	
	@PostMapping("/update")
	public String update(
			@ModelAttribute UserDTO userDTO
			) {
		//TODO: process POST request
//		userDTO.setRoles("ROLE_USER");
//		userDTO.setEnabled(true);
		log.info("잘오냐? ==> {}",userDTO);
		boolean result = userService.update(userDTO);
		if(result) {
			return "redirect:/user/logout"; // 개인정보가 수정되면 로그아웃
		}
		
		return "/join";
	}
	
	
	
	
	
}
