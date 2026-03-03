package day3;

//편의점에서는 삼각김밥을 1개당 1500원에 1+1 행사로 판매하고 있습니다.
		//손님이 삼각김밥을 가져오면 예상 결제금액을 알려주는 무인 키오스크를 구현하려 합니다.
		//5개의 삼각김밥을 손님이 가져왔을 때 예상되는 결제 금액을 구하여 출력하세요.
		//키오스크는 사용자가 가져온 상품에 대해서만 결제금액을 계산하며, 1개를 더 가져와야 한다는 등 추가적인 정보는 제공하지 않습니다.
public class Test09편의점키오스크 {
	public static void main(String[] args) {
		//입력
		int gimbap = 1500;
		int count = 5;
		
		//처리
		
		// 무료증정개수  = 구매개수 /2
		int free = count /2;
		//int fare = count / 2 + count% 2;
		int fare =count - free;
		
		int price = gimbap * fare;
		
		//출력
		System.out.println(price);
		
	}
}
