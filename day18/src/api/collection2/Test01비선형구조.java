package api.collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test01비선형구조 {
	public static void main(String[] args) {
		//저장소 생성
		Set<String> a = new TreeSet<>(); // 트리구조를 사용하는 저장소
		Set<String> b = new HashSet<>(); // 해시구조를 사용하는 저장소
		
		//추가
		//- 리스트와 같은 명령을 쓰지만 추가 순서는 큰 의미가 없다
		//- 트리는 정렬하면서 저장을 하고, 	해시(는 해시테이블에 분류하면서 저장(미세하게 순서가 달라질 수 있음)
		//-즉, Index가 없다. List에서는 get이 있지만 Tree나 hash에서는 특정을 하지 못하기 때문에 get명령어 사용불가 
		//-(중요) 트리와 해시는 구조적으로 동일(중복) 데이터 저장이 안됨
		
		a.add("피카츄");
		a.add("라이츄");
		a.add("파이리");
		a.add("꼬부기");
		
		a.add("피카츄"); // 중복
		
		b.add("피카츄");
		b.add("라이츄");
		b.add("파이리");
		b.add("꼬부기");
		
		b.add("피카츄"); // 중복
		
		//개수 확인
		//- 리스트와 같은 명령을 사용한다.
		System.out.println("a의 개수 =" + a.size());
		System.out.println("b의 개수 =" + b.size());
		
		//삭제
		//- 리스트와 같은 명령을 사용한다. but 위치란 개념이 없이 때문에 "위치"로 지우는 명령은 없다
		a.remove("파이리");
		
		//(중요) 위치란 개념이 없기 때문에 리스트의 get()은 존재하지 않는다.
		//System.out.println(a.get(0)); // 없음(0이란 위치는 존재하지 않음)
		
		
		//검색
		//- 리스트와 같은 명령을 사용한다.
		System.out.println("피카츄?" + a.contains("피카츄"));
		System.out.println("이브이?" + b.contains("피카츄"));
		
		//출력
		System.out.println("a =" + a);
		System.out.println("b =" + b);
	}
}
