package com.example.demo.entity;

import java.time.LocalDate;


import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.dto.OfDto;

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
@Table(name="booking_shipment_priceof")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfEntity {
	@Id
	@Column(name="of_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="prediction_date")
	@CreationTimestamp
	private LocalDate predictionDate;
	@Column(name="loading_port")
	private int loadingPort;
	@Column(name="discharge_port")
	private String unloadingPort;
	@Column(name="of_week_1")
	private double ofWeek1;
	@Column(name="of_week_2")
	private double ofWeek2;
	@Column(name="of_week_3")
	private double ofWeek3;
	@Column(name="of_week_4")
	private double ofWeek4;

	public static OfEntity ToEntity(OfDto dto) {
		return OfEntity.builder()
				.id(dto.getId())
				.predictionDate(dto.getPredictionDate())
				.unloadingPort(dto.getUnloadingPort())
				.ofWeek1(dto.getOfWeek1())
				.ofWeek2(dto.getOfWeek2())
				.ofWeek3(dto.getOfWeek3())
				.ofWeek4(dto.getOfWeek4())
				.build();
	}

}