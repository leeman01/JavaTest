package com.kdigital.agxtest.dto;

import java.time.LocalDate;

import com.kdigital.agxtest.entity.GuestbookEntity;

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
public class GuestbookDTO {
	private Long seq;
	private String name;
	private String pwd;
	private String content;
	private LocalDate createDate;
	
	public static GuestbookDTO toDTO(GuestbookEntity entity) {
		return GuestbookDTO.builder()
				.seq(entity.getSeq())
				.name(entity.getName())
				.pwd(entity.getPwd())
				.content(entity.getContent())
				.createDate(entity.getCreateDate())
				.build();
	}
}