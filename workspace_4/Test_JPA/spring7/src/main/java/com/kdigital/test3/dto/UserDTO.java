package com.kdigital.test3.dto;

import com.kdigital.test3.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserDTO {
	private String userId ;
	private String userName;
	private String userPwd;
	private String email;
	private String roles;
	private Boolean enabled;
	// Entity를 받아서 DTO로 변환하는 메소드
	public static UserDTO toDTO(UserEntity userEntity) {
		return UserDTO.builder()
				.userId(userEntity.getUserId())
				.userName(userEntity.getUserName())
				.userPwd(userEntity.getUserPwd())
				.email(userEntity.getEmail())
				.roles(userEntity.getRoles())
				.enabled(userEntity.getEnabled())
				.build();
	}
}
