package com.kh.spring11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.vo.account.ChangeAccountRequestVO;
import com.kh.spring11.vo.admin.AccountSearchResultVO;
import com.kh.spring11.vo.admin.AdminUserRequestVO;
import com.kh.spring11.vo.admin.AccountBlockRequestVO;

@Repository
public class AccountDaoMybatis implements AccountDao{
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void insert(AccountDto accountDto) {
		//사용자가 입력한 암호를 BCrypt 방식으로 암호화하여 재설정 후 등록
		String origin = accountDto.getAccountPassword(); //원래 비밀번호
		String encrypt = passwordEncoder.encode(origin); //암호화된 비밀번호
		accountDto.setAccountPassword(encrypt); //암호화된 비밀번호를 dto에 넣고
		sqlSession.insert("mapper.account.join", accountDto); // 비밀번호가 암호화된 DTO를 DB에 저장
	}

	@Override
	public AccountDto selectOne(String accountId) {
		return sqlSession.selectOne("mapper.account.find", accountId);
	}

	@Override
	public boolean checkAvailableId(String accountId) {
		int count = sqlSession.selectOne("mapper.account.countAccountId", accountId);
		return count == 0;
	}

	@Override
	public boolean checkAvailableNickname(String accountNickname) {
		int count = sqlSession.selectOne("mapper.account.countAccountNickname", accountNickname);
		return count == 0;
	}

	@Override
	public boolean checkAvailableEmail(String accountEmail) {
		int count = sqlSession.selectOne("mapper.account.countAccountEmail", accountEmail);
		return count == 0;
	}

	@Override
	public boolean updateAccountLogin(String accountId) {
		int rows = sqlSession.update("mapper.account.updateAccountLogin", accountId);
		return rows > 0;
	}

	@Override
	public String checkAccountPassword(String accountId) {
		return sqlSession.selectOne("mapper.account.checkAccountPassword", accountId);
	}

	@Override
	public boolean updateAccountPassword(AccountDto accountDto) {
		//비밀번호 암호화 처리
		String origin = accountDto.getAccountPassword();
		String encrypt = passwordEncoder.encode(origin);
		accountDto.setAccountPassword(encrypt);
		int rows = sqlSession.update("mapper.account.updateAccountPassword", accountDto);
		return rows > 0;
	}

	@Override
	public boolean updateAll(AccountDto accountDto) {
		return sqlSession.update("mapper.account.updateAll", accountDto) > 0;
	}
	
	@Override
	public List<AccountSearchResultVO> complexSearch(AdminUserRequestVO request) {
		return sqlSession.selectList("mapper.account.complexSearch", request);
	}
	@Override
	public int complexSearchCount(AdminUserRequestVO request) {
		return sqlSession.selectOne("mapper.account.complexSearchCount", request);
	}

//	@Override
//	public boolean updateAccountBlock(AccountBlockRequestVO request) {
//		return sqlSession.update("mapper.account.updateAccountBlock", request) > 0;
//	}
	
	@Override
	public boolean updateAccountBlock(AccountDto accountDto) {
		return sqlSession.update("mapper.account.block", accountDto) > 0;
	}

	@Override
	public boolean updateAccountChange(String accountId) {
		return sqlSession.update("mapper.account.remindMeLater", accountId) > 0;
	}




}
