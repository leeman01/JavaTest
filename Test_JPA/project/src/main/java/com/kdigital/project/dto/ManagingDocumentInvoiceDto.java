package com.kdigital.project.dto;

import com.kdigital.project.Entity.ManagingDocumentInvoiceEntity;
import com.kdigital.project.Entity.ManagingDocumentParentEntity;

import jakarta.persistence.Column;
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
public class ManagingDocumentInvoiceDto {
	
	private int id;
	private ManagingDocumentParentEntity entity;
	private String invoiceNumber;
	
	public static  ManagingDocumentInvoiceDto ToDto( ManagingDocumentInvoiceEntity entity1) {
		return  ManagingDocumentInvoiceDto.builder()
				.id(entity1.getId())
				.entity(entity1.getEntity())
				.invoiceNumber(entity1.getInvoiceNumber())
				.build();
	}
}
