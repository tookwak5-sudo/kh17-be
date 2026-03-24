package api.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test09여러가지테스트 {
	public static void main(String[] args) {
		//여러종류의 리스트를 만들어보고 차이점을 분숙
		//- ArrayList, LinkedList, CopyOnWriteArrayList, Vector
		
		List<String> a = new ArrayList<>();  // 배열과 유사한 리스트
		List<String> b = new LinkedList<>(); // 연결 형태 리스트
		List<String> c = new CopyOnWriteArrayList<>(); //동기화 처리된 배열 형태의 리스트 // thread 
		List<String> d = new Vector<>();// 과거에 사용하던 리스트 (업캐스팅 안하고 고유한 형태로 사용하는 경향이 강함)
		
		//a,b,c,d,는 구조가 달라도 명령이 같다
		//add(), size(), contains(), remove(), get() 등 모든 명령이 동일
		
		b.add("피카츄");
		b.add("라이츄");
		
		System.out.println("개수 = " + b.size());
		System.out.println("피카츄? " + b.contains("피카츄"));
	}
}
