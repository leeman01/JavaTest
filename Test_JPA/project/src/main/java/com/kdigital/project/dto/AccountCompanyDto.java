package com.kdigital.project.dto;

import com.kdigital.project.Entity.AccountCompanyEntity;
import com.kdigital.project.Entity.AuthUserEntity;

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
public class AccountCompanyDto {

	private Long id;
	private String name;
	private String address;
	private String type ; // enum으로 할려다 참음 ==> 해달라하면 해줌
	private String registrationNo;
	private String signatureImage;
	private String country;
	private AuthUserEntity userId;

	public static AccountCompanyDto toDTO(AccountCompanyEntity accountCompanyEntity) {
		return AccountCompanyDto.builder()
				.id(accountCompanyEntity.getId())
				.name(accountCompanyEntity.getName())
				.address(accountCompanyEntity.getAddress())
				.type(accountCompanyEntity.getType())
				.registrationNo(accountCompanyEntity.getRegistrationNo())
				.signatureImage(accountCompanyEntity.getSignatureImage())
				.country(accountCompanyEntity.getCountry())
				.userId(accountCompanyEntity.getUserId())
				.build();
	}
}
