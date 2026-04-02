package kh.program;

import kh.dao.MusicDao;
import kh.dto.MusicDto;

public class Exam03음원상세 {
	public static void main(String[] args) {
		//입력
		int musicId = 1;
		//처리
		MusicDao musicDao = new MusicDao();
		MusicDto musicDto = musicDao.selectOne(musicId);
		//출력
		System.out.println(musicDto);
	}
}
