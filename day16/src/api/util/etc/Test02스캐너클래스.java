package api.util.etc;

import java.util.Scanner;

public class Test02스캐너클래스 {
	public static void main(String[] args) {
		//Scanner 클래스
		// - 문자열, 입력통로, 파일 등 글자가 존재하는 대상을 읽어서 분석할 수 있는 도구
		
		String sample = "동해물과 백두산이 마르고 닳도록\n 하느님이 보우하사 우리나라만세";
		
		Scanner sc = new Scanner(sample); // sample문자열을 분석하는 Scanner을 만들어라!
		
		// 읽을 단어가 있으면 반복하세요
		while(true){
			//System.out.println(sc.hasNext());//next()로 읽을 데이터가 존재하는가?
			if(sc.hasNext() == false) break; // 더이상 읽을게 없으면 나가라!
			String word = sc.next(); //단어를 읽는 명령 -> 단어의 기준 띄어쓰기류 space, \t, \n등
			System.out.println(word);
		}
		
		
	}
}
