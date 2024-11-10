package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.dto.BookingShipmentRequestDto;

import jakarta.annotation.Generated;
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
@Table(name="booking_shipment_requestquotation")
@Getter
@Setter
@Builder
public class BookingShipmentRequestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="expected_shipping_date")
	private LocalDateTime expectedShippingDate;
	@Column(name="requested_content")
	private Long requestedContent;
	@Column(name="requested_date")
	private LocalDateTime requestedDate;
	@Column(name="replied_content")
	private Long repliedContent;
	@Column(name="replied_date")
	private LocalDateTime repliedDate;
	@Column(name="is_accepted")
	private int isAccepted;
	@ManyToOne
	@JoinColumn(name="export_id")
	private ExportingExportEntity exportId;
	@Column(name="forwarder_id")
	private Long forwarderId;
	
	public static BookingShipmentRequestEntity ToEntity(BookingShipmentRequestDto dto) {
		return BookingShipmentRequestEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.expectedShippingDate(dto.getExpectedShippingDate())
				.requestedContent(dto.getRequestedContent())
				.requestedDate(dto.getRequestedDate())
				.repliedContent(dto.getRepliedContent())
				.repliedDate(dto.getRepliedDate())
				.isAccepted(dto.getIsAccepted())
				.exportId(dto.getExportId())
				.forwarderId(dto.getForwarderId())
				.build();
	}
}
