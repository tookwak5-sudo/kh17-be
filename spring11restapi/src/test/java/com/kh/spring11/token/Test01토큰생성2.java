package com.kh.spring11.token;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import com.kh.spring11.configuration.JwtProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01토큰생성2 {
		
	@Autowired 
	private JwtEncoder jwtEncoder;
	@Autowired
	private JwsHeader jwsHeader;
	@Autowired
	private JwtProperties jwtProperties;
	@Test
	public void test() {
		//[2]
		Instant current = Instant.now();
		JwtClaimsSet claims = JwtClaimsSet.builder()
				//표준 데이터(규격)
				.issuer(jwtProperties.getIssuer()) //발행자 보통 홈페이지 주소를 작성(커스텀주소작성도 가능)
				.issuedAt(current) // 발급시각(탈취 당했을 때, 실재 쿠키와 시간을 동일하게 하여 설정)
				.expiresAt(
					current.plusSeconds(jwtProperties.getAccessTokenValidity())
				)// 만료시각(테스트용으로 60초)
				.subject("testuser1")//토큰의 소유자(유일한 항목) 규격을 맞추기 위해 아래와는 별개로 한번 더 써줌
				//커스텀 데이터	(꺼내쓴 정보)
				.claim("accountId", "testuser1")
				.claim("accountLevel", "브론즈")
				.claim("accountNickname", "테스트유저1")
				.build();
		
		//최종 생성
		String jwtToken = jwtEncoder
					.encode(JwtEncoderParameters.from(jwsHeader, claims))
					.getTokenValue();
		log.debug("jwt token = {}", jwtToken);
	}
}
