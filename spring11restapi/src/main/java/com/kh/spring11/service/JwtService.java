package com.kh.spring11.service;

import org.springframework.stereotype.Service;

import com.kh.spring11.vo.account.TokenCreateRequestVO;
import com.kh.spring11.vo.account.TokenParseResponseVO;

@Service
public class JwtService {
	
	//토큰 생성 메소드 
	public String createToken(TokenCreateRequestVO request) {
		return "?";
	}
	
	//토큰 해석 메소드
	public TokenParseResponseVO parseToken(String token) {
		return null;
	}
}
