package com.kdigital.project.dto;

import com.kdigital.project.Entity.ExportingExportEntity;
import com.kdigital.project.Entity.ExportingProductEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ExportingProductDto {
	
	private Long id;
	private String description;
	private String hscode;
	private String quantity;
	private ExportingExportEntity exportId;
	
	public static  ExportingProductDto ToDto( ExportingProductEntity entity) {
		 return ExportingProductDto.builder()
		 .id(entity.getId())
		 .description(entity.getDescription())
		 .hscode(entity.getHscode())
		 .quantity(entity.getQuantity())
		 .exportId(entity.getExportId())
		 .build();
	}
}
