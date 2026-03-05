package loop;

//다음 값들을 출력할 수 있는 반복문을 만들어보세요

//1. 1부터 100까지의 정수
// -> 1이상 100이하일 동안 1씩 증가하며 코드를 실행
// i = i +1; 대입연산
// i +=1;  복합대입연산 -=, *=, /=, %=
// i++;  증감연산  보통 앞에와 같이 많이 쓴다. (잘 안씀 ++i) // i--, --i도 존재
// 복합대입연산과 증감연산은 자료형을 지켜주고 빠르다.
//2. 소문자 알파벳
// -> 아스키코드표를 확인해본뒤 97부터 122까지 1씩 증가하며 반복
//3. 1부터 100까지의 짝수
//4. 1부터 100까지의 3의 배수
// 아스키코드 대문자와 소문자가 끊겨있다. 알파벳 대문자와 소문자가 떨어져 있다.

public class Test02반복문실습 {
	public static void main(String[] args) {
	
		for(int i =1; i<=100; i += 1) {//1부터 100까지의 정수
			System.out.println(i);
		}
		for(char i = '가'; i<= '힣'; i++) {// 소문자 알파벳
			System.out.println(i);
		}
//		for(int i = 97; i <= 122; i = i +1) {// 소문자 알파벳
//			System.out.println((char)i);
//		}
//		for(int i = 2; i<=100; i = i +2) {// 1부터 100까지의 짝수
//			System.out.println(i);
//		}
		for(int i = 1; i<=100; i++) {// 1부터 100까지의 짝수
			if(i%2 == 0) {
				System.out.println("3번 문제" + i);				
			}			
		}
//		for(int i =3; i<=9; i = i + 3) {// 1부터 100까지의 3의 배수
//			System.out.println(i);
//		}
		for(int i =3; i <= 100; i = i + 1) {// 1부터 100까지의 3의 배수
			if(i%3 == 0) {
				System.out.println("4번문제 : " + i);				
			}
		}		
	}
}
