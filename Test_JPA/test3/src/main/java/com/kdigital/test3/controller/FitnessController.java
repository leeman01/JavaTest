package com.kdigital.test3.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kdigital.test3.dto.FitnessDto;
import com.kdigital.test3.service.FitnessService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor 
public class FitnessController {
	final FitnessService service;
	@GetMapping("/insertMember")
	public String insertMember() {
		return "insertMember";
	}
	@PostMapping("/insertMember")
	public String insertMember(
			@ModelAttribute FitnessDto fitness
			) {
		service.insert(fitness);
		return "redirect:/" ;
	}
	@GetMapping("/listMember")
	public String listMember(Model model) {
		List<FitnessDto> list = service.list();
		model.addAttribute("list",list);
		return "listMember";
	}
	@GetMapping("/deleteOne")
	public String dleteFitness(@RequestParam(name="seq") Integer seq) {
		log.info("전달된번호==> {}" , seq);
		service.deleteOne(seq) ;		
		return ("redirect:/listMember") ; // redirect는 get 요청 !!
	}
	@GetMapping("/updateOne")
	public String updateFriend(@RequestParam(name="seq") Integer seq,
			Model model) {
		FitnessDto fitness = service.SelectOne(seq);
		model.addAttribute("fitness",fitness);
		return "update" ; // 여기서 뭔가 이상하니까 잠만 둬보자
	}
	@GetMapping("/selectOne")
	public String selectFriend(@RequestParam(name="seq") Integer seq,
			Model model) {
		FitnessDto fitness = service.SelectOne(seq);
		model.addAttribute("fitness",fitness);
		return "select" ; // 여기서 뭔가 이상하니까 잠만 둬보자
	}
	@PostMapping("/updateOne")
	public String updateFriend(
			@ModelAttribute FitnessDto fitness) {
		service.updateOne(fitness) ; 

		return "redirect:/listMember" ; // 브라우저에게 목록을 다시 요청하도록 지시 !!
	}
}
