package data;

public class Test08PC방요금계산기 {
	public static void main(String[] args) {
		//우리PC방은 다음과 같이 요금을 받고 있습니다.
		//1시간 당 1000원
		//1분당 요금을 받음
		//100원보다 작은 금액은 버림 처리 (ex : 440원이 나오면 400원만 받음)

		//12시 40분에 들어와서 15시 20분에 나가는 손님의 PC이용요금을 구하여 출력
		//(단, 날새는 사람은 없음)
		
		//입력
		int hour1 = 12, minute1 = 40; // 입장시간
		int hour2 = 14, minute2 = 40; // 퇴장시간
		
		
		
		//처리
		// 시간 계산할 때 가장 작은 단위로 반환해서 계산하려고 노력하기
		int time1 = hour1* 60 + minute1;
		int time2 = hour2* 60 + minute2;
		int diff = time2 - time1; //이용시간 (분)
		
		//방법 1 곱하기 먼저
		//int price = diff /60 * 1000;
		// 방법 2 분단위 요금
		//double pricePerMinute = 1000 / 60; 소수점이 날라감
		double pricePerMinute = (double) 1000 / 60;
		System.out.println(pricePerMinute);
		
		// 이용시간을 시간과 분으로 되돌리는 처리
		int hour = diff / 60;
		int minute = diff % 60;
		
		//int price = (int) (diff * pricePerMinute) /100 * 100; //좌측 int형인데 우측 double형이므로 묵시적 변환이 안됨, 명시적 변환을 해줘야함
		
		int price = (int) (diff*pricePerMinute);//price 변수를 만들고 
		price = price /100 * 100; // 만들어진 변수에 값을 덮어쓰기 하겠다.
		
		// diff를 이용해서 요금을 계산
		//(주의) 6분당 100원이 아님, 지금 숫자에 우연히 맞는 공식이 나온거; 보편적인 코드로 만들어야함.
		
		
		//출력
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(price);
	}
}
