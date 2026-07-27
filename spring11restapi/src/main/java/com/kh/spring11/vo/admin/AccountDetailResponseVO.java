package com.kh.spring11.vo.admin;

import java.sql.Timestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="관리자 상세페이지 응답")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountDetailResponseVO {
	private String accountId;
	private String accountEmail;
//	private String accountPassword;
	private String accountNickname;
	private String accountBirth;
	private String accountContact;
	private String accountPost, accountAddress1, accountAddress2;
	private String accountLevel;
	private String accountMessage;
	private Timestamp accountJoin, accountLogin, accountChange; // 최종 비밀번호 변경일 
	private String accountBlock;
	private int accountPoint;
}
