package kh.program;

import kh.dao.MusicDao;

public class Exam05음원삭제 {
	public static void main(String[] args) {
		//입력
		int musicId = 22;
		//처리
		MusicDao musicDao = new MusicDao();
		musicDao.delete(musicId);
		//출력
		System.out.println("입력하신 번호의 노래가 삭제되었습니다.");
	}
}
