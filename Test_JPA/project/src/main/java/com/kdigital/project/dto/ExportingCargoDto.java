package com.kdigital.project.dto;

import com.kdigital.project.Entity.ExportingCargoEntity;
import com.kdigital.project.Entity.ExportingExportEntity;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExportingCargoDto {

	private Long id;
	private String name;
	private double width;
	private double height;
	private String containerType;
	private String isDangerous;
	private ExportingExportEntity exportId;
	
	public static ExportingCargoEntity ToEntity(ExportingCargoDto dto) {
		return ExportingCargoEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.width(dto.getWidth())
				.height(dto.getHeight())
				.isDangerous(dto.getIsDangerous())
				.exportId(dto.getExportId())
				.build();
	}

}
