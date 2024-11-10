package com.example.demo.dto;

import com.example.demo.entity.BookingShipmentForwarderEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BookingShipmentForwarderDto {

	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String description;
	private double rating;
	
	public static BookingShipmentForwarderDto ToDto(BookingShipmentForwarderEntity entity) {
		return BookingShipmentForwarderDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.description(entity.getDescription())
				.rating(entity.getRating())
				.build();
	}
}
