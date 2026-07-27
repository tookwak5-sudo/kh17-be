package com.kh.spring11.vo.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="임시 비밀번호 응답")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AuthTempResponseVO {
	private boolean result;
	private String message;
}
