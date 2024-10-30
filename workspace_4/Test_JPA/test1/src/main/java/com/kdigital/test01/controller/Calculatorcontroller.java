package com.kdigital.test01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Calculatorcontroller {
	@PostMapping("/calc")
	public String calculate(
			@RequestParam(name="x" ,defaultValue="1") int x,
			@RequestParam(name="y" ,defaultValue="1") int y,
			Model model
			) {
		System.out.println("x=" + x + "y=" + y);
		model.addAttribute("z" ,(x+y));
		model.addAttribute("x" ,x);
		model.addAttribute("y" , y);
		return "index" ;

	}
}
