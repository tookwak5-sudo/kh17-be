package api.collection4;

import java.util.Stack;

public class Test01후입선출저장소 {
	public static void main(String[] args) {
		//Stack
		//- 후입선출(LIFO, Last-IN-First-Out) 구조의
		//- 작업이력 관리에 사용, 프로그래밍의 스택 메모리의 구성원리로 사용
		//- 고유 기능만 쓰기 때문에 업캐스팅이 필요하지 않다
		// - 추가 (push), 확인 (peek), 제거(pop)
		
		Stack<String> stack = new Stack();
		
		stack.push("네모");
		stack.push("세모");
		stack.push("동그라미");
		
		System.out.println("최신 =" + stack.peek());
		stack.pop();
		System.out.println("최신 =" + stack.peek());
		stack.pop();
		System.out.println("최신 =" + stack.peek());
		stack.pop();
		//System.out.println("최신 =" + stack.peek());
	}
}
