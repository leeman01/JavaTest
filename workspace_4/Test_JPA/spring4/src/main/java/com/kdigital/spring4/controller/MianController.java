package com.kdigital.spring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MianController {
	@GetMapping({"","/"})
	public String index() {
		return "index" ;
	}
	

}
