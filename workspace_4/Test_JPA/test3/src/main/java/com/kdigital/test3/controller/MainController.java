package com.kdigital.test3.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kdigital.test3.dto.FitnessDto;
import com.kdigital.test3.service.FitnessService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequiredArgsConstructor 
public class MainController {
	
	@GetMapping({"","/"})
	public String index() {
		return "index" ;
	}

	
}
