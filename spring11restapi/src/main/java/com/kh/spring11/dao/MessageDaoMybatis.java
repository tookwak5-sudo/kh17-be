package com.kh.spring11.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring11.vo.room.RoomChatMessageVO;
import com.kh.spring11.vo.room.RoomSystemMessageVO;

@Repository
public class MessageDaoMybatis implements MessageDao {
		
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int sequence() {
		//로그 쉽게 찍기위해 mapper.message라고 함 안그러면 테이블마다 db설정 다르게 해줘야함/ mapper.*로 가능
		return sqlSession.selectOne("mapper.message.sequence"); 
	}
	
	@Transactional
	@Override
	public void insertChat(RoomChatMessageVO message) {
		sqlSession.insert("mapper.message.add", message);
		sqlSession.insert("mapper.message.addChat", message);
	}
	
	@Transactional
	@Override
	public void insertSystem(RoomSystemMessageVO message) {
		sqlSession.insert("mapper.message.add", message);
		sqlSession.insert("mapper.message.addSystem", message);
	}

}
