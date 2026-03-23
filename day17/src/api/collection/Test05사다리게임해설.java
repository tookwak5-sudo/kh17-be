package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test05사다리게임해설 {
	public static void main(String[] args) {
		//네이버 사다리게임의 최종결과만 출력
		// 입력을 추가
		
		Scanner sc = new Scanner(System.in);
		
		List<String> names = new ArrayList<>(); // 이름이 저장될 저장소
		List<String> items = new ArrayList<>(); // 항목이 저장될 저장소
		
		System.out.print("이름 입력 : ");
		names.add(sc.nextLine()); // 이름이나 항목에 띄어쓰기가 있을 수도 있기 때문에 nextLine으로 작성
		System.out.print("이름 입력 : ");
		names.add(sc.nextLine());
		System.out.print("이름 입력 : ");
		names.add(sc.nextLine());
		
		System.out.print("항목 입력 : ");
		items.add(sc.nextLine());
		System.out.print("항목 입력 : ");
		items.add(sc.nextLine());
		System.out.print("항목 입력 : ");
		items.add(sc.nextLine());
		
		
		Collections.shuffle(items);
		
		System.out.println(names.get(0) + "-> " + items.get(0));
		System.out.println(names.get(1) + "-> " + items.get(1));
		System.out.println(names.get(2) + "-> " + items.get(2));
		
		
	}
}
