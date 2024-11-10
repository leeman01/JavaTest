package com.example.demo.dto;


import com.example.demo.entity.ExportingCargoEntity;
import com.example.demo.entity.ExportingExportEntity;

import groovy.transform.ToString;
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
@ToString
public class ExportingCargoDto {

	private Long id;
	private String name;
	private double width;
	private double height;
	private double length;
	private String containerType;
	private double weight;
	private int quantity;
	private String isDangerous;
	private Long exportId;
	
	public static ExportingCargoDto ToDto(ExportingCargoEntity entity,Long exportId2) {
		return ExportingCargoDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.width(entity.getWidth())
				.height(entity.getHeight())
				.length(entity.getLength())
				.isDangerous(entity.getIsDangerous())
				.weight(entity.getWeight())
				.quantity(entity.getQuantity())
				.exportId(exportId2)
				.containerType(entity.getContainerType())
				.build();
	}

}
