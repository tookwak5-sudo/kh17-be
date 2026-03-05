package conditon2;
import java.util.Scanner;

public class Test04여행사프로모션 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);		
		System.out.print("인원 수 : ");
		int people = sc.nextInt(); // 인원수
		System.out.print("월 : ");
		int month = sc.nextInt();// 여행갈 달
		System.out.print("여행 기간 : ");
		int period = sc.nextInt(); // 여행 기간
		
		int dayPerPrice = 100000; //1인당 하루 가격				
		// 할인율
		int sale;
		int springDiscount = 10; // 봄 할인율
		int summerDiscount = 5; // 여름 할인율
		int autumnDiscount = 30; // 가을 할인율
		int winterDiscount = 25; // 겨울 할인율
		String season;
		//처리
		int price = people * dayPerPrice * period; // 총 비용			
		if(month >= 12 && month <= 2) { //겨울			
			sale = winterDiscount;
			season = "겨울";			
		}
		else if(month >=9) { //가을			
			sale = autumnDiscount;
			season = "가을";
		}
		else if(month >= 6) { //여름			 
			sale = summerDiscount;
			season = "여름";
		}
		else { // 봄			
			sale = springDiscount;
			season = "봄";
		}		
		int discountPrice = price * sale / 100; //할인율
		int total = price - discountPrice;
		//출력
		System.out.println("인원 수 : " + people + "명"); // 인원 수
		System.out.println("여행갈 달 :" + month +"월"); // 출발 월
		System.out.println("여행기간 : " + period + "일"); //여행기간
		System.out.println("계절 : " + season);// 계절
		System.out.println("할인 전 가격: " + price + "원");
		System.out.println("할인 비율: " + sale + "%"); // 할인율
		System.out.println("할인 가격: " + total + "원");// 예상 비용		
	}
}
