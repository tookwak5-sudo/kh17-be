package array;

import java.util.Scanner;

public class Test04배열생성후초기화 {
	public static void main(String[] args) {
		//배열을 비어있는 상태로 만들 수는 없나?
		Scanner sc = new Scanner(System.in);
		
		// - 정수 다섯 개를 보관할 수 있는 비어있는 배열
		// - int[] a = new int[] {0, 0, 0, 0, 0}; // 데이터를 주고 생성  // 데이터가 적을경우
		int[] b = new int[sc.nextInt()]; // 개수를 알려주고 생성 (자동으로 초기값 설정) // 데이터를 모를경우
		
		// 초기화
//		System.out.print("숫자 입력 : ");
//		b[0] = sc.nextInt();
//		System.out.print("숫자 입력 : ");
//		b[1] = sc.nextInt();
//		System.out.print("숫자 입력 : ");
//		b[2] = sc.nextInt();
//		System.out.print("숫자 입력 : ");
//		b[3] = sc.nextInt();
//		System.out.print("숫자 입력 : ");
//		b[4] = sc.nextInt();
		
		for(int i = 0; i < b.length; i++) {
			System.out.print("숫자 입력 : ");
			b[i] = sc.nextInt();
		}
		
		//출력
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]); // b의 시작점에서 +i 떨어진 곳의 데이터를 출력
		}
		
	}
}
