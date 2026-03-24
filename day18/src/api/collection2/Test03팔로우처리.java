package api.collection2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03팔로우처리 {
	public static void main(String[] args) {
		// 내 팔로우 내역
		Set<String> myFollow = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// 아이디 입력
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			
			//입력받은 아이디를 내 팔로우 내역과 비교
			if(myFollow.contains(id)) { // 팔로우 내역에 존재하면 제거
				myFollow.remove(id);
				System.out.println( "[" + id +"] 님을 언팔로우하였습니다.");
			}
			else { // 팔로우 내역에 존재하지 않으면 추가
				myFollow.add(id);
				System.out.println( "[" + id +"] 님을 팔로우하였습니다.");
			}
			if(id.equals("종료")) { //'종료'를 입력하면 프로그램 종료 후 
				break;
			}
		}
		//팔로우한 인원수와 명단 출력
		System.out.println("총 팔로우한 인원 수는 [" + myFollow.size() + "] 명 입니다.");
		for(String member : myFollow) {
			System.out.println("-> " + member);
		}
	}
}
