package array3;
//다음 형태의 이차원 배열을 반복문을 활용하여 만들어보세요
//
//1번 문제
//1     2     3     4     5
//6     7     8     9     10
//11    12    13    14    15
//16    17    18    19    20
//21    22    23    24    25
public class Test02이차원배열생성실습 {
	public static void main(String[] args) {
		//배열생성
		int[][] chart = new int[5][5];
		
		int num = 1;
		
		for(int i =0; i < chart.length; i++) {
			for(int k = 0; k < chart[i].length; k++) {
				chart[i][k] = num;
				num += 1;
			}
		}
		
		//배열출력
		for(int i =0; i < chart.length; i++) {
			for(int k = 0; k < chart[i].length; k++) {
				System.out.print(chart[i][k] + "\t");
			}
			System.out.println();
		}
	}
}
