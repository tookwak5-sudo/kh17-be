package com.kh.spring11.dao;

import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.vo.auth.AuthLoginRequestVO;
import com.kh.spring11.vo.auth.AuthPasswordChangeVO;

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
	
	//비밀번호 변경하기
	boolean changeAccountPassword(AuthPasswordChangeVO passwordChange);
}
