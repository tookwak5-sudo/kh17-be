package com.kh.spring11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.CartDto;
import com.kh.spring11.vo.purchase.CartItemVO;

@Repository
public class CartDaoMybatis implements CartDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertOrUpdate(CartDto cartDto) {
		CartDto findDto = sqlSession.selectOne("mapper.cart.find", cartDto);
		
		 System.out.println("cartDto = " + cartDto);
		if(findDto == null) { // 처음
			sqlSession.insert("mapper.cart.add", cartDto);
		}
		else { //두번째 이상
			findDto.setCartQty(findDto.getCartQty() + cartDto.getCartQty()); //원래수량 + 추가 수량
			sqlSession.update("mapper.cart.change", findDto);
		}
	}

	@Override
	public CartDto selectOne(CartDto cartDto) {
		return sqlSession.selectOne("mapper.cart.find", cartDto);
	}

	@Override
	public List<CartItemVO> selectList(String cartOwner) {
		return sqlSession.selectList("mapper.cart.list", cartOwner);
	}

}
