package com.kdigital.jpa02.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor  // 생성자 자동만들기 => 롬복 
@NoArgsConstructor // 기본생성자만들기
@Setter
@Getter
@ToString

@Entity
@Table(name ="members")
public class Member {
	@Id
	private String email;
	private String name;
	private int age;
	private LocalDate birthday;
	
}
