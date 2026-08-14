package com.kh.spring11.dao;

import com.kh.spring11.websocket.vo.RoomChatMessageVO;
import com.kh.spring11.websocket.vo.RoomSystemMessageVO;

public interface MessageDao {
	int sequence();
	void insertChat(RoomChatMessageVO message);
	void insertSystem(RoomSystemMessageVO message);
}
