package array3;
//다음 형태의 이차원 배열을 반복문을 활용하여 만들어보세요
//
//1번 문제
//1     2     3     4     5
//6     7     8     9     10
//11    12    13    14    15
//16    17    18    19    20
//21    22    23    24    25
public class Test02이차원배열생성실습4 {
	public static void main(String[] args) {
		//배열 준비
		int[][] numbers = new int[5][5];
		
		int limit = numbers.length * numbers[0].length;
		int x = 0, y =0;
		for(int i =1; i <= limit; i++) {
			numbers[x][y] = i;
			y++; // 우측으로 한칸씩 이동
			if(y == numbers[0].length) { //벗어나려 한다면
				x++; //한줄 아래로 이동
				y = 0; //첫칸으로 이동
			}
		}
		
		//배열출력
//		for(int i=0; i <numbers.length; i++) {
//			for(int k = 0; k <numbers[i].length; k++) {
//				System.out.print(numbers[i][k] + "\t");
//			}
//			System.out.println();
//		}
	}
}
