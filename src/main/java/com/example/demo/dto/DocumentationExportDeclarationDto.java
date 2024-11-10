package com.example.demo.dto;


import com.example.demo.entity.DocumentationExportDeclarationEntity;
import com.example.demo.entity.ManagingDocumentParentEntity;

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

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DocumentationExportDeclarationDto {

	private Long id;
	private ManagingDocumentParentEntity entity;
	private String exportNum;
	
	public static DocumentationExportDeclarationDto ToDto(DocumentationExportDeclarationEntity entity1) {
		return DocumentationExportDeclarationDto.builder()
				.id(entity1.getId())
				.entity(entity1.getEntity())
				.exportNum(entity1.getExportNum())
				.build();
	}
}
