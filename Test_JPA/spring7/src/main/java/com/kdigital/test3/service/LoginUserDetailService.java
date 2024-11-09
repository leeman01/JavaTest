package com.kdigital.test3.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kdigital.test3.dto.LoginUserDetails;
import com.kdigital.test3.dto.UserDTO;
import com.kdigital.test3.entity.UserEntity;
import com.kdigital.test3.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class LoginUserDetailService implements UserDetailsService {
	//userId 검증 로직 추가 DB 테이블에서 데이터를 가져옴
	// 사용지기 login을 하면 SecurityConfig 가로챈 휴 이쪽으로 데이터를 전달
	final UserRepository userReposiotory;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		UserEntity userEntity =  userReposiotory.findById(userId)
				.orElseThrow(()->{
					throw new UsernameNotFoundException("error 발생");
				});
		
		
		
		// TODO Auto-generated method stub
		 UserDTO userDTO = UserDTO.toDTO(userEntity);
		 
		 return new LoginUserDetails(userDTO);
	}

}
