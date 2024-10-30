package com.kdigital.test3.handler;

import java.io.IOException;

import java.net.URLEncoder;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("로그인 실패");
		String errMessage="";
		
		if(exception instanceof BadCredentialsException) {
			errMessage  = exception.getMessage();
			errMessage+="아이디나 비밀번호가 잘못되었습니다.";
		}else {
			errMessage  = exception.getMessage();
			errMessage+="로그인에 실패했습니다 관리자에게 문의해주세요.";
		}
		errMessage = URLEncoder.encode(errMessage,"UTF-8");
		
		// get 방식으로 재요청
		setDefaultFailureUrl("/user/login?error=true&errMessage="+errMessage);
		super.onAuthenticationFailure(request, response, exception);
	}

}
