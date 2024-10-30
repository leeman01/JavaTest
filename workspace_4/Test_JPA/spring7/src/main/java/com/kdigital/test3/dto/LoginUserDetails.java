package com.kdigital.test3.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j 
public class LoginUserDetails implements UserDetails {
	private static final long serialVersionUID= 1L;
	private String userId ;
	private String userName;
	private String userPwd;
	private String email;
	private String roles;
	private Boolean enabled;
	
	// 생성자
	public LoginUserDetails(UserDTO userDTO) {
		this.userId = userDTO.getUserId();
		this.userPwd = userDTO.getUserPwd();
		this.userName=userDTO.getUserName();
		this.email = userDTO.getEmail();
		this.roles=userDTO.getRoles();
		this.enabled = userDTO.getEnabled();
		
	}
	// 사용자의 Role정보 반환
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {
			private static final long serialVersionUID= 1L;
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return roles;
			}
		});
		return collection; 			
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userPwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userId ;
	}
	
	// 사용자정의 메서드(뷰단에서 사용할 사용자의 실명 이름)
	public String getUserName() {
		return this.userName ;
	}

}
