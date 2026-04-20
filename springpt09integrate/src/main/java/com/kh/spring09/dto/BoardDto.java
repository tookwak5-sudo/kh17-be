package com.kh.spring09.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.Data;

@Data
public class BoardDto {
	private long boardNo;
	private String boardHead;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Timestamp boardWtime;
	private Timestamp boardEtime;
	private long boardReadcount, boardLikecount, boardReplycount;
	
	
	public String getBoardWtimeNow() {
		LocalDateTime writeTime = boardWtime.toLocalDateTime();
		LocalDateTime current = LocalDateTime.now();
		Duration duration = Duration.between(writeTime, current);
//		if(duration.toDays() > 24) {
		if(duration.toHours() > 4) { // 현시간 - 작성시간이 한시간 보다 크다면
			return "last";
		}
		else {
			return "today";
		}
	}
	
	
}
