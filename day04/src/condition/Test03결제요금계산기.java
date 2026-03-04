package condition;
//저희 레스토랑에서는 행사로 다음과 같이 인원수에 따라 결제 할인을 진행하고 있습니다.

import java.util.Scanner;

//1인당 48000원
//4인 이상 방문 시 15% 할인
//인원수를 입력받아 예상 결제 금액을 구하여 출력하세요!
public class Test03결제요금계산기 {
	public static void main(String[] args) {
		/*	
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("방문 인원 수: ");
		int people = sc.nextInt();
		System.out.println(people + "명");
		int perPrice = 48000;
		int discount = 15;
		
		//처리
		int price = perPrice * people;
		int discountPrice = price - (price * discount / 100);
		if(people >= 4) {		
			System.out.println(discountPrice + "원 입니다."); //결제금액 = 인원수 * 인당 가격 * (1 - 0.15) '4'인 이상인 경우';
		}
		else {
			System.out.println(price + "원 입니다."); // 결제금액 = 인원수 * 인당 가격 '4인 미만인 경우'
		}
		
		*/
		
		//입력
		int price = 48000;
		int people = 4;
		int discount = 15;//할인율
		
		//처리
		boolean event = people >= 4;
			
		//출력  // 변수는 블록 스코프(block scope)를 가짐 따라서 각 중괄호 안에 같은 이름을 가진 변수를 넣을 수 있다. 
		if(event) {
			int cash = price * people * (100-discount) / 100;
			System.out.println("할인된 가격" + cash + "원");			
		}
		else {
			int cash = price * people;
			System.out.println("할인 안된 가격" + cash + "원");			
		}
	}
}
