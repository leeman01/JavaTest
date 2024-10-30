package com.kdigital.test3.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("로그인 성공이랄까");
		List<String> roleNames = new ArrayList<>();
		authentication.getAuthorities().forEach((auth)->{
			roleNames.add(auth.getAuthority());
		});
		log.info("{}",roleNames);
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
		}else if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/"); // 성공이건 실패건 무조건 루트로 돌아가기만들기	
			return;
		}
		
	}

}
