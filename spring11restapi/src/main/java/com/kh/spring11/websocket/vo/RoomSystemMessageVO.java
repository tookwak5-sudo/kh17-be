package com.kh.spring11.websocket.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//message + message_System테이블에 접근하기 위한 VO
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class RoomSystemMessageVO {
	private int messageNo;
	private int messageRoom;
	private String messageType;
	private String messageContent;
	private String messageLevel;
	private Timestamp messageTime;
}
