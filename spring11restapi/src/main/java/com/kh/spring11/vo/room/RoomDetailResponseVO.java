package com.kh.spring11.vo.room;

import com.kh.spring11.dto.RoomDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "채팅방 상세 조회 데이터")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class RoomDetailResponseVO {
	private RoomDto room; //방 정보
}
