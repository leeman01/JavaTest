package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import groovy.transform.ToString;
import groovy.util.logging.Slf4j;
import lombok.Setter;

@ToString
@Slf4j
@Setter
public class LoginUserDetails implements  UserDetails {
	private static final long serialVersionUID= 1L;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDateTime dateJoined;
	private LocalDateTime lastLogin;
	private String registerCompanyName;
	private String registerCompanyId;
	private String filePath;
	private String roles;
	private String enabled;
	
	// 생성자
	public LoginUserDetails(AuthUserDto userDto) {
		this.password = userDto.getPassword();
		this.username = userDto.getUsername();
		this.email    = userDto.getEmail();
		this.roles    = userDto.getRoles();
		this.enabled  = userDto.getEnabled();
		
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
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username ;
	}
	
	// ---------- 사용자 화먼에서 보여줄 정보
	// 뷰단에서 사용할 사용자의 실명 이름
	public String getFirstName() {
		return this.firstName ;
	}

	public LocalDateTime getLastLogin() {
		return this.lastLogin;
	}
}
