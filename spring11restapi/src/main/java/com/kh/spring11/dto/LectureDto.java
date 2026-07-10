package com.kh.spring11.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class LectureDto {
	private int lectureNo;
	private String lectureTitle;
	private String lectureCategory;
	private Integer lectureDuration;
	private Integer lecturePrice;
	private String lectureType;
}
