package com.kdigital.jpa03.entity;

import java.time.LocalDate;

import org.hibernate.internal.build.AllowSysOut;

import jakarta.persistence.Column;
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

@Entity
@Table(name="hotel_1")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Hotel {
	@Id
	@Column(name="hotel_id")
	private String hotelId;
	private String name;
	@Column(name="created_date")
	private LocalDate createdDate;
	@Enumerated(EnumType.STRING)
	private Grade grade;
}
