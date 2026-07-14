package com.kh.spring11.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test04암호화된회원가입 {
	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void test() {
		AccountDto accountDto = AccountDto.builder()
				.accountId("testuser2")
				.accountEmail("testuser2@kh.com")
				.accountPassword("Testuser2!")
				.accountNickname("테스트유저2")
			.build();
	
	accountDao.insert(accountDto);
	
	log.debug("등록 : {}", accountDto);
	}
}
