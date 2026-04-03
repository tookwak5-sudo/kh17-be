package kh.program;

import java.util.Scanner;

import kh.dao.MusicDao2;
import kh.dto.MusicDto;

public class Exam01음원등록 {
	public static void main(String[] args) {
		//입력
		MusicDto musicDto = new MusicDto();
		musicDto.setMusicTitle("테스트 노래");
		musicDto.setMusicArtist("테스트 작가");
		musicDto.setMusicAlbum("테스트 엘범");
		musicDto.setMusicRelease("2022-08-08");
		musicDto.setMusicGenre("재즈");
		
		//처리
		MusicDao2 musicDao = new MusicDao2();
		musicDao.insert(musicDto);
		
		//출력
		System.out.println("등록완료!");
	}
}
