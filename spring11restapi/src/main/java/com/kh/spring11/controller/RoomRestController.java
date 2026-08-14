package com.kh.spring11.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.message.TimestampMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CurrentUser;
import com.kh.spring11.dao.MessageDao;
import com.kh.spring11.dao.RoomDao;
import com.kh.spring11.dto.RoomDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.room.RoomCreateRequestVO;
import com.kh.spring11.vo.room.RoomDetailResponseVO;
import com.kh.spring11.vo.room.RoomEnterRequestVO;
import com.kh.spring11.vo.room.RoomEnterResponseVO;
import com.kh.spring11.vo.room.RoomListResponseVO;
import com.kh.spring11.vo.room.RoomListVO;
import com.kh.spring11.vo.room.RoomUserVO;
import com.kh.spring11.websocket.vo.RoomSystemMessageVO;
import com.kh.spring11.websocket.vo.WebSocketV4SystemVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name= "방을 만들어요")

@RestController
@RequestMapping("/api/room") //api주소를 가지고 제공해주는 하나의 서비스
public class RoomRestController {
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private MessageDao messageDao;
	
	@ApiResponse(responseCode = "200", description = "방 생성 성공")
	@PostMapping("/")
	public void createRoom(
			@Valid @RequestBody RoomCreateRequestVO request,
			@CurrentUser TokenParseResponseVO parseVO) {
		int roomNo = roomDao.sequence();
		String roomOwner = parseVO.getAccountId();
		
		roomDao.insert(RoomDto.builder()
					.roomNo(roomNo)
					.roomOwner(roomOwner)
					.roomName(request.getName())
					.roomLimit(request.getLimit())
				.build());
	}
	
	@DeleteMapping("/{roomNo}")
	public void deleteRoom(@PathVariable int roomNo, @CurrentUser TokenParseResponseVO parseVO) {
		RoomDto roomDto = roomDao.selectOne(roomNo);
		if(roomDto == null) throw new TargetNotfoundException();
		
		String roomOwner = roomDto.getRoomOwner(); //null일 수 있음
		//잘못된 식 (roomOwner가 null일 수 있음 nullpoint exception) 왼쪽은 null이 오면 안됨
		//if(roomOwner.equals(parseVO.getAccountId()));
		//제대로된 식
		if(!parseVO.getAccountId().equals(roomOwner)) { //제대로된 식
			throw new GetOutException();
			
		}
	}
	
//	@GetMapping("/")
//	public List<RoomDto> list() {
//		return roomDao.selectList();
//	}
	
	@GetMapping("/")
	public RoomListResponseVO list(
			//security filter chain에서 permitAll()로 처리된 경우만 null이 가능
			@CurrentUser TokenParseResponseVO parseVO) {
		
		List<RoomListVO> rooms = parseVO != null ? 
				roomDao.selectList(parseVO.getAccountId()) //있으면 로그인
				: roomDao.selectList(); //없으면 일반유저
		
		return RoomListResponseVO.builder()
					.count(rooms.size())
					.rooms(rooms)
				.build();
	}
	
	//방 상세
	@GetMapping("/{roomNo}")
	public RoomDetailResponseVO detail(@PathVariable int roomNo,
						@CurrentUser TokenParseResponseVO parseVO) {
		
		//방이 있는 지 검사 → 404
		RoomDto roomDto = roomDao.selectOne(roomNo);
		if(roomDto == null) throw new TargetNotfoundException();
		
		//참여자 중에 사용자가 존재하는 지 검사 → 403
//		List<String> members = roomDao.getMembers(roomNo);
//		if(!members.contains(parseVO.getAccountId())) throw new GetOutException();
		
		List<RoomUserVO> users =roomDao.getMemberInfo(roomNo); //id, 등급, 닉네임
		if(users.stream() //유저중에서
				.map(user->user.getAccountId()) //아이디만 꺼냈는데
				.noneMatch(accountId->accountId.equals(parseVO.getAccountId())) ) { //하나도 없으면
			throw new GetOutException(); //나가
		}
		
		//응답 생성 및 반환
		return RoomDetailResponseVO.builder()
					.room(roomDto) //방정보
					.users(users) //유저목록
				.build();
	}
	
	//방 참여 코드
	@PostMapping("/enter")
	public RoomEnterResponseVO enter(
			@Valid @RequestBody RoomEnterRequestVO request,
			@CurrentUser TokenParseResponseVO parseVO) {
		//방 존재 여부 검사
		RoomDto roomDto = roomDao.selectOne(request.getRoomNo());
		if(roomDto == null) throw new TargetNotfoundException();
		
		//이미 참여중인지 검사
		List<String> members = roomDao.getMembers(request.getRoomNo());
		if(members.contains(parseVO.getAccountId())) {//이미 참여중이면
			return RoomEnterResponseVO.builder()
						.result(true)
						.message("이미 참여중인 방입니다")
					.build();
		}
		
		
		//인원제한 걸려있는 지 검사
		if(roomDto.getRoomLimit() != null && 
				roomDto.getRoomLimit() == members.size()) {
			return RoomEnterResponseVO.builder()
					.result(false)
					.message("해당 방의 정원이 모두 찼습니다")
				.build();
		}
		
		//(+미래) 차단테이블이 따로 있다면 차단테이블을 조회해서 자격 여부를 판정
		
		//참여처리
		roomDao.enter(request.getRoomNo(), parseVO.getAccountId());
		LocalDateTime current = LocalDateTime.now();
		
		//메세지 생성
		WebSocketV4SystemVO response = WebSocketV4SystemVO.builder()
				.content("["+parseVO.getAccountNickname()+"] 님이 입장하셨습니다")
				.level("primary")
				.time(current)
		.build();
		
		//DB저장 처리
		int messageNo = messageDao.sequence();
		messageDao.insertSystem(RoomSystemMessageVO.builder()
					.messageNo(messageNo)
					.messageRoom(request.getRoomNo())
					.messageType(response.getType())
					.messageContent(response.getContent())
					.messageTime(Timestamp.valueOf(response.getTime()))
					.messageLevel(response.getLevel())
				.build());
		
		//*** 중요 ***
		//simpMessaging만 있으면 아무데서나 웹소켓을 보낼 수 있다
		//enter가 발생하고 나서 (DB에 참여처리가 완료되고 나서) 웹소켓으로 인원변동을 알림
		List<RoomUserVO> users = roomDao.getMemberInfo(request.getRoomNo());
		simpMessagingTemplate.convertAndSend(
			"/public/"+request.getRoomNo()+"/users", users
		);
		
		//해당 방에 입장 메세지 발송
		simpMessagingTemplate.convertAndSend(
				"/public/" + request.getRoomNo() + "/system", response);
		
		//응답 반환 데이터
		return RoomEnterResponseVO.builder()
					.result(true)
					.message(request.getRoomNo()+"번 채팅방에 입장하셨습니다")
				.build();
	}
	
}
