package com.kh.spring11.vo.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//들어오는거에 json처리를 하고 보통 여기서는 내가 직접 만들기 때문에 처리할 필요 없음
@Schema(name= "로그인 처리 응답 데이터")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AuthLoginResponseVO {
	private String accountId;
	private String accountLevel;
	private String accountNickname;
	private String accountBlock;
	
	private boolean needUpdate;
}
