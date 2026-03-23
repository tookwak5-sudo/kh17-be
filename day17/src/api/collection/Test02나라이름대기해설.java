package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test02나라이름대기해설 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<String> history = new ArrayList<>(); 
		
		while(true) {
			//입력
			System.out.println("입력 : ");
			String name = sc.nextLine();
			
			if(history.contains(name)) {
				break;
			}
			System.out.println("history = " + history);
		}
		
		sc.close();
		System.out.println("게임 오버");
		
		
		//여태까지 입력한 모든 데이터(history)를 순서대로 출력
		//-데이터의 개수를 모르기 때문에 size()를 사용하여 반복 수행
		for(int i = 0; i < history.size(); i++) {
			System.out.println("->" + history.get(i));
		}
	}
}
