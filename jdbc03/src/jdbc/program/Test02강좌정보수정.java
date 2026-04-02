package jdbc.program;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test02강좌정보수정 {
	public static void main(String[] args) {
		//입력
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(1);
		lectureDto.setLectureTitle("테스트강좌101");
		lectureDto.setLectureCategory("이론");
		lectureDto.setLectureDuration("90");
		lectureDto.setLecturePrice(520000);
		lectureDto.setLectureType("혼합");
		//처리
		LectureDao lectureDao = new LectureDao();
		boolean success = lectureDao.update(lectureDto);
					
		//출력
		if(success) { // 한 개 이상의 정보가 고쳐졌다는 뜻이기 때문에
			System.out.println("강좌 정보가 변경되었습니다.");
		}
		else {
			System.out.println("해당 번호의 강의는 없습니다.");
		}
	}
}
