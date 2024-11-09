package com.kdigital.jpa01.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // 자카르다로 import해야함
@Entity
@Table(name= "mysuer")
public class User { // 테이블과 데이터 베이스 이름이 다르다 그래서 위와 같이 알려주는 과정이 필요하다
	@Id
	private String email;
	private String name;
	@Column(name="join_date")
	private LocalDateTime joinDate; // 테이블 컬럼명과 데이터의 이름이 다르다
	
	public User() {
		super();
	}

	public User(String email, String name, LocalDateTime joinDate) {
		super();
		this.email = email;
		this.name = name;
		this.joinDate = joinDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	
}
