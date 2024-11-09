package com.kdigital.spring6.entity;

import java.time.LocalDate;

import com.kdigital.spring6.dto.Friend;

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
import lombok.ToString;

@NoArgsConstructor // 기본생성자
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name="friend")
public class FriendEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // autoincrement 설정
	private Integer fseq;
	@Column(name="fname",nullable=false) // table의 notnull 제약조건이 걸렷을 때
	private String fname;
	@Column(name="age")
	private Integer age ;
	@Column(name="phone")
	private String phone ;
	@Column(name="birthday")
	private LocalDate birthday;
	@Column(name="active")
	private boolean active ;
	// DTO를 받아서 Entity로 변환하는 Bulder를 생성 => insert할 때 데이터를 전달하거나 데이터베이스에 접근해서 update할때 entity
	public static FriendEntity toEntity(Friend friend) {
		// 객체생성방법중 하나로 builder 이용
		return FriendEntity.builder()
				.fseq(friend.getFseq())
				.fname(friend.getFname())
				.age(friend.getAge())
				.phone(friend.getPhone())
				.birthday(friend.getBirthday())
				.active(friend.isActive())
				.build();
		
	}
	

}
