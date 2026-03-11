package array3;

import java.util.Random;

//다음 형태의 이차원 배열을 반복문을 활용하여 만들어보세요
//
//3번 문제
//1부터 25까지 숫자가 무작위로 들어가있는 빙고판 
public class Test02이차원배열생성실습7 {
	public static void main(String[] args) {
		//빙고판 만들기
		//1.빙고판은 정사각형이다
		//2. 중앙이 있어야 한다(줄칸이 홀수)
		//- 계획은 3x3에서 구현한 뒤 확장시켜 구현
		//배열 준비
		int size = 3;
		int[][] numbers = new int[size][size];
		
		//초기화
		Random r = new Random();
		for(int i = 1; i <= size * size; i++) {//값을 기준으로
			//위치를 랜덤으로 추첨(2개)
			int x = r.nextInt(size);
			int y = r.nextInt(size);
			System.out.println("(" + x + "," + y + ") 위치에" + i+ "를 추가");
			if(numbers[x][y] == 0) {//숫자가 들어간 적 없는 칸이면
				numbers[x][y] = i;//숫자를 넣으세요;
			}
			else {
				//다시 뽑으세요
				i--; // 반복문을 1회 증가시키는 효과 (현재 턴 무효코드)
			}
		}
		//배열출력
		for(int i=0; i <size; i++) {
			for(int k = 0; k <size; k++) {
				System.out.print(numbers[i][k] + "\t");
			}
			System.out.println();
		}
	}
}
