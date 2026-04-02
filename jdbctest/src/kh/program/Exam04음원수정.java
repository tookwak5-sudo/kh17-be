package kh.program;

import kh.dao.MusicDao;
import kh.dto.MusicDto;

public class Exam04음원수정 {
	public static void main(String[] args) {
		//입력
		
		MusicDto musicDto = new MusicDto();
		musicDto.setMusicID(1);
		musicDto.setMusicTitle("수정 음악345");
		musicDto.setMusicArtist("수정 작가");
		musicDto.setMusicAlbum("수정 엘범");
		musicDto.setMusicRelease("2023-08-08");
		musicDto.setMusicPlay(20000);
		musicDto.setMusicLike(300);
		musicDto.setMusicdislike(400);
		musicDto.setMusicGenre("발라드");
		
		//처리
		MusicDao musicDao = new MusicDao();
		boolean success = musicDao.update(musicDto);
		//출력
		if(success) {
			System.out.println("입력하신 노래가 수정되었습니다.");
		}
		else {
			System.out.println("등록된 아이디가 없습니다.");
		}
	}
}
