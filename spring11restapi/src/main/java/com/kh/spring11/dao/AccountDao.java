package com.kh.spring11.dao;

import com.kh.spring11.dto.AccountDto;

public interface AccountDao {
	void insert(AccountDto accountDto);
	
	AccountDto selectOne(String accountId);
	
	boolean checkAvailableId(String accountId);
	boolean checkAvailableNickname(String accountNickname);
	boolean checkAvailableEmail(String accountEmail);
	//최종 로그인 시각 갱신
	boolean updateAccountLogin(String accountId);
	
	//입력된 아이디의 비밀번호 가져오기
	String checkAccountPassword(String accountId);
	
	//비밀번호 변경하기 + vo를 만들어서 필요한 정보만 가져오는건 응집도를 높이는 행위가 될 수 있으나 너무 불필요한 작업(Swagger에 보이지 않는 정보이므로 Dto를 가져온다)
	boolean updateAccountPassword(AccountDto accountDto); 
	
	boolean updateAll(AccountDto accountDto);
}
