package com.kh.spring11.vo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AuthPasswordChangeVO {
	private String accountId;
	private String accountPassword;
}
