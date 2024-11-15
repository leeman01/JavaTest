package com.example.demo.entity;


import com.example.demo.dto.AccountCompanyDto;
import com.mysql.cj.jdbc.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_company")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountCompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String type ; // enum으로 할려다 참음 ==> 해달라하면 해줌
	@Column(name="registration_no")
	private String registrationNo;
	@Lob
    @Column(name = "signature_image")
    private byte[] signatureImage;  // BLOB 필드 추가
	@Column
	private String country;
	
	@OneToOne
	@JoinColumn(name="user_id")
	
	
	private AuthUserEntity userId;
	public static AccountCompanyEntity toEntity(AccountCompanyDto accountCompanyDto) {
		return AccountCompanyEntity.builder()
				.id(accountCompanyDto.getId())
				.name(accountCompanyDto.getName())
				.address(accountCompanyDto.getAddress())
				.type(accountCompanyDto.getType())
				.registrationNo(accountCompanyDto.getRegistrationNo())
				.signatureImage(accountCompanyDto.getSignatureImage())
				.country(accountCompanyDto.getCountry())
				.build();
	}
}
