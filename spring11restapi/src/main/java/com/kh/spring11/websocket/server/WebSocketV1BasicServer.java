package com.kh.spring11.websocket.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller //등록은 컨트롤러지만 실제 역할은 웹소켓 서버
public class WebSocketV1BasicServer {
	
// 아주 간단한 통신서버 ecoserver라고 함
	// 1. 라이브러리 설정
	//2. stomp 설정 (채널기반으로 돌아가기 때문에 broker설정)
	//3. 주소 설정
	//4. 수신과 발송 채널 만들기
//	@RequestMapping("/basic")//웹에서의 HTTP 매핑 방식
	@MessageMapping("/basic")//웹소켓(STOMP)의 매핑 방식
	@SendTo("/public/basic")//메세지가 전송될 채널 지정
	public String basic(String message) {//사용자가 보낸 메세지를 수신
		log.debug("메세지 수신 = {}", message);
		return message; //사용자의 메세지를 그대로 전달
	}
}
