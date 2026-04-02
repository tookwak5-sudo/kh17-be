package kh.program;

import kh.dao.MusicDao;
import kh.dto.MusicDto;

public class Exam01음원등록 {
	public static void main(String[] args) {
		//입력
		MusicDto musicDto = new MusicDto();
		musicDto.setMusicTitle("테스트 음악123");
		musicDto.setMusicArtist("테스트 작가");
		musicDto.setMusicAlbum("테스트 엘범");
		musicDto.setMusicRelease("2022-08-08");
		musicDto.setMusicPlay(5000);
		musicDto.setMusicLike(500);
		musicDto.setMusicdislike(500);
		musicDto.setMusicGenre("재즈");
		
		//처리
		MusicDao musicDao = new MusicDao();
		musicDao.insert(musicDto);
		//출력
		System.out.println("등록완료!");
	}
}
