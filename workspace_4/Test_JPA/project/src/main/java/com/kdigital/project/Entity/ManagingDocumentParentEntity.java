package com.kdigital.project.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.kdigital.project.dto.ManagingDocumentParentDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="managing_document_document")
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagingDocumentParentEntity {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="issue_date")
	private LocalDate issueDate;
	@Column(name="is_paid")
	private int isPaid;
	
	@OneToOne
	@JoinColumn(name="export_id",nullable=false)
	private ExportingExportEntity exportId;
	
	public static ManagingDocumentParentEntity ToEntity(ManagingDocumentParentDto dto) {
		return ManagingDocumentParentEntity.builder()
				.id(dto.getId())
				.issueDate(dto.getIssueDate())
				.isPaid(dto.getIsPaid())
				.exportId(dto.getExportId())
				.build();
	}
	
}
