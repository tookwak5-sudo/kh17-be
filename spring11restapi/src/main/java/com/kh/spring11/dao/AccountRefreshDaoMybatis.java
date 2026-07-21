package com.kh.spring11.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.AccountRefreshDto;

@Repository
public class AccountRefreshDaoMybatis implements AccountRefreshDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertOrUpdate(AccountRefreshDto accountRefreshDto) { //mybatis에서는 네이밍홀더를 쓰기 때문에 굳이 id를 ㅂ낼 필요없이 dto보냄 된다
		AccountRefreshDto findDto = sqlSession.selectOne("mapper.accountRefresh.find", accountRefreshDto);
		if(findDto == null) { //없으니까 insert
			sqlSession.insert("mapper.accountRefresh.add", accountRefreshDto);
		}
		else { //잇으니까 update
			sqlSession.update("mapper.accountRefresh.change", accountRefreshDto);
		}
	}
	@Override
	public void delete(AccountRefreshDto accountRefreshDto) {
		sqlSession.delete("mapper.accountRefresh.delete", accountRefreshDto);
	}

	@Override
	public AccountRefreshDto find(AccountRefreshDto accountRefreshDto) {
		return sqlSession.selectOne("mapper.accountRefresh.find", accountRefreshDto);
	}

}
