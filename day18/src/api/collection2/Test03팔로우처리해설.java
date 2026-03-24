package api.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03팔로우처리해설 {
	public static void main(String[] args) {
		// 내 팔로우 내역
		Set<String> followList = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// 아이디 입력
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			if(id.equals("종료")) { //'종료'를 입력하면 프로그램 종료 후 
				break;
			}
			
			//입력받은 아이디를 내 팔로우 내역과 비교
			if(followList.contains(id)) { // 팔로우 내역에 존재하면 제거
				followList.remove(id);
				System.out.println( "[" + id +"] 님을 언팔로우하였습니다.");
			}
			else { // 팔로우 내역에 존재하지 않으면 추가
				followList.add(id);
				System.out.println( "[" + id +"] 님을 팔로우하였습니다.");
			}
			
		}
		sc.close();
		
		// 출력 전에 Treeset에 옮겨 담음
		Set<String> sortFollowList = new TreeSet<>(followList);  //TreeSet(Collection<? extends E> c) // Collection이 상위목록이므로 HashSet도 입력이 가능
		//팔로우한 인원수와 명단 출력
		System.out.println("총 팔로우한 인원 수는 [" + sortFollowList.size() + "] 명 입니다.");
		for(String member : sortFollowList) {
			System.out.println("-> " + member);
		}
	}
}
