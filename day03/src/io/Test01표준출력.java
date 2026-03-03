package io;

public class Test01표준출력 {
	public static void main(String[] args) {
		//Console 창 = Terminal(cmd) 
		
		// 메인보드 ----- [표준 출력 통로(standard out, stdout) == System.out] ----- -> 모니터(출력장치)
		// 키보드  -----[표준 입력 통로(stdin == System.in]-----> 메인보드 --> CPU --> 내가 만든 프로그램
		
		//표준출력
		//- 표준출력통로 System.out을 이용하는 작업
		//- println() : 글자 또는 수식을 계산하여 한 줄로 출력(출력 후 \n을 자동으로 추가한다.)
		System.out.println("한줄 출력");
		System.out.println(100 + 200);
		
		//- print() : 글자 또는 수식을 계산하여 추가 효과 없이 출력
		System.out.print("연속 출력 ");
		System.out.print(100 + 200);
		System.out.print("\n");  //엔터
		System.out.println();  //엔터
		
		//- printf() : C언어에서 넘어온 출력 방식 (형식 문자를 사용)
		//- %d는 정수가 1개 들어갈 자리라는 뜻 (자리를 맡아두는 글자)
		//- %f는 실수가 1개 들어갈 자리라는 뜻
		//- %c는 글자가 1개 들어갈 자리라는 뜻
		//- %s는 문자열이 1개 들어갈 자리라는 뜻
		System.out.printf("%d + %d = %d\n", 10, 20, 30);  //
	}
}

