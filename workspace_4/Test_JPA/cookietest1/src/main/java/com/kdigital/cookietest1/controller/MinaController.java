package com.kdigital.cookietest1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MinaController {
	@GetMapping({"","/"})
	public String cookietest() {
		return "cookie";
	}
	
}
