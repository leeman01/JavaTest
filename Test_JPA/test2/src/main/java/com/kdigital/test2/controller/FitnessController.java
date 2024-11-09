package com.kdigital.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kdigital.test2.dto.Fitnessdto;

@Controller
public class FitnessController {
	@PostMapping("/regist")
	public String fitnessResult(
			@ModelAttribute Fitnessdto fitness,
			Model model
			) {
		model.addAttribute("fitness",fitness);
		return "FitnessResult";
		
	}
	
}
