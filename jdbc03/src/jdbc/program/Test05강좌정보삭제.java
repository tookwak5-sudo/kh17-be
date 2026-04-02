package jdbc.program;

import jdbc.dao.LectureDao;

public class Test05강좌정보삭제 {
	public static void main(String[] args) {
		//입력
		int lectureNo = 28;
		
		// 처리
		LectureDao lectureDao = new LectureDao();
		boolean success = lectureDao.delete(lectureNo);
		
		if(success) {
			System.out.println("강좌가 삭제되었습니다.");
		}
		else {
			System.out.println("해당 번호의 강좌가 존재하지 않습니다.");
		}
	}
}