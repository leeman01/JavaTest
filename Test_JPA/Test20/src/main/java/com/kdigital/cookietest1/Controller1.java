package com.kdigital.cookietest1;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
public class Controller1 {
	private final MailService mailService;
	private final ReceiveCehck b;
	
	@GetMapping({"","/"})
	public String getMethodName() {
		return "index";
	   
	}
	@GetMapping("/email")
	public String gerEmail() {
		return "send";
	}
	
	@PostMapping("/send")
	public String realSened(MailDto mailDto) {
		mailService.mailSend(mailDto);
		return "redirect:/" ;
	}
	@GetMapping("/fortune")
	public String realfortunre() {
		return "fortune";
	}
	@PostMapping("/target")
	public String realTarget() {
		log.info("작동중");
		return mailService.returnVal();
	}

}
