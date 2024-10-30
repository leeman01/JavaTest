package com.kdigital.project.dto;

import com.kdigital.project.Entity.ManagingDocumentPackglistEntity;
import com.kdigital.project.Entity.ManagingDocumentParentEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class ManagingDocumentPackglistDto {

	private Long id;
	private ManagingDocumentParentEntity entity;
	private String PackingListNumber;
	
	public static ManagingDocumentPackglistDto ToDto(ManagingDocumentPackglistEntity entity1) {
		return ManagingDocumentPackglistDto.builder()
				.id(entity1.getId())
				.entity(entity1.getEntity())
				.PackingListNumber(entity1.getPackingListNumber())
				.build();
	}
}
