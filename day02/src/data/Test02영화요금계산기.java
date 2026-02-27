package data;

public class Test02영화요금계산기 {
		public static void main(String[] args) {
			//입력
			int adult = 15000; // 성인요금
			int teen = 9000; // 청소년요금
			int child = 5000; // 어린이요금
			int adultCount = 2; // 성인 인원 수
			int teenCount = 1;  // 청소년 인원 수
			int childCount = 2;  // 어린이 인원 수
			
			//계산
			int adultTotal = adult * adultCount; // 성인 요금 합
			int teenTotal = teen * teenCount; // 청소년 요금 합
			int childTotal = child * childCount; // 어린이 요금 합
			int total = adultTotal + teenTotal + childTotal; // 총합
			
			//출력
			System.out.println(total);
		}
}
