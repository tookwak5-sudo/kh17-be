package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임해설 {
	public static void main(String[] args) {
		//제시어 = 가장 마지막 입력한 단어
		
		//사용자의 입력이 계속해서 리스트에 저장이 되고 가장 마지막 단어가 화면에 출력되도록 처리
		
		List<String> history = new ArrayList<>();
		history.add("바나나");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String last = history.get(history.size() -1);
			System.out.println("제시어 :" + last);
			System.out.print("입력 :");
			String input = sc.nextLine();
			
			//검사를 통해 게임오버 상황을 체크
			// - 한글 2글자 이상 [정규표현식]
			if(!input.matches("^[가-힣]{2,}$")) break;
				//-제시어의 연결
//			if(last.charAt(last.length()-1) != input.charAt(0)) break;
			//	if(!input.startsWith(last.substring(last.length()-1))) break;
			//if(!last.endsWith(input.substring(0, 1))) break;
				//- 기록에 존재하는 지 확인
			if(history.contains(input)) break;
				//기록 추가
				history.add(input);
			
			}
				System.out.println("게임오버");
				
				for(int i = 0; i < history.size(); i++) {
					System.out.println("->" + history.get(i));
				}
	}
}
