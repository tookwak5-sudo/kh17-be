package kh.program;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import kh.dao.MusicDao2;
import kh.dto.MusicChartDto;
import kh.dto.MusicDto;

public class Exam02음원목록2 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("검색 항목: ");
		String column = sc.nextLine();
		System.out.println("검색어: ");
		String keyword = sc.nextLine();
		sc.close();
		//처리: 전체 곡 목록 조회
		MusicDao2 musicDao = new MusicDao2();
		List<MusicChartDto> list = musicDao.selectListRank(column, keyword);
		
		
		//출력
		if(list.isEmpty()) { // 없는 건 따로 빼는게 좋음
			System.out.println("결과가 존재하지 않습니다.");
		}
		else {
			System.out.println("음원 수 : " + list.size());
			for(MusicChartDto musicChartDto : list) {
				System.out.print(musicChartDto.getMusicTitle());
				System.out.print(" / ");
				System.out.print(musicChartDto.getMusicArtist());
				System.out.print(" / ");
				System.out.print(musicChartDto.getMusicAlbum());
				System.out.print(" / ");
				System.out.print(musicChartDto.getMusicPoint());
				System.out.print(" / ");
			}
		}
	}
}

