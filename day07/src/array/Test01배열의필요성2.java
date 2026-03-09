package array;

public class Test01배열의필요성2 {
	public static void main(String[] args) {
		// 배열(Array)
		// - 반복문과 같이 사용해야 시너지가 발생
		
		
		//배열 생성 (정수 3개)
		//int arr[] = new int[] {10, 20, 30}; //C언어의 잔재
		int[] arr = new int[] {10, 20, 30, 40, 50, 60, 70, 80};
	//int 다발(묶음)	= 새롭게 창조(동적 할당 연산자) 무엇을? int[]를;
		// arr ---------->[10] [20] [30] // 시작점(+0)
		
	//	for(int i = 0; i < 3; i++) {
		for(int i=0; i<arr.length; i++) { // arr.length는 arr 배열의 길이(칸수)를 자동으로 보관하는 값
			System.out.println(arr[i]); // arr리모컨이 가리키는 시작점에서 + 0칸 떨어진 곳의 데이터
		}
		
	}
}
