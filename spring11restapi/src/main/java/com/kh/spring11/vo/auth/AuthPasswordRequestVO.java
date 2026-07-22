package com.kh.spring11.vo.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "기존 비밀번호 정보 객체")
@Data
public class AuthPasswordRequestVO {
	private String accountCurrentPassword;
	private String accountNewPassword;
}
