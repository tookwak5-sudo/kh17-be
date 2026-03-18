package api.wrapper;

public class Test01하이브리드클래스 {
	public static void main(String[] args) {
		//Wrapper Class
		//원시형 데이터(primitive type)를 클래스로 만들어 놓은 형태
		//- Wrap 단어 자체가 "감싸다" 라는 뜻이기 때문에 원시형 데이터를 편하게 이용할 수 있도록 객체화 시키는 클래스
		//- 계산이 간단할수록 원시형이 유리하며 계산이 복잡할수록 참조형이 유리하다
		
		//간단한 계산 : 10 더하기 20
		// int version
		int a = 10;
		int b = 20;
		//int c = a + b;
		int c = Integer.max(a, b);
		System.out.println("c= " + c);
		
		
		
	}
}
