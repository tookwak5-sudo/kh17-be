package com.kh.spring09.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ReplyVO {
	//ReplyDto의 동일한 필드
	private long replyNo;
	private String replyWriter;
	private long replyOrigin;
	private String replyContent;
	private Timestamp replyWtime;
	private Timestamp replyEtime;
	
	//+작성자여부
	private boolean writer; //이 값이 true면 작성자가 쓴 댓글(작성자 표시 추가)
	
	//+소유자여부
	private boolean owner; // 이 값이 true면 본인이 작성한 댓글(수정, 삭제가 가능)
}
