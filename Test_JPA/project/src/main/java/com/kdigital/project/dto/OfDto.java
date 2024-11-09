package com.kdigital.project.dto;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.kdigital.project.Entity.OfEntity;
import com.kdigital.project.Entity.ScfiEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	private String loadingPort;
	private String disChargePort;
	private double ofWeek1;
	private double ofWeek2;
	private double ofWeek3;
	private double ofWeek4;
	private ScfiEntity scfiEntity;
	
	public static OfDto ToDto(OfEntity entity) {
		return OfDto.builder()
				.id(entity.getId())
				.predictionDate(entity.getPredictionDate())
				.disChargePort(entity.getDisChargePort())
				.ofWeek1(entity.getOfWeek1())
				.ofWeek2(entity.getOfWeek2())
				.ofWeek3(entity.getOfWeek3())
				.ofWeek4(entity.getOfWeek4())
				.scfiEntity(entity.getScfiEntity())
				.build();
	}
}
