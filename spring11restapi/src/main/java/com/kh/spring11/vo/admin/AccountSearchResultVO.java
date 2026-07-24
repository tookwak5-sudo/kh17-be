package com.kh.spring11.vo.admin;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AccountSearchResultVO {
	private String accountId;
	private String accountEmail;
	private String accountNickname;
	private String accountBirth;
	private String accountContact;
	private String accountPost, accountAddress1, accountAddress2;
	private String accountLevel;
	private Timestamp accountJoin;
	private Timestamp accountLogin;
	private Timestamp accountChange;
	private String accountBlock;
	private String accountPoint;
	private String accountMessage;
}
