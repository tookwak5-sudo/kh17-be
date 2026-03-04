package conditon2;

import java.time.LocalDate;
import java.util.Scanner;

//사용자의 출생년도 4자리를 입력받아 지하철 요금을 계산하는 프로그램을 만드세요
//어르신 : 65세 이상 , 무료
//성인 : 20세 ~ 64세 , 1550원
//청소년 : 14세 ~ 19세 , 900원
//어린이 : 8세 ~ 13세 , 550원
//영유아 , 7세 이하 , 무료
//일회용 카드는 500원의 보증금이 있습니다.
//보증금을 합쳐서 출력해주세요
public class Test03지하철요금계산기2 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 4자리");
		int birthYear 	= sc.nextInt();
		
		int card = 500;
		//처리
		// 나이
		int age = LocalDate.now().getYear() - birthYear + 1;
		int base;
		
		if(age >= 65 && age <=7) {
			base = 0;
		}
		else if(age <= 13) {
			base = 550;
		}
		else if(age <= 19) {
			base = 900;
		}
		else {
			base = 1550;
		}
		
		int price = base + card; // 최종요금
		
		//출력
		System.out.println("나이 : " + age + "세");
		System.out.println("기본요금 : "+ base +"원");
		System.out.println("카드보증금 : "+ card +" 원");
		System.out.println("결제요금 : "+ price +"원");
	}
}
