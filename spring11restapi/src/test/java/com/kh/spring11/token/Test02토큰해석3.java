package com.kh.spring11.token;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.service.JwtService;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02토큰해석3 {
	@Autowired
	private JwtService jwtService;
	
	@Test
	public void test() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy5raGFjYWRlbXkuY28ua3IvIiwiYWNjb3VudElkIjoidGVzdHVzZXIxIiwiYWNjb3VudE5pY2tuYW1lIjoi7YWM7Iqk7Yq47Jyg7KCAMSIsImV4cCI6MTc4NDU5NDU5MCwiYWNjb3VudExldmVsIjoi67iM66Gg7KaIIiwiaWF0IjoxNzg0NTk0NTMwfQ.3smY1MSEltXpDf06kqufjJv8ydBrc-cgizd1Qjv-WJ8";
		
		TokenParseResponseVO response = jwtService.parseToken(token);
		
		//- 커스텀 정보 출력: accountId, accountNickname, accountLevel
		log.debug("accountId = {}", response.getAccountId());
		log.debug("accountNickname = {}", response.getAccountNickname());
		log.debug("accountLevel = {}", response.getAccountLevel());
	}
}
