package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임해설3 {
	public static void main(String[] args) {
		//제시어 = 가장 마지막 입력한 단어
		
		//사용자의 입력이 계속해서 리스트에 저장이 되고 가장 마지막 단어가 화면에 출력되도록 처리
		
		List<String> history = new ArrayList<>();
		history.add("바나나");
		history.add("사과");
		history.add("자동차");
		history.add("학교");
		history.add("컴퓨터");
		history.add("도서관");
		history.add("음악");
		history.add("의자");
		
		Collections.shuffle(history);
		for(int i = 0; i < history.size()-1; i++) { //마지막 1개 빼고 다 지움
			history.remove(i);
		}
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String last = history.get(history.size() -1);
			System.out.println("제시어 :" + last);
			System.out.println("입력 :");
			
			String input = sc.nextLine();
			
			//검사를 통해 게임오버 상황을 체크
			// - 한글 2글자 이상 [정규표현식]
			if(!input.matches("^(가-힣){2,}$")) break;
				//-제시어의 연결
			if(last.charAt(last.length()-1) != input.charAt(0)) break;
//				if(!last.substring(last.length()-1).startsWith(input)) break;
//				if(!last.substring(0,1).endsWith(last)) break;
				
				//기록 추가
				history.add(input);
			
			}
				System.out.println("게임오버");
				for(int i = 0; i < history.size(); i++) {
					System.out.println("-> " + history.get(i));
				}
	}
}
