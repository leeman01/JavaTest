package com.example.demo.entity;


import com.example.demo.dto.MarketingImageDto;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="marketing_image")
public class MarketingImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="image_path")
	private String imagePath;
	@ManyToOne // 난 이미지 여러개인줄알고 이거함 한개면 일대일로 설정하삼
	@JoinColumn(name="post_id") // 그래도 외래키는 여기있으니 네...
	private MarketingPostEntity postId;
	
	public static MarketingImageEntity ToEntity(MarketingImageDto dto) {
		return MarketingImageEntity.builder()
				.id(dto.getId())
				.imagePath(dto.getImagePath())
				.postId(dto.getPostId())
				.build();
	}
}
