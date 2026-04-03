package kh.program;

import java.util.Scanner;

import kh.dao.MusicDao2;
import kh.dto.MusicDto;

public class Exam04음원수정2 {
	public static void main(String[] args) {
		//입력
		//번호만 입력받아 존재하지 않는 경우를 제거
		Scanner sc = new Scanner(System.in);
		System.out.print("번호부터 입력: ");
		long musicId = sc.nextLong();
		sc.nextLine();
		MusicDao2 musicDao = new MusicDao2();
		MusicDto originDto = musicDao.selectOne(musicId);
		if(originDto == null) {
			System.out.println("존재하지 않는 곡 정보");
			System.exit(0);
		}
		
		//나머지 정보를 입력받는다 (=미입력시 기존정보로 대체)
				System.out.print("바꿀 제목 : ");		String musicTitle = sc.nextLine();
				System.out.print("바꿀 가수 : ");		String musicArtist = sc.nextLine();
				System.out.print("바꿀 앨범 : ");		String musicAlbum = sc.nextLine();
				System.out.print("바꿀 발매일 : ");		String musicRelease = sc.nextLine();
				System.out.print("바꿀 장르 : ");		String musicGenre = sc.nextLine();
				
				sc.close();
				
				MusicDto musicDto = new MusicDto();
				musicDto.setMusicID(musicId);
				//바꿀 제목을 미입력했으면 기존 제목으로 설정하고 입력했으면 입력한걸로 설정
				musicDto.setMusicTitle(musicTitle.isBlank() ? originDto.getMusicTitle() : musicTitle);
				musicDto.setMusicArtist(musicArtist.isBlank() ? originDto.getMusicArtist() : musicArtist);
				musicDto.setMusicAlbum(musicAlbum.isBlank() ? originDto.getMusicAlbum() : musicAlbum);
				musicDto.setMusicRelease(musicRelease.isBlank() ? originDto.getMusicRelease() : musicRelease);
				musicDto.setMusicGenre(musicGenre.isBlank() ? originDto.getMusicGenre() : musicGenre);
				
				//처리
				musicDao.update(musicDto);
				
				//출력
				System.out.println("음원 정보 수정이 완료되었습니다");
	}
}
