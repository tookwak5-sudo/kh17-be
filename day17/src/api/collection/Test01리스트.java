package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test01리스트 {
	public static void main(String[] args) {
		//객체 생성
		ArrayList a = new ArrayList(); // 내부 데이터의 종류를 알 수 없음
		ArrayList<String> b = new ArrayList<String>(); // 무조건 STring만 지정 가능 스티커 부착 = 제네릭 타입 설정
		//ArrayList<int> c = new ArrayList<int>(); // 제네릭 타입에는 반드시 클래스의 기능. (즉, 원시형은 불가)
		ArrayList<Integer> c = new ArrayList<Integer>(); //int또는 integer값 저장 가능
		List<String> d = new ArrayList<String>(); // 업캐스팅
		
		
		List<String> e = new ArrayList<>(); // 자료형 생략 (최종형태)
		
		// 저장소를 사용 (데이터 추가, 확인, 삭제)등...)
		e.add("피카츄"); // 위치(0)
		e.add("라이츄"); // 위치(1)
		e.add("파이리"); // 위치(2)
		e.add("꼬부기"); // 위치(3)
		
		System.out.println("e = " + e.toString());
		//System.out.println(e[0]); //배열이었다면
		System.out.println(e.get(0));
		System.out.println(e.get(1));
		System.out.println(e.get(2));
		System.out.println(e.get(3));
		
		//데이터 개수 확인 (배열의 length와는 다름)
		System.out.println(e.size()); // 0~ size-1
		
		//데이터 검색
		System.out.println(e.contains("꼬부기"));
		System.out.println(e.contains("또또가스"));
		
		//데이터 삭제
		e.remove(1); //1번 위치 데이터 삭제(라이츄);
		System.out.println("e + = " + e.toString());
		e.remove("꼬부기"); // 데이터 삭제
		System.out.println("e + = " + e.toString());
	}
}
