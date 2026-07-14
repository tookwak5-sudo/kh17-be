package com.kh.spring11.vo.account;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//회원가입 응답용 VO //내가 만들어내는거기 때문에 builder를 만들어 준다
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountJoinResponseVO {
	private String accountId;
	private String accountEmail;
//	private String accountPassword; 노출시킬 필요가 없기 때문에 비밀번호 제거
	private String accountNickname;
	private String accountBirth;
	private String accountContact;
	private String accountPost, accountAddress1, accountAddress2;
	private String accountLevel;
	private String accountMessage;
	private Timestamp accountJoin, accountLogin, accountChange; // 최종 비밀번호 변경일 
//	private String accountBlock; // 지금 가입했는데 block필요없음
	private int accountPoint;
}
