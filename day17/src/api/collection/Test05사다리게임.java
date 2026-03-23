package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test05사다리게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 참여인원 입력
		System.out.print("참여인원 :");
		int party = sc.nextInt();
		
		sc.nextLine();
		// 이름 입력
		List<String> member = new ArrayList<>();
			for(int i = 1; i <= party; i++) {
				System.out.print("이름" +i+" 입력 : ");
				member.add(sc.nextLine());
			}
		// 당첨항목 입력
		List<String> item = new ArrayList<>();
			for(int i = 1; i <= party; i++) {
				System.out.print("당첨 항목" +i+" 입력 : ");
				item.add(sc.nextLine());
			}
		
			Collections.shuffle(item);
			
			System.out.println("사다리 게임 결과");
			System.out.println(member);
			System.out.println(item);
			
			for(int i = 0; i < party; i++) {
				System.out.println("이름 : " + member.get(i) + "\t당첨 항목 :" + item.get(i) );
				System.out.println("-".repeat(10));
			}
			
			sc.close();
	}
}
