package com.kh.spring11.websocket.server;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.kh.spring11.websocket.vo.WebSocketV3RequestVO;
import com.kh.spring11.websocket.vo.WebSocketV3ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebSocketV3MemberServer {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/chat") //(/app/chat 이지만 /app은 공용주소라서 자동설정됨
	public void chat(Message<WebSocketV3RequestVO> message) {
		//헤더 또는 페이로드(바디) 추출
		WebSocketV3RequestVO request = message.getPayload();

		//응답 메세지 생성
		WebSocketV3ResponseVO response = WebSocketV3ResponseVO.builder()
					.content(request.getContent())
					.time(LocalDateTime.now())
				.build();
		
		//최종 전송
		simpMessagingTemplate.convertAndSend("/public/chat", response);
	}
}
