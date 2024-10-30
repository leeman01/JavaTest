package com.kdigital.project.Entity;

import java.time.LocalDateTime;

import com.kdigital.project.dto.ExportingExportDto;

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
@Table(name="exporting_export")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportingExportEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="buyer_company_name")
	private String buyerCompanyName;
	@Column(name="buyer_company_address")
	private String  buyerCompanyAddress;
	@Column(name="buyer_company_tel")
	private String buyerCompanyTel;
	@Column(name="buyer_email")
	private String buyerEmail;
	@Column(name="buyer_country")
	private String buyerCountry;
	@Column
	private String incoterm;
	@Column(name="payment_method")
	private String paymentMethod;
	@Column(name="place_of_loading")
	private String placeOfLoading;
	@Column(name="place_of_unloading")
	private String placeOfUnloading;
	@Column(name="contract_date")
	private LocalDateTime contractDate;
	@Column(name="deadline_date")
	private LocalDateTime deadlineDate;
	@Column(name="registered_datetime")
	private LocalDateTime registeredDatetime;
	@Column
	private int process;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private AuthUserEntity userId;
	
	public static  ExportingExportEntity ToEntity( ExportingExportDto dto) {
		return  ExportingExportEntity.builder()
				.id(dto.getId())
				.buyerCompanyName(dto.getBuyerCompanyName())
				.buyerCompanyAddress(dto.getBuyerCompanyAddress())
				.buyerCompanyTel(dto.getBuyerCompanyTel())
				.buyerEmail(dto.getBuyerEmail())
				.incoterm(dto.getIncoterm())
				.paymentMethod(dto.getPaymentMethod())
				.placeOfLoading(dto.getPlaceOfLoading())
				.placeOfUnloading(dto.getPlaceOfUnloading())
				.contractDate(dto.getContractDate())
				.deadlineDate(dto.getDeadlineDate())
				.registeredDatetime(dto.getRegisteredDatetime())
				.process(dto.getProcess())
				.userId(dto.getUserId())
				.build();
	}

}
