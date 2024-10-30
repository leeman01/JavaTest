package com.kdigital.project.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.kdigital.project.Entity.AuthUserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class AuthUserDto {
	
	private int id;
	private String password;
	private LocalDateTime lastLogin;
	private int isSuperuser;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private int isStaff;
	private int isActive;
	private LocalDateTime dateJoined;
	public static AuthUserDto toDto(AuthUserEntity entity) {
		return AuthUserDto.builder()
				.id(entity.getId())
				.password(entity.getPassword())
				.isSuperuser(entity.getIsSuperuser())
				.username(entity.getUsername())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.isStaff(entity.getIsStaff())
				.isActive(entity.getIsActive())
				.dateJoined(entity.getDateJoined())
				.build();
	}
}
