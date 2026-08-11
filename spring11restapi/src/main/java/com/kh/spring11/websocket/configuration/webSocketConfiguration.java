package com.kh.spring11.websocket.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.messaging.context.AuthenticationPrincipalArgumentResolver;
import org.springframework.security.messaging.context.SecurityContextChannelInterceptor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//웹소켓 설정
//@EnableWebSocket //웹소켓을 서버에서 사용하는 것을 허용 (클래식 웹소켓)
@EnableWebSocketMessageBroker //STOMP의 사용을 허용
@Configuration
public class webSocketConfiguration implements WebSocketMessageBrokerConfigurer{
	//두 개의 메소드를 재정의
	
	//[1] 연결 설정
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//모든 설정은 registry에 설정하기
				//endpoition 주소의 마지막 슬러시
				registry.addEndpoint(
							"/ws", //클라이언트가 접속하려면  /ws로 해야한다(= 전화번호) 
							"/ws-member" 
							/*회원 전용 접속 주소 이렇게 구분하는 이유는 security가 관리하는 cookie에 모든 정보가 들어있음 이 방식을 웹소켓에서도 사용하고 싶은데, 
							 웹소켓하고 http는 기본적으로 프로토콜이 달라서 http에서 사용되는 방법을 웹소켓에서 사용하는 것이 일반적으로 불가능 하지만,
							 두 방식이 교차하는 시점이 존재하는데 그 순간에(handshakeinterceptor?) 정보를 교환하게 하는 방법을 통해 설정
							 */ 
						) 
						.setAllowedOriginPatterns("*")//접속 가능한 클라이너트 설정 (=CORS)
						.withSockJS();//SockJS기술을 사용하도록 선언(웹소켓을 HTTP로 사용 가능하게 해줌)
	}
	
	//[2] 수신 발신 채널을 설정
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//(1) 사용자가 메세지를 보낼 수 있는 채널을 설정 (/app/** 로 보내세요!)
		registry.setApplicationDestinationPrefixes("/app");
		
		//(2) 사용자가 메세지 수신을 위해 구독할 수 있는 대표 채널을 설정한다
		// -/public/** - 공개된 메세지가 오고가는 채널
		// -/private/** - 비공개 메세지가 오고가는 채널
		registry.enableSimpleBroker("/public", "/private");
	}
	
	//@Current를 가져오지 못하기 때문에 직접 2가지 도구를 설정해줘야함

	//[1]클라이언트에서 서버로 들어오는 STOMP 메세지의 채널 설정
	// → SecurityContextChannelInterceptor를 설정해서 웹소켓 메세지의 사용자 정보를 복원
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		//교차지점 간섭해서 데이터를 가져오는 방법
		registration.interceptors(new SecurityContextChannelInterceptor());
	}
	//[2]@AuthenticationPrincipal과 같은 애노테이션을 이용한 자동 해석이 가능하도록 도구를 설정
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new AuthenticationPrincipalArgumentResolver());
	}
}
