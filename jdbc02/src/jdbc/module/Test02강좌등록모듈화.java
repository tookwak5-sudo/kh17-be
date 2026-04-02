package jdbc.module;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;


public class Test02강좌등록모듈화 {
	public static void main(String[] args) {
		
		// 데이터 준비
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureTitle("파이썬");
		lectureDto.setLectureCategory("이론");
		lectureDto.setLectureDuration("90");
		lectureDto.setLecturePrice(50000);
		lectureDto.setLectureType("혼합");
		
//		String lectureTitle = "파이썬";
//		String lectureCategory = "이론";
//		int lectureDuration = 90;
//		int lecturePrice = 500000;
//		String lectureType = "혼합";
		
		//DB 등록 (처리)
		LectureDao lectureDao = new LectureDao();
		lectureDao.insert(lectureDto);
		
		// 결과 알림 (출력)
		System.out.println("등록완료");
	}
}
