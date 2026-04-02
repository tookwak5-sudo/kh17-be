package jdbc.program;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test12강좌상세정보 {
	public static void main(String[] args) {
		//입력
		int lectureNo = 1;
		
		//처리
		LectureDao lectureDao = new LectureDao();
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		
		//출력
		if(lectureDto == null) {
			System.out.println("존재하지 않는 대상입니다.");
		}
		else{
			System.out.println("강좌상세정보");
			System.out.println(lectureDto.getLectureNo());
			System.out.println(lectureDto.getLectureTitle());
		}
	}
}
