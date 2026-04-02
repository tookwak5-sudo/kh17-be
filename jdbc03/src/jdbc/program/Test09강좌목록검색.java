package jdbc.program;

import java.util.List;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test09강좌목록검색 {
	public static void main(String[] args) {
		//입력
		String column = "lecture_title";
		String keyword = "필기";
		//처리
		LectureDao lectureDao = new LectureDao();
		List<LectureDto> list = lectureDao.selectList(column, keyword);
		
		//출력
		System.out.println("조회결과 : " + list.size());
		for(LectureDto lectureDto : list) {
			System.out.println(lectureDto);
		}
	}
}
