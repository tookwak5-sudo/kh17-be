package data3;

public class Test02문자열데이터 {
	public static void main(String[] args) {
		//문자열(String)
		// - 문자열은 문자(char)가 여러 개 모여있는 형태의 데이터 -> ex) 지갑에 돈이 없다고 돈이 아님 돈 을보관하기 위한 용도 따라서 문자가 없어도 문자열
		// - 원시형 데이터(raw type) 8종류 // 눈에 보이는 게 다. byte short int long float double boolean char 정해진 크기가 정해져 있어야함, 미리 정해져 있어야함 / 사전제작의 방식
		// - 참조형 데이터(reference type) 원시형 외는 다 참조형 //제어대상(객체)의 존재 ex) TV, 에어컨 등등 // 공간이 생명, 주문제작의 방식
		// - 쌍따옴표로 감싸서 데이터를 표현
		
		String a = "hello"; //5글자(2X5 = 10바이트)
		String b = "케이에이치정보교육원"; // 10글자 (2 x10 = 20바이트)
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(a + b); // 더하기는 가능 (연결처리)
		
		// [TIP]	변수 출력 시 더하기를 이용해서 변수이름을 붙여서 출력하는 경우가 많다.
		int c = 100;
		System.out.println("c = " + c);
		
		//-참조형 데이터이므로 리모컨 버튼 처럼 쓸 수있는 기능이 제공
		System.out.println(a.length()); // a 리모컨에 있는 length를 눌러라 -> 글자 수 
		System.out.println(b.length()); // b 리모컨에 있는 length를 눌러라 
		//System.out.println(c.length()); // c는 리모컨이 아니다. 즉, 참조형 데이터만 쓸 수  있는 기능이 존재
		
		//-특수문자가 존재 (이스케이프 문자, escape sequence)
		//-\와 어떤 글자가 만나서 특수한 효과가 발생
		//-\n : new line, 다음줄로 이동하세요
		//-\t : tab, 다음 탭으로 이동 // 스페이스랑 구분하기 위해
		
		String d = "안\n녕\n하\n세\n요";
		System.out.println(d);
		String e = "반\t갑\t습\t니\t다";
		System.out.println(e);
				
		// f라는 변수를 만들어서 다음 문자열을 저장 후 출력
		// -> 나는 저녁에 "피자"를 먹을 거에요
		String f = "나는 저녁에 \"피자\"를 먹을 거에요";  // ""를 출력하고 싶은 경우 \"\" 따옴표 전에 \(역슬래쉬)
		System.out.println("f = " + f);
		
		//데이터
		// 1.숫자
		//1) 정수 : 소수점 없는 숫자(byte/short/int/long)
		//2) 실수 : 소수점 있는 숫자 (float/double)
		//3) 글자 : 유니코드 (글자에 번호를 붙인방식) 

		// 2. 숫자가 아닌 녀석들
		//1) 논리 : true/false 숫자 등을 비교하거나 논리끼리 계산해서 하나의 판정을 만든다.
		//2) 문자열 : 글자가 여러 개 붙어있는 참조형 데이터 (주문제작 형태)
		//3) 커스텀 : 내 입맛대로 조합해서 만드는 나만의 데이터(주문제작 방식, class) 지금부터 자바
	}
}
