package com.kh.spring11.dto;

import lombok.Data;

@Data
public class LectureDto {
	private int lectureNo;
	private String lectureTitle;
	private String lectureCategory;
	private int lectureDuration;
	private long lecturePrice;
	private String lectureType;
}
