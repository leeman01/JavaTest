package com.example.demo.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.entity.AuthUserEntity;

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
	// 여기서 수정해야 할건  AccountCompanyDto가 있는데 굳이 회사정보를 추가했다는 점
	@Id
	private String username;
	private String password;
	private LocalDateTime lastLogin;
	private String firstName;
	private String lastName;
	private String email;
	private String registerCompanyName;
	private String registerCompanyId;
	private LocalDateTime dateJoined;
	private String roles;
	private String enabled;
	
	// 그럼여기서 파일이 저장된 경로를 알아야겟네
	@Column(name="file_path")
	private String filePath;
	
	public static AuthUserDto toDto(AuthUserEntity entity) {
		return AuthUserDto.builder()
				.username(entity.getUsername())
				.password(entity.getPassword())
				.username(entity.getUsername())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.roles(entity.getRoles())
				.enabled(entity.getEnabled())
				.dateJoined(entity.getDateJoined())
				.registerCompanyName(entity.getRegisterCompanyName())
				.registerCompanyId(entity.getRegisterCompanyId())
				.filePath(entity.getFilePath())
				.build();
	}
}
