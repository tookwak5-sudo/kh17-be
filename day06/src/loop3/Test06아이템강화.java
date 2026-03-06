package loop3;

import java.util.Random;
import java.util.Scanner;

public class Test06아이템강화 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int item = 0; // 강화 단계 1~10까지
		int success = 0; // 강화 성공 횟수
		int fail = 0; // 강화 실패 횟수
		int stay = 0; // 강화 유지 횟수
		
		while(true) {
			int start = sc.nextInt(); // 유저가 키보드 숫자 1 누르면 강화 도전;
			int chance = r.nextInt(100) + 1;   // 1~100까지
			System.out.println(chance);
			if(start == 1) {//강화시작
				if(chance > 80) {
					System.out.println("강화 성공!!");	
					item++;
					success++;
				}
				else if(chance <=20){
					System.out.println("강화 실패");	
					item -=1;
					if(item < 0) {
						item =0;
					}
					fail++;
				}
				else {
					System.out.println("강화 유지!");	
					stay++;
				}
				
				if(item == 10) break;
			}
			
			System.out.println("현재 강화 상태 : " + item);
		}
		
				
	}
}
