package com.kdigital.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kdigital.score.dto.ScoreDTO;
import com.kdigital.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentController {
	private final ScoreService service;
	private int cnt;
	@GetMapping("/insert")
	public String insertForm() {
		return "insertForm";
	}
	@PostMapping("/insertForm")
	public String postMethodName(@ModelAttribute ScoreDTO scoreDTO) {
		//TODO: process POST request
		log.info("{}",scoreDTO.toString()); // 정보가 제대로 드렁옴?
		// 정보가 들어오면 저장을해야지
//		scoreDTO.setStname("이동건");
		int num = service.insert(scoreDTO); // 학생이 한명 저장된 정보(서비스)
		return "redirect:/";
	}
	@GetMapping("/list")
	public String scoreList(Model model) {
		List<ScoreDTO> list = service.retreveAll();
		log.info("{}",list);
		model.addAttribute("list",list);
		return "list";
	}
	@ResponseBody
	@GetMapping("/retrieve")
	public List<ScoreDTO> getMethodName() {
		List<ScoreDTO> list = service.retreveAll();
		log.info("{}",list);
	
		return list;
	}
	
	@GetMapping("/delete")
	public String getMethodName(@RequestParam(name="stId") String stId) {
		service.delete(stId);
		return "redirect:/";
	}
	
	
	
}
