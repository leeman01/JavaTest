package com.kdigital.project.Entity;

import com.kdigital.project.dto.ManagingDocumentCertificateoriginDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="managing_document_certificateorigin")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagingDocumentCertificateoriginEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="document_ptr_id")
	private ManagingDocumentParentEntity entity;
	
	@Column(name="certificate_origin_number")
	private String certificateOriginNumber;
	
	public static ManagingDocumentCertificateoriginEntity ToEntity(ManagingDocumentCertificateoriginDto dto) {
		return ManagingDocumentCertificateoriginEntity.builder()
				.id(dto.getId())
				.entity(dto.getEntity())
				.certificateOriginNumber(dto.getCertificateOriginNumber())
				.build();
	}

}
