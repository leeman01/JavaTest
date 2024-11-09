package com.kdigital.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booking_shipment_forwarder")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingShipmentForwarderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String email;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column
	private String description;
	@Column 
	private double rating;
	public static BookingShipmentForwarderEntity ToEntity(BookingShipmentForwarderEntity entity) {
		return BookingShipmentForwarderEntity.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.description(entity.getDescription())
				.rating(entity.getRating())
				.build();
				
	}

}
