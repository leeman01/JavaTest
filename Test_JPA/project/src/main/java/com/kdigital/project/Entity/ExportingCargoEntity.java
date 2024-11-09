package com.kdigital.project.Entity;

import com.kdigital.project.dto.ExportingCargoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="exporting_cargo")
@Setter
@Getter
@Builder
public class ExportingCargoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column 
	private String name;
	@Column
	private double width;
	@Column
	private double height;
	@Column(name="container_type")
	private String containerType;
	@Column(name="is_dangerous")
	private String isDangerous;
	@ManyToOne
	@JoinColumn(name="export_id")
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
