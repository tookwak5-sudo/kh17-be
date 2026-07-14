package com.kh.spring11.account;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02양방향암호화테스트 {
	
	//Spring-Security 시스템에서 제공하는 암호화 도구들을 사용해보기
	//1. 프로젝트에 Spring Security를 추가 (문제점: 일반 설정 시, 이제까지 만들어 놓은 mapping이 다 잠기는 문제가 발생)
	//2. 프로젝트 전체가 Spring Security 때문에 잠기는 것을 막도록 설정
	//3. 그 후, 필요한 암호화 도구들을 가져다가 사용
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//양방향 암호화 : 암호화(encryption)와 복호화(decryption)가 가능한 방식
		
		//암호화와 복호화에 사용될 열쇠(key)
		String key = "kh-academy";
		
		//salt : 암호화에 사용될 양념(변조과정을 눈치챌 수 없도록 만드는 보조값) //16진수로 만드는 것을 권장
		String salt = "1234567890abcdef";
		
		//양방향 암호화 도구를 생성
		TextEncryptor encryptor = Encryptors.delux(key, salt);
		
		//원본 문자열 준비
		String origin = "https://www.naver.com";
		
		//암호화
		String encrypt = encryptor.encrypt(origin);
		
		//복호화
		String decrypt = encryptor.decrypt(encrypt);
		
		//출력
		log.debug("origin {}", origin);
		log.debug("encrypt {}", encrypt);
		log.debug("decrypt {}", decrypt);
	}
}
