package com.kdigital.cookietest1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test1 {
	@GetMapping({"","/"})
	public String index() {	
		return "index";
		
	}

}
