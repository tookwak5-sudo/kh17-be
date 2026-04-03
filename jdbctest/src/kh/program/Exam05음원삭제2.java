package kh.program;

import java.util.Scanner;

import kh.dao.MusicDao;
import kh.dao.MusicDao2;
import kh.dto.MusicDto;

public class Exam05음원삭제2 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 번호: ");
		long musicId = sc.nextLong();
		
		MusicDao2 musicDao = new MusicDao2();
		MusicDto musicDto = musicDao.selectOne(musicId);
		if(musicDto == null) {
			System.out.println("존재하지 않는 음원입니다");
			System.exit(0);
		}
		
		System.out.print("정말 삭제하시겠어요(Y/N)");
		String choice = sc.next();
		sc.close();
		
		if(!choice.equals("Y")) {
			System.out.println("삭제를 취소합니다");
			System.exit(0);
		}
		//처리
		musicDao.delete(musicId);
		
		//출력
		System.out.println("입력하신 번호의 노래가 삭제되었습니다.");
 	}
}
