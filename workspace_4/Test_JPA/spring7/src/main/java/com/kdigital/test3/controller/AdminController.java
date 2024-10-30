package com.kdigital.test3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class AdminController {
	@GetMapping("/admin")
	public String admin() {
		log.info("어드민 페이지요청!!!!!!!!");
		return "admin/adminPage";
	}
}
