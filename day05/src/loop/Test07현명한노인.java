package loop;

public class Test07현명한노인 {
	public static void main(String[] args) {
		
//		//입력
//		long gold = 1;
//		int day = 40;
//		//처리
//		
//		//출력
//		for(int i = 1; i <= day; i++) {
//			System.out.println(i + "일차 :" + gold +"개");
//			gold *= 2;
//		}
		
		//입력
		
		long gold = 1;
		int day =1;
		int days = 40;
		
		//처리
		
		//출력
		for(int i = day; i <= days; i++) {		
			System.out.println(i+"일차 "+gold + "골드");
			gold *= 2;
		}
		
		
	}
}