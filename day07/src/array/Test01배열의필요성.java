package array;

public class Test01배열의필요성 {
	public static void main(String[] args) {
		// 배열(Array)
		// - 공통 프로그래밍(기초)의 마지막 개념
		// - 다량의 동일 데이터를 효율적으로 처리하기 위한 도구
		// - 참조형 데이터
		
		//배열 생성 (정수 3개)
		//int arr[] = new int[] {10, 20, 30}; //C언어의 잔재
		int[] arr = new int[] {10, 20, 30};
	//int 다발(묶음)	= 새롭게 창조(동적 할당 연산자) 무엇을? int[]를;
		// arr ---------->[10] [20] [30] // 시작점(+0)
		
		System.out.println(arr); //리모컨 자체는 역할이 없음 (일련번호만 나옴, 주소아님)
		System.out.println(arr[0]); // arr리모컨이 가리키는 시작점에서 + 0칸 떨어진 곳의 데이터
		System.out.println(arr[1]);  // arr리모컨이 가리키는 시작점에서 + 1칸 떨어진 곳의 데이터
		System.out.println(arr[2]); // arr리모컨이 가리키는 시작점에서 + 2칸 떨어진 곳의 데이터
		//System.out.println(arr[3]);
	}
}
