package com.kh.spring09.dto;

import lombok.Data;

@Data
public class LectureDto {
	private long lectureNo;
	private String lectureTitle;
	private String lectureCategory;
	private int lectureDuration;
	private long lecturePrice;
	private String lectureType;
	
}
