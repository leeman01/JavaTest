package com.kdigital.project.dto;

import java.time.LocalDateTime;

import com.kdigital.project.Entity.MarketingInquiryEntity;
import com.kdigital.project.Entity.MarketingPostEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketingInquiryDto {
	
	private Long id;
	private String email;
	private String password;
	private String title;
	private String content;
	private LocalDateTime createdDatetime;
	private LocalDateTime updatedDatetime;
	private String isDeleted;
	private MarketingPostEntity postId;
	
	public static MarketingInquiryDto ToDto(MarketingInquiryEntity entity) {
		return MarketingInquiryDto.builder()
		.id(entity.getId())
		.email(entity.getEmail())
		.password(entity.getPassword())
		.title(entity.getTitle())
		.content(entity.getContent())
		.createdDatetime(entity.getCreatedDatetime())
		.updatedDatetime(entity.getUpdatedDatetime())
		.isDeleted(entity.getIsDeleted())
		.postId(entity.getPostId())
		.build();
	}
}
