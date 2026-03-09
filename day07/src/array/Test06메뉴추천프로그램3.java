package array;

import java.util.Random;
import java.util.Scanner;

//사용자에게 개수를 입력받아 해당하는 개수만큼의 메뉴를 입력받고 
//그 중 하나를 랜덤으로 출력하는 프로그램을 구현하세요.
//참고로 문자열은 sc.next()라는 명령으로 입력받을 수 있습니다.
//메뉴 개수 : 3
//입력 : (치킨)
//입력 : (떡볶이)
//입력 : (파스타)
//추천하는 메뉴는 [파스타] 입니다!
public class Test06메뉴추천프로그램3 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		//메뉴 개수 입력
		System.out.println("메뉴 개수 : ");
		int count = sc.nextInt();
		
		
		//String[] menuList = new String[] {"떡볶이", "치킨", "파스타"};
		String[] menuList = new String[count];
		for(int i = 0; i < count; i++) {
			System.out.print("메뉴 입력 : ");
			
			menuList[i] = sc.next();
		}
		
		Random r = new Random();
		int p = r.nextInt(count);  // 0~3개
		System.out.println("추천 메뉴 [" + menuList[p] + "]"); // 0,1, 2 중 하나
		
		
	}
}
