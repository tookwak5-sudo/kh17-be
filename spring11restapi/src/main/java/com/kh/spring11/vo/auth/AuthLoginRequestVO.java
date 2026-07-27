package com.kh.spring11.vo.auth;


import lombok.Data;

@Data
//@JsonIgnoreProperties //항상 고려해주기
public class AuthLoginRequestVO {
	private String accountId;
	private String accountPassword;
}