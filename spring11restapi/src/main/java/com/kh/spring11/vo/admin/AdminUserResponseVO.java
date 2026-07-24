package com.kh.spring11.vo.admin;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name= "[관리자] 회원정보 복합검색 응답")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AdminUserResponseVO {
	private boolean last;
	private List<AccountSearchResultVO> list;
}
