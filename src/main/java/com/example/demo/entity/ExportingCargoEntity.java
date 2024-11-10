package com.example.demo.entity;


import com.example.demo.dto.ExportingCargoDto;

import groovy.transform.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="exporting_cargo")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	@Column
	private double length;
	@Column(name="container_type")
	private String containerType;
	@Column(name="is_dangerous")
	private String isDangerous;
	@Column 
	private double weight;
	@Column
	private int quantity;
	@OneToOne
	@JoinColumn(name="export_id")
	private ExportingExportEntity exportId;
	
	public static ExportingCargoEntity ToEntity(ExportingCargoDto dto,ExportingExportEntity entity) {
		return ExportingCargoEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.width(dto.getWidth())
				.height(dto.getHeight())
				.length(dto.getLength())
				.isDangerous(dto.getIsDangerous())
				.weight(dto.getWeight())
				.quantity(dto.getQuantity())
				.exportId(entity)
				.containerType(dto.getContainerType())
				.build();
	}

}
