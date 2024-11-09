package com.kdigital.spring03.ontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	// 단순요청만이 아닌 데이터도 보냄
	// get방식으로 보내는 대표적인 방식이 a태그이다
	@GetMapping("/param/send")
	public String param( // name(변수명) = "변수명"  이때 변수명은 같아야한다
			@RequestParam(name="name" ,defaultValue="홍길동") String name,
			@RequestParam(name="age",defaultValue="20") int age
			) {
		System.out.println("name= " + name + "age=" + age); 
		
		return "result" ;
	}
	
	@GetMapping("/param/sendForm")// id = abc , pwd = korea 
	public String snedForm(
			@RequestParam(name="userid",defaultValue="abc") String userid,
			@RequestParam(name="userpwd",defaultValue="korea") String userpwd
			) { 
		System.out.println("userid= " + userid + "userpwd=" + userpwd); 
		return "result" ;
	}
	@PostMapping("/param/sendForm")// id = abc , pwd = korea 
	public String snedForm( // 메소드 오버로딩으로 모댈명이 동일해도된다
			@RequestParam(name="userid",defaultValue="abc") String userid,
			@RequestParam(name="userpwd",defaultValue="korea") String userpwd,
			Model model
			) { 
		System.out.println("userid= " + userid + "userpwd=" + userpwd); 
		
		model.addAttribute("id",userid);
		model.addAttribute("pwd",userpwd);
		
		return "receive" ; // forward 방식 
	}
	

}
