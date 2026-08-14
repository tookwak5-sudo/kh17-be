package com.kh.spring11.vo.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = true) // 상속받은 클래스 정보와의 일치여부까지 고려하는 지를 설정해줌
public class ChatMessageVO extends MessageVO {
	private int no;
	private String senderId;
	private String senderLevel;
	private String senderNickname;
}
