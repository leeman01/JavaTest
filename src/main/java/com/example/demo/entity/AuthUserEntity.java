package com.example.demo.entity;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.dto.AuthUserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="auth_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserEntity {
	@Id
	private String username;
	@Column
	private String password;
	@Column(name="last_login")
	private LocalDateTime lastLogin;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column
	private String email;
	@Column(name="register_company_name")
	private String registerCompanyName;
	@Column(name="register_company_id")
	private String registerCompanyId;
	@Column(name="date_joined")
	@CreationTimestamp
	private LocalDateTime dateJoined;
	@Column(name="roles")
	private String roles;
	@Column(name="enabled")
	private String enabled;
	
	// 그럼여기서 파일이 저장된 경로를 알아야겟네
	@Column(name="file_path")
	private String filePath;
	
	public static AuthUserEntity ToEntity(AuthUserDto dto) {
		return AuthUserEntity.builder()
				.username(dto.getUsername())
				.password(dto.getPassword())
				.username(dto.getUsername())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.email(dto.getEmail())
				.roles(dto.getRoles())
				.enabled(dto.getEnabled())
				.dateJoined(dto.getDateJoined())
				.registerCompanyName(dto.getRegisterCompanyName())
				.registerCompanyId(dto.getRegisterCompanyId())
				.filePath(dto.getFilePath())
				.build();
				
	}

}
