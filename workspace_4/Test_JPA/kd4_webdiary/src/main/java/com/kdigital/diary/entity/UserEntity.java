package com.kdigital.diary.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.kdigital.diary.dto.UserDTO;

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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Builder
@Table(name="diary")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="diary_seq")
	private int diarySeq;
	@Column(name="username",nullable=false)
	private String userName;
	private String feeling;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String records;
	@CreationTimestamp
	private LocalDate regdate;
	
	public static UserEntity toEntity(UserDTO userDTO) {
		return UserEntity.builder()
				.diarySeq(userDTO.getDiarySeq())
				.userName(userDTO.getUserName())
				.feeling(userDTO.getFeeling())
				.title(userDTO.getTitle())
				.records(userDTO.getRecords())
				.regdate(userDTO.getRegdate())
				.build();
		
	}
	
}
