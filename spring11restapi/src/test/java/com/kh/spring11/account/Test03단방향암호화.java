package com.kh.spring11.account;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03단방향암호화 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//단방향 암호화 :
		//- 암호화만 가능하고 복호화는 불가능한 형태의 암호화 방식
		//- 얼마인지는 몰라도 비교는 가능하게 만듦
		
		String origin = "hello";
		
		//1. 복호화는 안되지만 매번 같은 값이 나오는 암호화
		//String hash = DigestUtils.sha256Hex(origin);
			
		//2. 복호화가 안되면서 매번 다른 값이 나오는 암호화
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
		log.debug("origin = {}", origin);		
		for(int i=0; i < 5; i++) {			
			String hash = encoder.encode(origin);
			log.debug("hash = {}", hash);
			//log.debug("hash.size() = {}", hash.length());
		}
		
	}
}
