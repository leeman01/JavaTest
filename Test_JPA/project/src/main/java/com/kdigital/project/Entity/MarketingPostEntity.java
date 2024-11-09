package com.kdigital.project.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.kdigital.project.dto.MarketingPostDto;

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
@Table(name="marketing_post")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketingPostEntity {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column(name="product_name")
	private String productName;
	@Column
	private String content;
	@Column
	private String category;
	@Column
	private int moq;
	@Column(name="created_datetime")
	@CreationTimestamp
	private LocalDateTime createdDatetime;
	@Column(name="updated_datetime")
	@CreationTimestamp
	private LocalDateTime updatedDatetime;
	@Column(name="is_deleted")
	private String isDeleted;
	@ManyToOne
	@JoinColumn(name="user_id")
	private AuthUserEntity userId;
	
	public static MarketingPostEntity ToEntity(MarketingPostDto dto) {
		return MarketingPostEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.productName(dto.getProductName())
				.content(dto.getContent())
				.category(dto.getCategory())
				.moq(dto.getMoq())
				.createdDatetime(dto.getCreatedDatetime())
				.updatedDatetime(dto.getUpdatedDatetime())
				.isDeleted(dto.getIsDeleted())
				.userId(dto.getUserId())
				.build();
	}
}
