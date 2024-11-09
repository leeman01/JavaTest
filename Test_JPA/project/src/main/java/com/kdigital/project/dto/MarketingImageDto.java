package com.kdigital.project.dto;

import com.kdigital.project.Entity.MarketingImageEntity;
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
public class MarketingImageDto {
	
	private Long id;
	private String imagePath;
	private MarketingPostEntity postId;
	
	public static MarketingImageDto ToDto(MarketingImageEntity entity) {
		return MarketingImageDto.builder()
				.id(entity.getId())
				.imagePath(entity.getImagePath())
				.postId(entity.getPostId())
				.build();
	}
}
