package com.kh.spring11.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring11.vo.message.MessageVO;
import com.kh.spring11.vo.room.RoomChatMessageVO;
import com.kh.spring11.vo.room.RoomMessageRequestVO;
import com.kh.spring11.vo.room.RoomSystemMessageVO;

import jakarta.validation.Valid;

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

	@Override
	public List<MessageVO> selectList(int messageRoom) {
//		return sqlSession.selectList("mapper.message.selectTest", messageRoom);
		Map<String, Object> params = new HashMap<>();
		params.put("messageRoom", messageRoom);
		return sqlSession.selectList("mapper.message.selectMessages", params);
	}

	@Override
	public List<MessageVO> selectList(int messageRoom, int size) {
		Map<String, Object> params = new HashMap<>();
		params.put("messageRoom", messageRoom);
		params.put("size", size);
		return sqlSession.selectList("mapper.message.selectMessages", params);
	}

	@Override
	public List<MessageVO> selectList(int messageRoom, int size, int lastMessageNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("messageRoom", messageRoom);
		params.put("size", size);
		params.put("lastMessageNo", lastMessageNo);
		return sqlSession.selectList("mapper.message.selectMessages", params);
	}


	@Override
	public List<MessageVO> selectList(int messageRoom, @Valid RoomMessageRequestVO request) {
		Map<String, Object> params = new HashMap<>();
		params.put("messageRoom", messageRoom);
		params.put("size", request.getSize());
		params.put("lastMessageNo", request.getLastMessageNo());
		return sqlSession.selectList("mapper.message.selectMessages", params);
	}

	@Override
	public int count(int messageRoom, @Valid RoomMessageRequestVO request) {
		Map<String, Object> params = new HashMap<>();
		params.put("messageRoom", messageRoom);
		params.put("lastMessageNo", request.getLastMessageNo());
		return sqlSession.selectOne("mapper.message.countMessages", params);
	}

}
