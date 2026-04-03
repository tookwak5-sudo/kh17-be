package kh.program;

import java.text.DecimalFormat;
import java.text.Format;

import kh.dao.MusicDao;
import kh.dao.MusicDao2;
import kh.dto.MusicDto;

public class Exam03음원상세2 {
	public static void main(String[] args) {
		//입력
		long musicId = 2;
		//처리
		MusicDao2 musicDao = new MusicDao2();
		musicDao.updateMusicPlay(musicId); // 재생수 증가
		MusicDto musicDto = musicDao.selectOne(musicId); // 조회
		
		//출력
		if(musicDto == null) {
			System.out.println("존재하지 않는 곡 정보");
		}
		else {
			//System.out.println(musicDto);
			Format f = new DecimalFormat("#,##0");
			System.out.println("<곡 상세 정보>");
			System.out.println("곡명 : " + musicDto.getMusicTitle());
			System.out.println("가수 : " + musicDto.getMusicArtist());
			System.out.println("앨범 : " + musicDto.getMusicAlbum());
			System.out.println("발매 : " + musicDto.getMusicRelease());
			System.out.println("장르 : " + musicDto.getMusicGenre());
			System.out.println("재생 : " + f.format(musicDto.getMusicPlay())+"회");
			System.out.println("좋아요 : " + f.format(musicDto.getMusicLike()));
			System.out.println("싫어요 : " + f.format(musicDto.getMusicdislike()));
		}
	}
}
