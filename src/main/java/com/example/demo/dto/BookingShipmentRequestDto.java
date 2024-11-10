package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.BookingShipmentRequestEntity;
import com.example.demo.entity.ExportingExportEntity;

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
@AllArgsConstructor
@Builder
public class BookingShipmentRequestDto {

	private Long id;
	private String title;
	private LocalDateTime expectedShippingDate;
	private Long requestedContent;

	private LocalDateTime requestedDate;

	private Long repliedContent;

	private LocalDateTime repliedDate;

	private int isAccepted;

	private ExportingExportEntity exportId;
	private Long forwarderId;
	
	public static BookingShipmentRequestDto ToDto(BookingShipmentRequestEntity entity) {
		return BookingShipmentRequestDto.builder()
				.id(entity.getId())
				.title(entity.getTitle())
				.expectedShippingDate(entity.getExpectedShippingDate())
				.requestedContent(entity.getRequestedContent())
				.requestedDate(entity.getRequestedDate())
				.repliedContent(entity.getRepliedContent())
				.repliedDate(entity.getRepliedDate())
				.isAccepted(entity.getIsAccepted())
				.exportId(entity.getExportId())
				.forwarderId(entity.getForwarderId())
				.build();
	}
}
