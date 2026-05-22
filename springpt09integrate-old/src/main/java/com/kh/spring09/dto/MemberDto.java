package com.kh.spring09.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDto {
	private String memberId;
	private String memberEmail;
	private String memberPassword;
	private String memberNickname;
	private String memberBirth;
	private String memberContact;
	private String memberPost;
	private String memberAddress1;
	private String memberAddress2;
	private String memberLevel;
	private String memberMessage;
	private Timestamp memberJoin; //가입일 
	private Timestamp memberLogin; //최종 로그인시각 //
	private Timestamp memberChange; // 최종 비밀번호 변경일 
	private String memberBlock; //차단여부
	private int memberPoint;

}