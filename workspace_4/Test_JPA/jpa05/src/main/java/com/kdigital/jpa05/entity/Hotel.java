package com.kdigital.jpa05.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="hotel_05")
public class Hotel {
	@Id
	@Column(name="hotel_id")
	private String hotelId;
	private String name;
	@Column(name="created_date")
	private LocalDate createdDate;
	@Enumerated(EnumType.STRING)
	private Grade grade;
	
	// address 클래스를 포함
	@Embedded  // 이 class는 다른곳에 포함될수있다는 의미료 embedded를 사용한다
	private Address address;
}
