package com.example.demo.entity;

import com.example.demo.dto.DocumentationExportDeclarationDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="managing_document_exportdeclaration")
@Setter
@Getter
@Builder
public class DocumentationExportDeclarationEntity  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name="document_ptr_id")
	private ManagingDocumentParentEntity entity;
	
	@Column(name="export_declaration_number")
	private String exportNum;
	
	
	public static DocumentationExportDeclarationEntity ToEntity(DocumentationExportDeclarationDto dto) {
		return DocumentationExportDeclarationEntity.builder()
				.id(dto.getId())
				.entity(dto.getEntity())
				.exportNum(dto.getExportNum())
				.build();
	}

}
