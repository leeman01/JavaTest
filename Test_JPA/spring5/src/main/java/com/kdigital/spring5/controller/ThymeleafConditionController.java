package com.kdigital.spring5.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kdigital.spring5.dto.Friend;
@Controller
public class ThymeleafConditionController {
	@GetMapping("/display/condition")
	public String condition(Model model) {
		// 일반객체
		Friend friend = new Friend("홍길동",25,"010-1111-1111",LocalDate.of(2003,12, 5),true);
		// Iterable 데이터
		List<String> list = Arrays.asList("사과","배","딸기","복숭아","포도");
		List<Integer> nList = new ArrayList<>();
		for(int i=1;i<=20;++i) { 
			nList.add(i*3) ;
		}
		// map 데이터
		Map <Integer,Friend> map = new HashMap<>();
		map.put(10,new  Friend("손오공",25,"010",LocalDate.of(2000,12, 5),true));
		map.put(11,new  Friend("저팔계",25,"010",LocalDate.of(2000,12, 5),true));
		map.put(12,new  Friend("사오정",25,"010",LocalDate.of(2000,12, 5),true));
		
		model.addAttribute("friend",friend);
		model.addAttribute("list",list);
		model.addAttribute("map",map);
		model.addAttribute("nList",nList);
		return "thyme_condition";
		
		
	}
}
