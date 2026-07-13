package com.kh.spring11.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class LectureComplexRequestVO {
	private String lectureTitle;
	private List<String> lectureCategories;
	private List<String> lectureTypes;
	private Integer minLectureDuration;
	private Integer maxLectureDuration;
	private Integer minLecturePrice;
	private Integer maxLecturePrice;
	private List<String> orders;
	private Integer lastLectureNo;
	private Integer size;
}
