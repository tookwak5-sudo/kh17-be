package api.collection4;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Test02선입선출저장소 {
	public static void main(String[] args) {
		//Queue
		//- 선입선출(FIFO, First=IN-First-OUT) 구조의 저장소
		// - 대기줄이 큐의 대표적인 사례
		//-프로그래밍의 모든 입출력은 전부다 큐를 거쳐서 처리됨
		//- 명령이 정해져 있음, 추가(offer), 확인(peek), 제거(poll)
		
		//interface라 new Queue가 안됨
	//Queue<String> queue = new ArrayBlockingQueue<>(10); // 일반 큐	
	//Queue<String> queue = new PriorityBlockingQueue<String>(10);//우선순위 큐 (아무설정 없으면 오름차순)
		Queue<String> queue = new PriorityBlockingQueue<String>(10, Collections.reverseOrder());  //역순
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
