package com.kdigital.project.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="booking_shipment_billoflading")
@Setter 
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingShipmentBillofladingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="bl_number")
	private String blNumber;
	@Column(name="issue_date")
	private LocalDate issueDate;
	@Column(name="vessel_name")
	private String vesselName;
	@Column(name="loading_port")
	private String loadingPort;
	@Column(name="discharge_port")
	private String dischargePort;
	@Column(name="is_clean")
	private int isClean;
	@Column(name="is_endorsed")
	private int isEndorsed;
	@Column(name="insurance_policy_number")
	private String insurancePolicyNumber;
	@Column(name="file_path")
	private String filePath;
	@OneToOne
	@JoinColumn(name="request_quotation_id")
	private BookingShipmentRequestEntity requestId;
	

}
