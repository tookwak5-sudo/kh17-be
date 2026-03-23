package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test05사다리게임해설2 {
	public static void main(String[] args) {
		// 반복 처리 추가
		Scanner sc = new Scanner(System.in);
		
		List<String> names = new ArrayList<>(); // 이름이 저장될 저장소
		List<String> items = new ArrayList<>(); // 항목이 저장될 저장소
		
		System.out.print("인원수 : " );
		int people = sc.nextInt();
		sc.nextLine(); // 남은 엔터 정리용
		
		//이름 입력
		for(int i = 0; i < people; i++) {
			System.out.print("이름 입력 : ");
			names.add(sc.nextLine()); // 이름이나 항목에 띄어쓰기가 있을 수도 있기 때문에 nextLine으로 작성
		}
		
		for(int i = 0; i < people; i++) {
			System.out.print("항목 입력 : ");
			items.add(sc.nextLine());
		}
		sc.close();
		
		//섞는다
		Collections.shuffle(items);
		
		//출력
		for(int i = 0; i < people; i++) {
			System.out.println(names.get(i) + "-> " + items.get(i));
		}
	}
}
