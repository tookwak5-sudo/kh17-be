package com.kh.spring11.websocket.server;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;

import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.service.JwtService;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.websocket.vo.WebSocketV3ChatVO;
import com.kh.spring11.websocket.vo.WebSocketV3DmVO;
import com.kh.spring11.websocket.vo.WebSocketV3RequestVO;
import com.kh.spring11.websocket.vo.WebSocketV3SystemVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebSocketV3MemberServer {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AccountDao accountDao;
	
	//연습용 비속어 목록 //비동기화 방식 why? 조회만 하기 때문
	private Set<String> filters = Set.of(
			"수박", "시베리아", "신발끈", "개나리", "십장생"
	);
	
	@MessageMapping("/chat") //(/app/chat 이지만 /app은 공용주소라서 자동설정됨
	public void chat(
			//@CurrentUser TokenParseResponseVO parseVO, //안됨
			@AuthenticationPrincipal Jwt jwt,
			Message<WebSocketV3RequestVO> message) {
		TokenParseResponseVO parseVO = jwtService.parseAccessToken(jwt);
		log.debug("parseVO = {}", parseVO);
		
		//헤더 또는 페이로드(바디) 추출
		WebSocketV3RequestVO request = message.getPayload();
		
		//(+추가) 비속어 검사
		// - 미리 준비해둔 비속어 목록(or 서비스)에서 검사하여 문제가 있다고 판정되면
		// - 메세지 전송을 중지하고 발신자에게 시스템메세지를 발송
		String payload = request.getContent();
		for(String filter : filters) {
			if(payload.contains(filter)) {//욕설 포함된 경우
				//시스템 메세지 발송
				WebSocketV3SystemVO response = WebSocketV3SystemVO.builder()
							.content("욕설이나 비속어는 사용하실 수 없습니다")
							.level("danger")
							.time(LocalDateTime.now())
						.build();
				
				simpMessagingTemplate.convertAndSend(
						"/private/system"+parseVO.getAccountId(), response
				);
				return;
			}
		}
		
		
		
		//(+추가) DM인지 여부를 검사하여 별도로 처리
		if(isPrivateMessage(request.getContent())) { //DM이 맞다면
			//아이디 추출 + 존재 여부 검사 + DM 발송
			//DM일때 메세지 형식 : /w 아이디 메세지
			String cut = request.getContent().substring(3); //세 글자(/w ) 제거
			int space = cut.indexOf(" ");//첫 띄어쓰기 찾기
			String targetId = cut.substring(0, space);
			String content = cut.substring(space + 1);
			AccountDto targetDto = accountDao.selectOne(targetId); //대상 탐색 
			if(targetDto == null) return;
			
			//DM 메세지 생성
			WebSocketV3DmVO response = WebSocketV3DmVO.builder()
						.senderId(parseVO.getAccountId())
						.senderLevel(parseVO.getAccountLevel())
						.senderNickname(parseVO.getAccountNickname())
						.content(content) //기호와 아이디가 잘라내어진 컨텐츠
						.receiverId(targetDto.getAccountId())
						.receiverNickname(targetDto.getAccountNickname())
						.receiverLevel(targetDto.getAccountLevel())
						.time(LocalDateTime.now())
					.build();
			simpMessagingTemplate.convertAndSend("/private/dm/"+parseVO.getAccountId(), response);
			simpMessagingTemplate.convertAndSend("/private/dm/"+targetDto.getAccountId(), response);
			return;
		}
		
		//응답 메세지 생성
		WebSocketV3ChatVO response = WebSocketV3ChatVO.builder()
					.senderId(parseVO.getAccountId())
					.senderLevel(parseVO.getAccountLevel())
					.senderNickname(parseVO.getAccountNickname())
					.content(request.getContent())
					.time(LocalDateTime.now())
				.build();
		
		//최종 전송
		simpMessagingTemplate.convertAndSend("/public/chat", response);
	}
	
	private boolean isPrivateMessage(String content) {
		if(content == null) return false;
		if(content.toLowerCase().startsWith("/w ")) return true; //띄어쓰기가 있어야함 ("/w ") !!!!
		if(content.startsWith("/ㅈ")) return true;
		return false;
	}
	
}
