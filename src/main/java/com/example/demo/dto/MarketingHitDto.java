package com.example.demo.dto;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.entity.MarketingHitEntity;
import com.example.demo.entity.MarketingPostEntity;

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
public class MarketingHitDto {

	private Long id;
	private LocalDateTime createdDatetime;
	private MarketingPostEntity postId;
	
	public static MarketingHitDto ToDto(MarketingHitEntity entity) {
		return MarketingHitDto.builder()
				.id(entity.getId())
				.createdDatetime(entity.getCreatedDatetime())
				.postId(entity.getPostId())
				.build();
	}
}
