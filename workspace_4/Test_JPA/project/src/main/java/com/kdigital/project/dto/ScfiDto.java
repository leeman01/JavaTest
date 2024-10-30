package com.kdigital.project.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.kdigital.project.Entity.OfEntity;
import com.kdigital.project.Entity.ScfiEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScfiDto {
	
	private Long id;
	private OfEntity ofEntity;
	private LocalDateTime predictionDate;
	private double ScfiWeekl1;
	private double ScfiWeekl2;
	private double ScfiWeekl3;
	private double ScfiWeekl4;
	
	public static ScfiDto ToDto(ScfiEntity entity) {
		return ScfiDto.builder()
				.id(entity.getId())
				.ofEntity(entity.getOfEntity())
				.ScfiWeekl1(entity.getScfiWeekl1())
				.ScfiWeekl2(entity.getScfiWeekl2())
				.ScfiWeekl3(entity.getScfiWeekl3())
				.ScfiWeekl4(entity.getScfiWeekl4())
				.build();
	}
	
	
}
