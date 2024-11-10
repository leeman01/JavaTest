package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.entity.AuthUserEntity;
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
@NoArgsConstructor
@Builder
@ToString
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
	private LocalDate contractDate;
	private LocalDate deadlineDate;
	private LocalDateTime registeredDatetime;
	private int process;
	private String userId;
	

	public ExportingExportDto(Long id , String buyerCompanyName, String buyerCompanyAddress, String buyerCompanyTel,
			String buyerEmail, String incoterm, String paymentMethod, String placeOfLoading, String placeOfUnloading,
			LocalDate contractDate, LocalDate deadlineDate, LocalDateTime registeredDatetime, int process,String userId) {
		this.id=id;
		this.buyerCompanyName = buyerCompanyName;
		this.buyerCompanyAddress = buyerCompanyAddress;
		this.buyerCompanyTel = buyerCompanyTel;
		this.buyerEmail = buyerEmail;
		this.incoterm = incoterm;
		this.paymentMethod = paymentMethod;
		this.placeOfLoading = placeOfLoading;
		this.placeOfUnloading = placeOfUnloading;
		this.contractDate = contractDate;
		this.deadlineDate = deadlineDate;
		this.registeredDatetime = registeredDatetime;
		this.process = process;
		this.userId=userId;
		
	}
	public static  ExportingExportDto ToDto( ExportingExportEntity entity,String userId) {
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
				.userId(userId)
				.build();
	}

}
