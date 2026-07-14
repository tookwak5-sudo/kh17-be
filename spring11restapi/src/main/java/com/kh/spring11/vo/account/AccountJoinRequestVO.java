package com.kh.spring11.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//회원가입 요청용 VO //내가 만드는게 아니라 가입자가 만드는 거기 때문에 builder를 만들지 않는다
@Schema(name = "회원가입 정보 객체")
@Data
public class AccountJoinRequestVO {
	private String accountId;
	private String accountEmail;
	private String accountPassword;
	private String accountNickname;
	private String accountBirth;
	private String accountContact;
	private String accountPost, accountAddress1, accountAddress2;
	private String accountMessage;
}
