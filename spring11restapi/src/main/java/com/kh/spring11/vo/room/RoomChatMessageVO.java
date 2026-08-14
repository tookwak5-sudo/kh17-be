package com.kh.spring11.vo.room;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//message + message_chat 테이블에 접근하기 위한VO
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class RoomChatMessageVO {
	private int messageNo;
	private int messageRoom;
	private String messageType;
	private String messageContent;
	private String messageSendId, messageSenderNickname, messageSenderLevel;
	private Timestamp messageTime;
}
