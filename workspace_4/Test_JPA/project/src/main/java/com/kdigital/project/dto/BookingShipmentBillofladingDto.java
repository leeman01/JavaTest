package com.kdigital.project.dto;

import java.time.LocalDate;

import com.kdigital.project.Entity.BookingShipmentBillofladingEntity;
import com.kdigital.project.Entity.BookingShipmentRequestEntity;

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

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookingShipmentBillofladingDto {

	private Long id;
	private String blNumber;
	private LocalDate issueDate;
	private String vesselName;
	private String loadingPort;
	private String dischargePort;
	private int isClean;
	private int isEndorsed;
	private String insurancePolicyNumber;
	private String filePath;
	private BookingShipmentRequestEntity requestId;
	
	public static BookingShipmentBillofladingDto ToDto(BookingShipmentBillofladingEntity entity) {
		return BookingShipmentBillofladingDto.builder()
				.id(entity.getId())
				.blNumber(entity.getBlNumber())
				.issueDate(entity.getIssueDate())
				.vesselName(entity.getVesselName())
				.loadingPort(entity.getLoadingPort())
				.dischargePort(entity.getDischargePort())
				.isClean(entity.getIsClean())
				.isEndorsed(entity.getIsEndorsed())
				.insurancePolicyNumber(entity.getInsurancePolicyNumber())
				.filePath(entity.getFilePath())
				.requestId(entity.getRequestId())
				.build();
				
	}
}
