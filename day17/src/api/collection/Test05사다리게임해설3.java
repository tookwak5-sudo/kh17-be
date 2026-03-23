package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test05사다리게임해설3 {
	public static void main(String[] args) {
		// 인원수 예외 처리
		Scanner sc = new Scanner(System.in);
		try {
			List<String> names = new ArrayList<>(); // 이름이 저장될 저장소
			List<String> items = new ArrayList<>(); // 항목이 저장될 저장소
			
			System.out.print("인원수 : " );
			int people = sc.nextInt();
			sc.nextLine(); // 남은 엔터 정리용
			
			//정수를 입력했지만 원치 않는 범위라면 강제 예외 처리
			if(people < 2 || people > 24) {
				throw new Exception("인원수는 2~24명 범위에서만 설정이 가능합니다.");
			}
			
			//이름 입력
			for(int i = 0; i < people; i++) {
				System.out.print("이름 입력 : ");
				String name = sc.nextLine(); 
				//if(name.length() == 0) { // 글자수가 0인가?
				//if(name.isEmpty()) { // 빈문자열인가?
				if(name.isBlank()) {
					i--;
					continue;
				}
				names.add(name); // 이름이나 항목에 띄어쓰기가 있을 수도 있기 때문에 nextLine으로 작성
			}
			
			for(int i = 0; i < people; i++) {
				System.out.print("항목 입력 : ");
				String item = sc.nextLine();
				if(item.isBlank()) {
					items.add(item);
				}
			}
			//섞는다
			Collections.shuffle(items);
			
			//출력
			for(int i = 0; i < people; i++) {
				System.out.println(names.get(i) + "-> " + items.get(i));
			}
		}
		catch(Exception e) {
			//e.printStackTrace();
			if(e.getMessage() == null) {
				System.err.print("알 수 없는 오류 발생");
			}
			else {
				System.err.println("[오류]" + e.getMessage());
			}
		}
		
		finally { // 무조건 실행되는 구문을 만들어서 Scanner를 정리하여 자원 누수 문제를 해결
			sc.close();
		}
	}
}
