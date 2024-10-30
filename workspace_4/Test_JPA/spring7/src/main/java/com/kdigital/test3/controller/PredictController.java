package com.kdigital.test3.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdigital.test3.dto.Iris;
import com.kdigital.test3.service.PredictService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class PredictController {
	final PredictService service;
	/**
	 * 붓꽃분류(예측)을 위한 화면 요청
	 * @return
	 */
	@GetMapping("/predict")
	public String predict() {
		return "predict";
	}
	@PostMapping("/predict")
	@ResponseBody // ajax로 보낸것이니 꼭잇어야한다
	public String predict(@ModelAttribute Iris iris) {
		log.info("정보:{}",iris.toString());
		
		Map<String,Object> result = service.predictRest(iris);
		return "OK";
	}

}
