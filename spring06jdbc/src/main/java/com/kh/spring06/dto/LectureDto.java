package com.kh.spring06.dto;

//등록없이 필요할때마다 만들어서 사용
public class LectureDto {
	private long lectureNo;
	private String lectureTitle;
	private String lectureCategory;
	private int lectureDuration;
	private long lecturePrice;
	private String lectureType;
	
	@Override
	public String toString() {
		return "LectureDto [lectureNo=" + lectureNo + ", lectureTitle=" + lectureTitle + ", lectureCategory="
				+ lectureCategory + ", lectureDuration=" + lectureDuration + ", lecturePrice=" + lecturePrice
				+ ", lectureType=" + lectureType + "]";
	}
	public LectureDto() {
		super();
	}
	public long getLectureNo() {
		return lectureNo;
	}
	public void setLectureNo(long lectureNo) {
		this.lectureNo = lectureNo;
	}
	public String getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public String getLectureCategory() {
		return lectureCategory;
	}
	public void setLectureCategory(String lectureCategory) {
		this.lectureCategory = lectureCategory;
	}
	public int getLectureDuration() {
		return lectureDuration;
	}
	public void setLectureDuration(int lectureDuration) {
		this.lectureDuration = lectureDuration;
	}
	public long getLecturePrice() {
		return lecturePrice;
	}
	public void setLecturePrice(long lecturePrice) {
		this.lecturePrice = lecturePrice;
	}
	public String getLectureType() {
		return lectureType;
	}
	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}
	
	
}
