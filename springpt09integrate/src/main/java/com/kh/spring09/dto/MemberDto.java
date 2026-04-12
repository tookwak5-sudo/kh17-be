package com.kh.spring09.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberDto {
	private long memberNo;// 안 넣어도 됨 //
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
	private LocalDateTime memberJoin; //가입일 
	private LocalDateTime memberLogin; //최종 로그인시각 //
	private LocalDateTime memberChange; // 최종 비밀번호 변경일 
	private String memberBlock; //차단여부
	private long memberPoint;

	
}