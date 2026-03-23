package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임 {
	public static void main(String[] args) {
		List<String> word = new ArrayList<>(); // 단어 저장소
		
		word.add("거북이");word.add("이불");word.add("불가사리");
		word.add("리어카");word.add("카센타");word.add("타이어");
		word.add("어린이");word.add("이구아나");word.add("나비");
		word.add("비밀");
		
		String input = "거북이"; // 랜덤으로 나올것
		
		List<String> already = new ArrayList<>();
		already.add(input);
		while(word.size() > 0) {
			Scanner sc = new Scanner(System.in);
			input = sc.nextLine();
			
			if(word.contains(input) == false) {
				System.out.println("다시 입력");
				continue;
			}
			if(already.contains(input) == false) {
				System.out.println("입력 : " + input);
				already.add(input);
				word.remove(input);
			}
			else if(already.contains(input)) {
				break;
			}
		}
		
		System.out.println("게임오버");
		for(int i =0; i < already.size(); i++) {
			System.out.println("->" + already.get(i));
		}
		
		
	}
}
