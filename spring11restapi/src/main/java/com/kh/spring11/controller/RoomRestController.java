package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CurrentUser;
import com.kh.spring11.dao.RoomDao;
import com.kh.spring11.dto.RoomDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.room.RoomCreateRequestVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name= "방을 만들어요")

@RestController
@RequestMapping("/api/room") //api주소를 가지고 제공해주는 하나의 서비스
public class RoomRestController {
	@Autowired
	private RoomDao roomDao;
	
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
	
	@GetMapping("/")
	public List<RoomDto> list() {
		return roomDao.selectList();
	}
}
