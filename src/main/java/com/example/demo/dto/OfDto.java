package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.OfEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class OfDto {

	private Long id;
	private LocalDate predictionDate;
	private int loadingPort;
	private String unloadingPort;
	private double ofWeek1;
	private double ofWeek2;
	private double ofWeek3;
	private double ofWeek4;

	
	public static OfDto ToDto(OfEntity entity) {
		return OfDto.builder()
				.id(entity.getId())
				.predictionDate(entity.getPredictionDate())
				.unloadingPort(entity.getUnloadingPort())
				.ofWeek1(entity.getOfWeek1())
				.ofWeek2(entity.getOfWeek2())
				.ofWeek3(entity.getOfWeek3())
				.ofWeek4(entity.getOfWeek4())
				.build();
	}
}
