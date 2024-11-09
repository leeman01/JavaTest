package com.kdigital.project.dto;

import java.time.LocalDateTime;

import com.kdigital.project.Entity.AuthUserEntity;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExportingExportDto {
	
	private Long id;
	private String buyerCompanyName;
	private String  buyerCompanyAddress;
	private String buyerCompanyTel;
	private String buyerEmail;
	private String incoterm;
	private String paymentMethod;
	private String placeOfLoading;
	private String placeOfUnloading;
	private LocalDateTime contractDate;
	private LocalDateTime deadlineDate;
	private LocalDateTime registeredDatetime;
	private int process;
	private AuthUserEntity userId;
	
	public static  ExportingExportDto ToDto( ExportingExportEntity entity) {
		return  ExportingExportDto.builder()
				.id(entity.getId())
				.buyerCompanyName(entity.getBuyerCompanyName())
				.buyerCompanyAddress(entity.getBuyerCompanyAddress())
				.buyerCompanyTel(entity.getBuyerCompanyTel())
				.buyerEmail(entity.getBuyerEmail())
				.incoterm(entity.getIncoterm())
				.paymentMethod(entity.getPaymentMethod())
				.placeOfLoading(entity.getPlaceOfLoading())
				.placeOfUnloading(entity.getPlaceOfUnloading())
				.contractDate(entity.getContractDate())
				.deadlineDate(entity.getDeadlineDate())
				.registeredDatetime(entity.getRegisteredDatetime())
				.process(entity.getProcess())
				.userId(entity.getUserId())
				.build();
	}
	
}
