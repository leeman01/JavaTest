package com.example.demo.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.handler.LoginFailureHandler;
import com.example.demo.handler.LoginSuccessHandler;
import com.example.demo.service.LoginUserDetailService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final LoginUserDetailService loginUserDetailService ;
	private final LoginFailureHandler failureHandler; 		//실패할 때 처리하는 객체(비밀번호 잘못입력)
	private final LoginSuccessHandler successsHandler;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    // 1. 요청에 관한 접근 권한 설정
	    http.authorizeHttpRequests((auth) -> auth
	        .requestMatchers(
	        		"/","/dong/ship","/user/join","/index/calendar",
	        		"/images/**",
	        		"/scss/**",
	        		"/css/**", 
	        		"/js/**",
	        		"/lib/**",
	        		"/video/**"
	        		).permitAll() // 인증 없이 접근 가능
	        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "USER") // /admin/** 경로는 ADMIN 또는 USER 역할만 접근 가능
	        .anyRequest().authenticated() // 기타 모든 요청은 인증 필요
	    );

	    // 2. 폼 로그인 설정 :  로그인 관련 요청은 Controller에서 처리하지않음
	    http.formLogin((auth) -> auth
	        .loginPage("/user/login") 				// 절대 경로로 설정
	        .failureHandler(failureHandler)
	        .successHandler(successsHandler) 		//  로그인 성공시 처리할 핸들러
	        .usernameParameter("username") 			// 로그인 폼에서 사용자명 필드 이름
	        .passwordParameter("password") 			// 로그인 폼에서 비밀번호 필드 이름
	        .loginProcessingUrl("/user/loginProc") 	// 로그인 처리 URL
//	        .defaultSuccessUrl("/") // 성공을 하건 실패를 하건 무조건 이동하는 곳이다  successhandler 가 등록되면 필요없다
	        .defaultSuccessUrl("/", true)
	        .permitAll() 							// 로그인 페이지 접근은 누구나 가능
	    );

	    // 3. 로그아웃 설정
	    http.logout((auth) -> auth
	        .logoutUrl("/user/logout") 		// 로그아웃 처리 URL
	        .logoutSuccessUrl("/") 			// 로그아웃 성공 시 이동할 URL
	        .invalidateHttpSession(true) 	// 세션 무효화하는 것은 
	    );

	    // 4.POST 요청시 CSRF 비활성화 (개발 시) 비활성화(개발 시)
	    http.csrf((auth) -> auth.disable());  // 302오류는CSRF 오류일 가능성이있다

	    // http 객체를 빌드하여 반환
	    return http.build();
	}

	
	// 비밀번호 암호화
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
