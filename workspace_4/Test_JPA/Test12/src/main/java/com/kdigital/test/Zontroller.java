package com.kdigital.test;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class Zontroller {
	@GetMapping({"","/"})
	public String redirectToAPI()  {
		return "index";
	   
	}


}
