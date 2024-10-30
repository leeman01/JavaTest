package com.kdigital.project.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.kdigital.project.Entity.AuthUserEntity;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketingPostDto {

	private Long id;
	private String title;
	private String productName;
	private String content;
	private String category;
	private int moq;
	private LocalDateTime createdDatetime;
	private LocalDateTime updatedDatetime;
	private String isDeleted;
	private AuthUserEntity userId;
	
	public static MarketingPostEntity ToDto(MarketingPostEntity entity) {
		return MarketingPostEntity.builder()
				.id(entity.getId())
				.title(entity.getTitle())
				.productName(entity.getProductName())
				.content(entity.getContent())
				.category(entity.getCategory())
				.moq(entity.getMoq())
				.createdDatetime(entity.getCreatedDatetime())
				.updatedDatetime(entity.getUpdatedDatetime())
				.isDeleted(entity.getIsDeleted())
				.userId(entity.getUserId())
				.build();
	}
	
	
}
