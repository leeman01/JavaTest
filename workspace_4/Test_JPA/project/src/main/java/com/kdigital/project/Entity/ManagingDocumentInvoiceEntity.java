package com.kdigital.project.Entity;

import com.kdigital.project.dto.ManagingDocumentInvoiceDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name="managing_document_invoice")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagingDocumentInvoiceEntity {
	@Id
	@Column
	private int id;
	
	@OneToOne
	@JoinColumn(name="document_ptr_id")
	private ManagingDocumentParentEntity entity;
	
	@Column(name="invoice_number",nullable=false,unique = true)
	private String invoiceNumber;
	
	public static  ManagingDocumentInvoiceEntity ToEntity( ManagingDocumentInvoiceDto dto) {
		return  ManagingDocumentInvoiceEntity.builder()
				.id(dto.getId())
				.entity(dto.getEntity())
				.invoiceNumber(dto.getInvoiceNumber())
				.build();
	}
}
