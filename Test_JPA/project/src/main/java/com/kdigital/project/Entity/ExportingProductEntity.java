package com.kdigital.project.Entity;

import com.kdigital.project.dto.ExportingProductDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="exporting_product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExportingProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String description;
	@Column
	private String hscode;
	@Column
	private String quantity;
	@Column(name="price_per_unit")
	private double pricePerUnit;
	@ManyToOne
	@JoinColumn(name="export_id")
	private ExportingExportEntity exportId;
	
	public static  ExportingProductEntity ToEntity( ExportingProductDto dto) {
		 return ExportingProductEntity.builder()
		 .id(dto.getId())
		 .description(dto.getDescription())
		 .hscode(dto.getHscode())
		 .quantity(dto.getQuantity())
		 .exportId(dto.getExportId())
		 .build();
	}
}
