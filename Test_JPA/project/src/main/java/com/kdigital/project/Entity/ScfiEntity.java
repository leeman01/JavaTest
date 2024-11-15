package com.kdigital.project.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.kdigital.project.dto.ScfiDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booking_shipment_predictionscfi")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScfiEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "scfiEntity")
	private OfEntity ofEntity;
	@Column(name="prediction_date")
	@CreationTimestamp
	private LocalDateTime predictionDate;
	@Column(name="SCFI_week_1")
	private double ScfiWeekl1;
	@Column(name="SCFI_week_2")
	private double ScfiWeekl2;
	@Column(name="SCFI_week_3")
	private double ScfiWeekl3;
	
	@Column(name="SCFI_week_4")
	private double ScfiWeekl4;
	
	public static ScfiEntity ToEntity(ScfiDto dto) {
		return ScfiEntity.builder()
				.id(dto.getId())
				.ofEntity(dto.getOfEntity())
				.ScfiWeekl1(dto.getScfiWeekl1())
				.ScfiWeekl2(dto.getScfiWeekl2())
				.ScfiWeekl3(dto.getScfiWeekl3())
				.ScfiWeekl4(dto.getScfiWeekl4())
				.build();
	}

}
