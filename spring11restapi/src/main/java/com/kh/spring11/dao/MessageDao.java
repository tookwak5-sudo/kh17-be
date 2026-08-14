package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.vo.message.MessageVO;
import com.kh.spring11.vo.room.RoomChatMessageVO;
import com.kh.spring11.vo.room.RoomMessageRequestVO;
import com.kh.spring11.vo.room.RoomSystemMessageVO;

public interface MessageDao {
	int sequence();
	void insertChat(RoomChatMessageVO message);
	void insertSystem(RoomSystemMessageVO message);
	
	List<MessageVO> selectList(int messageRoom);
	List<MessageVO> selectList(int messageRoom, int size);
	List<MessageVO> selectList(int messageRoom, int size, int lastMessageNo);
	
	List<MessageVO> selectList(int messageRoom, RoomMessageRequestVO request);
	int count(int messageRoom, RoomMessageRequestVO request);
}
