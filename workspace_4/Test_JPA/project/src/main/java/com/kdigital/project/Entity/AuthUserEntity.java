package com.kdigital.project.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.kdigital.project.dto.AuthUserDto;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String password;
	@Column(name="last_login")
	private LocalDateTime lastLogin;
	@Column(name="is_superuser")
	private int isSuperuser;
	@Column
	private String username;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column
	private String email;
	@Column(name="is_staff")
	private int isStaff;
	@Column(name="is_active")
	private int isActive;
	@Column(name="date_joined")
	@CreationTimestamp
	private LocalDateTime dateJoined;
	
	public static AuthUserEntity ToEntity(AuthUserDto dto) {
		return AuthUserEntity.builder()
				.id(dto.getId())
				.password(dto.getPassword())
				.isSuperuser(dto.getIsSuperuser())
				.username(dto.getUsername())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.email(dto.getEmail())
				.isStaff(dto.getIsStaff())
				.isActive(dto.getIsActive())
				.dateJoined(dto.getDateJoined())
				.build();
				
	}

}
