package com.kdigital.agxtest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kdigital.agxtest.dto.GuestbookDTO;
import com.kdigital.agxtest.service.GuestbookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	final GuestbookService service;
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	@GetMapping("/guestbookpage")
	public String guestbook(Model model) {
		List<GuestbookDTO> list =null;
		
		// DB로부터 데이터를 불러오는 작업
		list = service.selectAll();
		model.addAttribute("list", list);
		
		return "guest/guestbook";
	}
}
