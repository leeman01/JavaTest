package com.example.demo.entity;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.dto.MarketingHitDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="marketing_hit")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingHitEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="created_datetime")
	@CreationTimestamp
	private LocalDateTime createdDatetime;
	@ManyToOne
	@JoinColumn(name="post_id")
	private MarketingPostEntity postId;
	
	public static MarketingHitEntity ToEntity(MarketingHitDto dto) {
		return MarketingHitEntity.builder()
				.id(dto.getId())
				.createdDatetime(dto.getCreatedDatetime())
				.postId(dto.getPostId())
				.build();
	}
}
