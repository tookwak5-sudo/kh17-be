package data;

public class Test05술값계산기2 {
		public static void main(String[] args) {
			// 입력
			int price = 100000;  
			int pCount = 7;
			
			//처리 - 만약 현금으로 정산해야돼서 1원단위를 빼야한다면?
			int perMoney = price / pCount / 10 *10;
			int restMoney = (price - perMoney* pCount);
			// 나누기를 보는 순간 최대한 천천히 보면서 고려하기 
			
			//출력
			System.out.println(perMoney);
			System.out.println(restMoney);
		}
}
