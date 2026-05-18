package com.kh.spring09.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//lombok기반의 DTO작성하기 
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ReplyDto {
	private long replyNo;
	private String replyWriter;
	private long replyOrigin;
	private String replyContent;
	private Timestamp replyWtime;
	private Timestamp replyEtime;
}
