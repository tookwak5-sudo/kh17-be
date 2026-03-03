package data;

public class Test09편의점키오스크 {
	public static void main(String[] args) {
		//편의점에서는 삼각김밥을 1개당 1500원에 1+1 행사로 판매하고 있습니다.
		//손님이 삼각김밥을 가져오면 예상 결제금액을 알려주는 무인 키오스크를 구현하려 합니다
		//5개의 삼각김밥을 손님이 가져왔을 때 예상되는 결제 금액을 구하여 출력하세요.
		//키오스크는 사용자가 가져온 상품에 대해서만 결제금액을 계산하며, 1개를 더 가져와야 한다는 등 추가적인 정보는 제공하지 않습니다.
		/*
		// 입력
		int kimbapCount = 1;
		int priceperKimbap = 1500;
		// 처리
		int price = (kimbapCount /2  + kimbapCount %2) * priceperKimbap; 
		
		// 출력
		System.out.println(price); // 결제금액 4500원 
		*/ 
		//n+m 할인행사 진행
		
		int kimbapCount = 5;
		int kimbapPrice  = 1500;
		
		int free = kimbapCount / 2; // 무료 개수
		int fare = (kimbapCount - free);
		
		int price = fare * kimbapPrice;
		
		System.out.println(fare);
		 /*
		// 입력
		int n = 1;  // 요구 김밥 개수 (n>=1)
		int m = 1; // n개 구매 시 추가되는 김밥 개수 (m>=1)
		int kimbapCount = 5; // 키오스크에 가져온 삼각김밥의 개수
		int priceperKimbap = 1500; // 김밥 1개당 가격
		
		// 처리
		int count = kimbapCount / (n+m) + kimbapCount % (n+m);  
		int price = count * 1500; // 결제금액
				
		// 출력
		System.out.println(price);
		
		*/
	}
}
