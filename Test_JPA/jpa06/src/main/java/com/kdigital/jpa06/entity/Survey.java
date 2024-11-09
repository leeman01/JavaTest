package com.kdigital.jpa06.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.annotation.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
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
@Table(name="survey")
public class Survey {
	@Id
	private String id;
	private String name;
	@OneToMany
	@JoinColumn(name="survey_id")
	@OrderColumn(name="order_no")
	
	private List<Question> questions = new ArrayList<>();
}
