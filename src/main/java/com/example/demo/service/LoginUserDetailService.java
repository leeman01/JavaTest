package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthUserDto;
import com.example.demo.dto.LoginUserDetails;
import com.example.demo.entity.AuthUserEntity;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUserDetailService implements UserDetailsService {
	final AuthUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthUserEntity user = userRepository.findById(username)
				.orElseThrow(()->{
					throw new UsernameNotFoundException("error 발생");
				});
				
		// TODO Auto-generated method stub
		AuthUserDto userDto= AuthUserDto.toDto(user);
		 
		 return new LoginUserDetails(userDto);
	}
	
	
}
