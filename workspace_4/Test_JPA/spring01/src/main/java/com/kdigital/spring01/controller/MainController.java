package com.kdigital.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping({"","/"})
	public String  index() {
		System.out.println("첫 요청이 도착함!");
		return "index" ; // src / main /resource / templetes / index.html
	}
}
