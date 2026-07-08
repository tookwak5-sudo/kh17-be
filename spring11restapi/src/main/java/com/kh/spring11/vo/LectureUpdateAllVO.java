package com.kh.spring11.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "강좌 전체 수정 정보")
@Data
public class LectureUpdateAllVO {
	@Schema(description = "강좌 제목", example = "정보처리기사 필기")
	private String lectureTitle;
	@Schema(description = "강좌 분류", examples = {"이론", "실습", "시험"})
	private String lectureCategory;
	@Schema(description = "강좌 시간", examples = {"30", "60", "90"})
	private int lectureDuration;
	@Schema(description = "수강료", examples = {"100000", "200000", "300000"})
	private int lecturePrice;
	@Schema(description = "강좌 방법", examples = { "온라인", "오프라인", "혼합"})
	private String lectureType;
}
