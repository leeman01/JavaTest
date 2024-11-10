package com.example.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.OfDto;
import com.example.demo.repository.OfRepository;
import com.example.demo.service.IndexService;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@lombok.extern.slf4j.Slf4j
public class IndexController {
	private final IndexService service;
	
	@GetMapping("/index/calendar")
	@ResponseBody
	public HashMap<LocalDate, Double> requestCalendar(
			@RequestParam("placeOfLoading") int loading,
			@RequestParam("placeOfUnloading") String unloading
			) {
			log.info("선적지/양하지 정보=>{} {}",loading,unloading);
			OfDto dto = service.findOfEntity(loading, unloading);
			log.info("달력처리_{}",dto.getUnloadingPort());
			LocalDate now = LocalDate.now();
			double ofweek1= dto.getOfWeek1();
			double ofweek2= dto.getOfWeek2();
			double ofweek3= dto.getOfWeek3();
			double ofweek4= dto.getOfWeek4();

			HashMap<LocalDate, Double> map = new HashMap<>();
			map.put(now.plusDays(1), Math.ceil(ofweek1));
			map.put(now.plusDays(8), Math.ceil(ofweek2));
			map.put(now.plusDays(15), Math.ceil(ofweek3));
			map.put(now.plusDays(22), Math.ceil(ofweek4));	

			return map;
	}
	
}
