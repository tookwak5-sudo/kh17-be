package kh.program;

import java.util.Scanner;

import kh.dao.MusicDao2;
import kh.dto.MusicDto;

public class Exam04음원수정 {
	public static void main(String[] args) {
		//입력
		
		Scanner sc = new Scanner(System.in);
		MusicDto musicDto = new MusicDto();
		System.out.print("번호 : "); 				musicDto.setMusicID(sc.nextLong());
		sc.nextLine();
		System.out.print("제목 : "); 				musicDto.setMusicTitle(sc.nextLine());
		System.out.print("가수 : "); 				musicDto.setMusicArtist("수정 작가");
		System.out.print("앨범 : "); 				musicDto.setMusicAlbum("수정 엘범");
		System.out.print("발매일 : "); 				musicDto.setMusicRelease("2023-08-08");
		System.out.print("재생수 : "); 				musicDto.setMusicPlay(20000L);
		System.out.print("좋아요 : "); 				musicDto.setMusicLike(300);
		System.out.print("싫어요 : "); 				musicDto.setMusicdislike(400);
		System.out.print("장르 : "); 				musicDto.setMusicGenre("발라드");
		
		//처리
		MusicDao2 musicDao = new MusicDao2();
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
