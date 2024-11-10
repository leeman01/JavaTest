package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.dto.MarketingInquiryDto;

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
@Table(name="marketing_inquiry")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketingInquiryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String title;
	@Column
	private String content;
	@Column(name="created_datetime")
	private LocalDateTime createdDatetime;
	@Column(name="updated_datetime")
	private LocalDateTime updatedDatetime;
	@Column(name="is_deleted")
	private String isDeleted;
	@ManyToOne
	@JoinColumn(name="post_id")
	private MarketingPostEntity postId;
	
	public static MarketingInquiryEntity ToEntity(MarketingInquiryDto dto) {
		return MarketingInquiryEntity.builder()
		.id(dto.getId())
		.email(dto.getEmail())
		.password(dto.getPassword())
		.title(dto.getTitle())
		.content(dto.getContent())
		.createdDatetime(dto.getCreatedDatetime())
		.updatedDatetime(dto.getUpdatedDatetime())
		.isDeleted(dto.getIsDeleted())
		.postId(dto.getPostId())
		.build();
	}

}
