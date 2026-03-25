package api.collection4;

import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Test02선입선출저장소2 {
	public static void main(String[] args) {
		// 직접 정렬의 기준을 만들어보자!
		//- java.lang.Comparable을 상속받던가
		//- java.util.Comparator를 상속받아서 클래스를 만들어서 메소드를 고치고 객체 생성하면 됩니다!
		//- 한번만 쓸건데 클래스까지 만들면 아깝잖아요
		//- 일회용 상속을 받을게요! (익명중첩클래스)
//		Comparator<String> rule = new Comparator<>(); // 인터페이스라 객체생성이 안됨
		Comparator<String> rule = new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2); //o1에서 o2를 뺀 결과를 반환하세요 //
			}
		};
		
	//	Queue<String> queue = new PriorityBlockingQueue<String>(10, Collections.reverseOrder());  //역순
		Queue<String> queue = new PriorityBlockingQueue<String>(10, rule);  
		queue.offer("네모");
		queue.offer("세모");
		queue.offer("동그라미");
		
		System.out.println("가장 먼저 저장된 데이터 :" + queue.peek());
		queue.poll();
		System.out.println("가장 먼저 저장된 데이터 :" + queue.peek());
		queue.poll();
		System.out.println("가장 먼저 저장된 데이터 :" + queue.peek());
		queue.poll();
	}
}
