package api.string;

import java.util.Scanner;

public class Test08욕설필터링 {
	public static void main(String[] args) {
		String[] filter = new String[] {"신발끈", "십자수", "개나리"};
		//입력을 정해두고 단어 한 개만 필터링 처리
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine(); // 한 줄(엔터 전까지)을 입력받는 명령`
		
		// 필터링 처리
		String star = "*";
		for(int i = 0; i < filter.length; i++) {
			String mask = star.repeat(filter[i].length());
			line = line.replace(filter[i], mask);
			// 또는
//			String star = "*".repeat(filter[i].length());
//			line = line.replace(filter[i], "*");
		}
		
		// 출력
		System.out.println("출력 : " + line);
	}
}
