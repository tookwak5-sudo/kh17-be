package com.kh.spring11.vo.message;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MessageVO {
	private int messageNo;
	private int messageRoom;
	private String messageType;
	private String messageContent;
	private Timestamp messageTime;
}
