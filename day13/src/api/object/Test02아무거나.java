package api.object;

import java.util.Random;
import java.util.Scanner;

public class Test02아무거나 {
	public static void main(String[] args) {
		//Object의 역할
		//Object 클래스가 정의하는 매소드를 대체
		//Object를 이용하면 "아무거나"라는 개념을 구현할 수 있다.
		
		Object a = "hello"; // String -> Object 업캐스팅
		Object b=  100; // int(integer) -> Object 업캐스팅
		Object c = new Scanner(System.in); // Scanner -> Object 업캐스팅
		
		Object d = new Random(); // Random -> Object 업캐스팅
		Object e = new int[] {1, 2, 3, 4, 5}; // int[] -> Object 업캐스팅
		Object f = false; // boolean -> Object 업캐스팅
		
		System.out.println("a = " + a);
		
		// 내가 만든 클래스는 이 아무거나에 해당되나? Yes
		
		Object s = new Student();
		System.out.println(s.hashCode());
		System.out.println(s.toString());
	}
}
