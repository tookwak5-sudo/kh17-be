package com.kh.spring11.websocket.server;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;

import com.kh.spring11.dao.MessageDao;
import com.kh.spring11.service.JwtService;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.room.RoomChatMessageVO;
import com.kh.spring11.websocket.vo.WebSocketV4ChatVO;
import com.kh.spring11.websocket.vo.WebSocketV4RequestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebSocketV4GroupServer {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private MessageDao messageDao;
	
	//메세지가 오는 채널명 : /app/방번호/chat
	@MessageMapping("/{roomNo}/chat")
	public void group(
			@DestinationVariable int roomNo,
			@AuthenticationPrincipal Jwt jwt,
			Message<WebSocketV4RequestVO> message) {
		
		//인증 정보 복원
		TokenParseResponseVO parseVO = jwtService.parseAccessToken(jwt);
		
		// 메세지 처리 (헤더 + 바디)
		WebSocketV4RequestVO request = message.getPayload();
		
		//발신 메세지 생성1
		WebSocketV4ChatVO response = WebSocketV4ChatVO.builder()
					.senderId(parseVO.getAccountId())
					.senderLevel(parseVO.getAccountLevel())
					.senderNickname(parseVO.getAccountNickname())
					.content(request.getContent())
					.time(LocalDateTime.now())
				.build();
		
		//원래는 저장이 나중이지만 transactional을 설정해놨기 때문에 DB는 복원이 가능하나 발송은 복원이 안되기 때문에 db먼저 처리
		//DB 저장시점
		int messageNo = messageDao.sequence();
		messageDao.insertChat(RoomChatMessageVO.builder()
					.messageNo(messageNo)
					.messageRoom(roomNo)
					.messageType(response.getType())
					.messageSenderId(response.getSenderId())
					.messageSenderLevel(response.getSenderLevel())
					.messageSenderNickname(response.getSenderNickname())
					.messageTime(Timestamp.valueOf(response.getTime()))
					.messageContent(response.getContent())
				.build());
		
		simpMessagingTemplate.convertAndSend("/public/"+roomNo+"/chat", response);
	}
	
}
