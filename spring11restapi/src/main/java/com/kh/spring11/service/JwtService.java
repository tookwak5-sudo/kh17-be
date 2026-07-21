package com.kh.spring11.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwtValidationException;
import org.springframework.stereotype.Service;

import com.kh.spring11.configuration.JwtProperties;
import com.kh.spring11.vo.jwt.TokenCreateRequestVO;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;

@Service
public class JwtService {
	
	@Autowired 
	private JwtEncoder jwtEncoder;
	@Autowired
	private JwsHeader jwsHeader;
	@Autowired
	private JwtProperties jwtProperties;
	@Autowired
	private JwtDecoder jwtDecoder;
	
	//액세스 토큰 생성 메소드 
	public String createAccessToken(TokenCreateRequestVO request) {
		//토큰 발생시각을 객체로 생성
		Instant current = Instant.now();
		
		//JWT에 추가할 데이터 본문을 생성
		JwtClaimsSet claims = JwtClaimsSet.builder()
			//표준 데이터 - iss, iat, exp, sub
			.issuer(jwtProperties.getIssuer())
			.issuedAt(current)
			.expiresAt(current.plusSeconds(jwtProperties.getTokenValidity()))
			//커스텀데이터 - 마음대로
			.claim("accountId", request.getAccountId())
			.claim("accountLevel", request.getAccountLevel())
			.claim("accountNickname", request.getAccountNickname())
			.build();
		
		return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims))
				.getTokenValue();
	}
	
	//액세스 토큰 해석 메소드
	public TokenParseResponseVO parseAccessToken(String token) throws JwtValidationException {
		//오류검사 후 정보추출 (문제가 생기면 JwtValidationException 발생) 
		Jwt jwt = jwtDecoder.decode(token); 
		return TokenParseResponseVO.builder()
					.accountId(jwt.getClaimAsString("accountId"))
					.accountNickname(jwt.getClaimAsString("accountNickname"))
					.accountLevel(jwt.getClaimAsString("accountLevel"))
				.build();
	}
	
	//리프레시 토큰 생성 메소드
	
	//리프레시 토큰 해석 메소드
}
