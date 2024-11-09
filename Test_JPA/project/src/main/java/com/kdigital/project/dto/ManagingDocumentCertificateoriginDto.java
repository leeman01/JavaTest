package com.kdigital.project.dto;

import com.kdigital.project.Entity.ManagingDocumentCertificateoriginEntity;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagingDocumentCertificateoriginDto {
	
	private Long id;
	private ManagingDocumentParentEntity entity;
	private String certificateOriginNumber;
	
	public static ManagingDocumentCertificateoriginDto ToDto(ManagingDocumentCertificateoriginEntity entity1) {
		return ManagingDocumentCertificateoriginDto.builder()
				.id(entity1.getId())
				.entity(entity1.getEntity())
				.certificateOriginNumber(entity1.getCertificateOriginNumber())
				.build();
	}
}
