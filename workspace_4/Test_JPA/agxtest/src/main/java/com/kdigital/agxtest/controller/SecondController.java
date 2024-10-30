package com.kdigital.agxtest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdigital.agxtest.dto.CustomerDTO;


@Controller
public class SecondController {
	@GetMapping("/secondPage")
	public String secondPage() {
		return "second";
	}
	@GetMapping("/receive")
	@ResponseBody
	public List<CustomerDTO> receive() {
		List<CustomerDTO> list = Arrays.asList(
				new CustomerDTO("홍길동","hong@naver.com","010-1111-2222"),
				new CustomerDTO("홍1동","h1ng@naver.com","020-1111-2222")
				,new CustomerDTO("홍2동","h2ng@naver.com","030-1111-2222")
				,new CustomerDTO("홍4동","h4ng@naver.com","040-1111-2222")
				,new CustomerDTO("홍5동","h5ng@naver.com","060-1111-2222")
				);
		return list;
	}
}
