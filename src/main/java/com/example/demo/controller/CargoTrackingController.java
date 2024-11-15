package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LocationDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CargoTrackingController {
	
	
	 @GetMapping(value = "/cargo/tracking", produces = "application/json")
	   public LocationDto getMethodName() {
		 	double latitude = 36.664590;
		 	double logitude = 132.131872;
		 	LocalDateTime now=LocalDateTime.now();
		 	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		        // 포맷팅된 시간 문자열
		    String formattedDateTime = now.format(formatter);
		 	LocalDateTime expect=LocalDateTime.of(2024, 11, 24,12, 13);
		 	LocalDateTime arrival = LocalDateTime.of(2024, 11, 27,12, 13);
		 	boolean isLoaded = true;
		 	int loadingPort = 0;
		 	int unloadingPort = 1;
		 	LocationDto dto = new LocationDto(latitude, logitude,formattedDateTime,expect,isLoaded,arrival,loadingPort,unloadingPort);	
//		 	LocationDto dto=new LocationDto(latitude,logitude);
		 	return dto;
	   }
}
