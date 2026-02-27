package data;

public class Test01데이터 {
	
	public static void main (String[] args) {
		// 데이터(data)
		// - 측정 가능한 값
		// - 무언가를 판단하기 위한 근거 [가벼운 판단]
		
		//정보(Information)
		//- 데이터를 가공해서 만든 값 (Ex : 평균) [무거운 판단]
		
		//자바 프로그래밍에서의 데이터
		//- 숫자와 숫자가 아닌 것으로 나눠짐
		//- 단위는 신경쓰지 않는다 (다르면 계산 불가, 같으면 계산 가능, 비슷하면 바꿔서 계산 가능)
		
		System.out.println(100 * 200); // ('', "") 따옴표가 없으면 값으로 취급
		
		//(Q) 자장면 1그릇 7천원, 짬뽕 1그릇 8천원일 때 자장면 2그릇과 짬뽕 3그릇의 가격은?
		System.out.println(7000 * 2 + 8000 * 3);
		
		//변수(valuable) = 데이터를 잠시 담아두기 위한 저장공간이다.
		int a = 7000 * 2;
		int b = 8000* 3;
		int c = a + b;
		System.out.println(c);
		
		//우리가 원하는 최종적인 형태 (단순하게 저장하기만 하는 것이 아니라 고치는 것까지 염두)
		
		int bn = 7000; // 자장면 가격
		int rn = 8000; // 짬뽕 가격
		int bnCount = 2;  //짬뽕 주문 개수
		int rnCount = 3;  // 자장면 주문 개수		
		//입력(input) 문제에서 주어지는 값
			
		int bnTotal = bn * bnCount;
		int rnTotal = rn * rnCount;	
		int Total = bnTotal + rnTotal;		
		// 계산(process) 사칙연산 + 다른 연산기호가 들어감
		
		System.out.println(Total);		
		// 출력(output) 문제에서 요구하는 결과값
		
	// 상수가 아닌 변수끼리의 계산을 하게 하여 원하는 부분만 바꾸게 하는 방법		
	//대문자랑 소문자를 구분하는 언어는 bnC, 구분못하는 언어는 bn_Count //자바는 구분가능
	}
}
