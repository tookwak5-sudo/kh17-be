package com.kh.spring11.websocket.event;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.kh.spring11.service.FlashService;
import com.kh.spring11.service.JwtService;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.websocket.vo.WebSocketV3SystemVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebSocketEventHandler {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private FlashService flashService;
	
	//지정된 이벤트 상황이 발생하면 해당 메소드가 자동으로 실행되도록 설정
	@EventListener
	public void enter(SessionConnectEvent event) { //입장 이벤트
		log.debug("사용자 입장!");
		
		//사용자 정보 추출 (자동화를 쓰기 어려우며 직접 변환)
		Principal principal = event.getUser(); //인증정보 추출(추상화)
		//pricipal이 jwt형태가 아니면 반환 //다운캐스팅이 가능한 지 형태검사할 때 사용
		if(!(principal instanceof JwtAuthenticationToken)) return;  
		JwtAuthenticationToken auth = (JwtAuthenticationToken)principal;
		Jwt jwt = auth.getToken();
		TokenParseResponseVO parseVO = jwtService.parseAccessToken(jwt);
		
		//사용자 정보를 저장(인원수 계산)
		flashService.enter(parseVO); //인원수 계산하고
		simpMessagingTemplate.convertAndSend("/public/users", flashService.list()); //정보 보내기
		
		WebSocketV3SystemVO response = WebSocketV3SystemVO.builder()
					.content("[" +parseVO.getAccountNickname() + "] 님이 입장하셨습니다")
					.level("primary")
					.time(LocalDateTime.now())
				.build();
		
		simpMessagingTemplate.convertAndSend("/public/system", response);
	}
	
	@EventListener
	public void leave(SessionDisconnectEvent event) { //퇴장 이벤트
		log.debug("사용자 퇴장!");
		
		//사용자 정보 추출 (자동화를 쓰기 어려우며 직접 변환)
		Principal principal = event.getUser(); //인증정보 추출(추상화)
		//pricipal이 jwt형태가 아니면 반환 //다운캐스팅이 가능한 지 형태검사할 때 사용
		if(!(principal instanceof JwtAuthenticationToken)) return;  
		JwtAuthenticationToken auth = (JwtAuthenticationToken)principal;
		Jwt jwt = auth.getToken();
		TokenParseResponseVO parseVO = jwtService.parseAccessToken(jwt);
		
		//사용자 정보를 저장(인원수 계산)
		flashService.leave(parseVO);
		simpMessagingTemplate.convertAndSend("/public/users", flashService.list()); //정보 보내기
		
		WebSocketV3SystemVO response = WebSocketV3SystemVO.builder()
				.content("[" +parseVO.getAccountNickname() + "] 님이 퇴장하셨습니다")
				.level("primary")
				.time(LocalDateTime.now())
			.build();
		
		simpMessagingTemplate.convertAndSend("/public/system", response);
	}
	
	@EventListener
	public void subscribe(SessionSubscribeEvent event) { //구독 이벤트
		log.debug("사용자가 채널을 구독했습니다!");
		
		//구독한 채널의 이름을 알아내서 원하는 채널일 때 이벤트를 발생시키도록 처리
		//→ 채널의 이름은 destination이라고 부름
		//상태를 주고받음
		SimpMessageHeaderAccessor headerAccessor = 
				SimpMessageHeaderAccessor.wrap(event.getMessage());
		
		//사용자 정보 추출 (자동화를 쓰기 어려우며 직접 변환)
		Principal principal = event.getUser(); //인증정보 추출(추상화)
		//pricipal이 jwt형태가 아니면 반환 //다운캐스팅이 가능한 지 형태검사할 때 사용
		if(!(principal instanceof JwtAuthenticationToken)) return;  
		JwtAuthenticationToken auth = (JwtAuthenticationToken)principal;
		Jwt jwt = auth.getToken();
		TokenParseResponseVO parseVO = jwtService.parseAccessToken(jwt);
		
		String destination = headerAccessor.getDestination();
//		if(destination.equals("/public/users")) { //전체 사용자에게 
//			simpMessagingTemplate.convertAndSend("/public/users", flashService.list()); //정보 보내기
//		}
		
		if(destination.equals("/private/users/"+parseVO.getAccountId())) { //구독한 사람들한테만 한번 더 발송
			simpMessagingTemplate.convertAndSend("/private/users/"+parseVO.getAccountId(), flashService.list());
		}
	}
}
