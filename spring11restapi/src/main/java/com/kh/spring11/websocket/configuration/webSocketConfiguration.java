package com.kh.spring11.websocket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//웹소켓 설정
//@EnableWebSocket //웹소켓을 서버에서 사용하는 것을 허용 (클래식 웹소켓)
@EnableWebSocketMessageBroker //STOMP의 사용을 허용
@Configuration
public class webSocketConfiguration implements WebSocketMessageBrokerConfigurer{
	//두 개의 메소드를 재정의
	
	//[1] 수신 발신 채널을 설정
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//모든 설정은 registry에 설정하기
				//endpoition 주소의 마지막 슬러시
				registry.addEndpoint("/ws") //클라이언트가 접속하려면  /ws로 해야한다(= 전화번호)
						.setAllowedOriginPatterns("*")//접속 가능한 클라이너트 설정 (=CORS)
						.withSockJS();//SockJS기술을 사용하도록 선언(웹소켓을 HTTP로 사용 가능하게 해줌)
	}
	
	//[2] 연결 설정
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//(1) 사용자가 메세지를 보낼 수 있는 채널을 설정 (/app/** 로 보내세요!)
		registry.setApplicationDestinationPrefixes("/app");
		
		//(2) 사용자가 메세지 수신을 위해 구독할 수 있는 대표 채널을 설정한다
		registry.enableSimpleBroker("/public", "/private");
	}
}
