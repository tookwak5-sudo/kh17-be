package loop3;

import java.util.Random;
import java.util.Scanner;

public class Test06아이템강화2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int item = 0; // 강화 단계 1~10까지
		int success = 0; // 강화 성공 횟수
		int fail = 0; // 강화 실패 횟수
		int stay = 0; // 강화 유지 횟수
		int count =1; // 회차	
		
		System.out.println("1레벨 아이템을 10레벨까지 강화합니다");
		while(true) {
		//	int start = sc.nextInt(); // 유저가 키보드 숫자 1 누르면 강화 도전;
			int chance = r.nextInt(10) + 1;   // 1~10까지
		//	System.out.println(chance);
		//	if(start == 1) {//강화도전	
				switch(chance) {
					case 9,10:
						item++;
						success++;
						System.out.println(count + "회차 : " + "성공 (+1), 현재 레벨 " + item );	
						break;
					case 1, 2:
						item--;
						fail++;
						if(item <0) item = 0;				
						System.out.println(count + "회차 : " + "실패 (-1), 현재 레벨 " + item );	
						break;
					default:
						stay++;
						System.out.println(count + "회차 : " + "유지, 현재 레벨 " + item );						
				}					
		//	}
			count++;
			
			if(item  >= 10) break;
			
		}		
		
		int total = success + fail + stay;
		int suc =(int) ((double) success / total * 100); 
		int fal = (int) ((double) fail / total * 100);
		int st =(int) ((double) stay / total * 100);
		
		System.out.println("★★★강화가 완료되었습니다★★★");
		System.out.println("성공횟수 : " + success + "("+suc + "%)");
		System.out.println("실패횟수 : " + fail +"("+ fail + "%)" );
		System.out.println("유지횟수 : " + stay + "("+ stay + "%)");
	}
}
