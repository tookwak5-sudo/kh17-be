package conditon2;

import java.util.Scanner;

public class Test04여행사프로모션2 {
	public static void main(String[] args) {
		//입력값
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수 : ");
		int people = sc.nextInt();
		System.out.print("달 : ");
		int month = sc.nextInt();
		System.out.print("기간(일) : ");
		int days = sc.nextInt();
		
		//설정값
		int periodPrice = 10000;
		int springRate = 10;
		int summerRate = 5;
		int autumnRate = 30;
		int winterRate = 25;
		
		//처리
		//-할인 전 요금 : 1인당 1일 10만원
		int base = people * days * periodPrice;
		//double rate = 0.1 or 0.05 or 0.3 or 0.25
		//int discount = (int) (base* rate); // cast 연산자는 보통 가장 먼저 연산이 되기때문에
		int rate;
		String season;
		if(month / 3 == 1) { // 3,4,5월이라면  = 3월부터 5월 사이이라면 = **3으로 나눴을 때 몫이 1이라면**
			rate = springRate;
			season = "봄";
		}
		else if (month / 3 == 2) {//678
			rate = summerRate;
			season = "여름";
		}
		else if(month / 3 == 3) { //91011
			rate = autumnRate;
			season = "가을";
		}
		else {//겨울
			rate = winterRate;
			season = "겨울";
		}
		int discount = base * rate / 100;
		int price = base - discount;
		//출력
		System.out.println("<예상 금액>");
		System.out.println("인원수 : " + people + "명");
		System.out.println("여행가는 달 : " + month + "월");
		System.out.println("여행기간 : " + days +"일");
		System.out.println("-------------------");
		System.out.println("예상경비 : " + base +" 원");
		System.out.println("계절(" + season +")에 따른 할인 : " + rate + "%"); // 금액을 구해버리면 할인 비율, 할인 금액을 보여줄 수 없음.
		System.out.println("할인 금액 : " + discount + " 원"); // **
		System.out.println("-------------------");
		System.out.println("최종 결제 예상 금액 : " + price + "원");
	}
}
