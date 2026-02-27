package data;

public class Test05술값계산기 {
		public static void main(String[] args) {
			// 입력
			int price = 100000;  
			int pCount = 7;
			
			//처리
			int perMoney = price / pCount;
			int restMoney = (price % pCount);
			
			//출력
			System.out.println(perMoney);
			System.out.println(restMoney);
		}
}
