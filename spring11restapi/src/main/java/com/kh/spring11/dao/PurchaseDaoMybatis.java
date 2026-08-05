package com.kh.spring11.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.PurchaseDetailDto;
import com.kh.spring11.dto.PurchaseDto;

@Repository
public class PurchaseDaoMybatis implements PurchaseDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int purchaseSequence() {
		return sqlSession.selectOne("mapper.purchase.purchaseSequence");
	}

	@Override
	public void purchaseInsert(PurchaseDto purchaseDto) {
		sqlSession.insert("mapper.purchase.purchaseInsert", purchaseDto);
	}

	@Override
	public int purchaseDetailSequence() {
		return sqlSession.selectOne("mapper.purchase.purchaseDetailSequence");
	}

	@Override
	public void purchaseDetailInsert(PurchaseDetailDto purchaseDetailDto) {
		sqlSession.insert("mapper.purchase.purchaseDetailInsert", purchaseDetailDto);
	}

}
