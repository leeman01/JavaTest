package com.kdigital.diary.dto;

import java.time.LocalDate;

import com.kdigital.diary.entity.UserEntity;

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
@Builder
public class UserDTO {
	private int diarySeq;
	private String userName;
	private String feeling;
	private String title;
	private String records;
	private LocalDate regdate;
	public static UserDTO toUserDTO(UserEntity userEntity) {
		return UserDTO.builder()
				.diarySeq(userEntity.getDiarySeq())
				.userName(userEntity.getUserName())
				.feeling(userEntity.getFeeling())
				.title(userEntity.getTitle())
				.records(userEntity.getRecords())
				.regdate(userEntity.getRegdate())
				.build();
	}
}
