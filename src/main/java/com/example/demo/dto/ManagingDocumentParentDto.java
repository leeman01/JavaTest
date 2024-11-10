package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.ExportingExportEntity;
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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagingDocumentParentDto {

	private Long id;
	private LocalDate issueDate;
	private int isPaid;
	private ExportingExportEntity exportId;
	
	public static ManagingDocumentParentDto ToDto(ManagingDocumentParentEntity entity) {
		return ManagingDocumentParentDto.builder()
				.id(entity.getId())
				.issueDate(entity.getIssueDate())
				.isPaid(entity.getIsPaid())
				.exportId(entity.getExportId())
				.build();
	}
}
