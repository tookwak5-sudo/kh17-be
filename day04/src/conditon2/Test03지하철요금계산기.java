package conditon2;
//사용자의 출생년도 4자리를 입력받아 지하철 요금을 계산하는 프로그램을 만드세요
//어르신 : 65세 이상 , 무료
//성인 : 20세 ~ 64세 , 1550원
//청소년 : 14세 ~ 19세 , 900원
//어린이 : 8세 ~ 13세 , 550원
//영유아 , 7세 이하 , 무료
//일회용 카드는 500원의 보증금이 있습니다.
//보증금을 합쳐서 출력해주세요
public class Test03지하철요금계산기 {
	public static void main(String[] args) {
		//입력
		int year = 2026;
		int birthYear 	= 1962;
		int deposit = 500;
		//처리
		// 나이
		int age = year - birthYear + 1;
		// 요금
		int price;
		
		String group;
		if(age >= 65) {
			group = "노인";
			price = 0;		
		}
		else if(age >=20 && age <=64) {
			group = "성인";
			price = 1550;		
		}
		else if(age >=14 && age <=19) {
			group = "청소년";
			price = 900;			
		}
		else if(age >= 8 && age <=13) {
			group = "어린이";
			price = 550;			
		}
		else {
			group = "영유아";
			price = 0;			
		}
		int sum = price + deposit;
		
		//출력
		System.out.println("나이 : " + age + "세"); //나이계산	
		System.out.println(group + ": " + sum +"원" ); 
	}
}
