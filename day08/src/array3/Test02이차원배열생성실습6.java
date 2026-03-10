package array3;
//다음 형태의 이차원 배열을 반복문을 활용하여 만들어보세요
//
//2번 문제
//1     2     3     4     5
//10    9     8     7     6
//11    12    13    14    15
//20    19    18    17    16
//21    22    23    24    25
public class Test02이차원배열생성실습6 {
	public static void main(String[] args) {
		//배열 준비
		int[][] numbers = new int[5][5];
		
		//초기화
		int n = 1;
		for(int i = 0; i < numbers.length; i++) {
			for(int k = 0; k < numbers[i].length; k++) {
				if(i % 2 == 0) {
					numbers[i][k] = n;
				}
				else {
					//numbers[i][4-k] = n;
					int reverse = numbers.length -1 -k;
					numbers[i][reverse] = n;
				}
				n++;
			}
		}
		
		
		
		//배열출력
		for(int i=0; i <numbers.length; i++) {
			for(int k = 0; k <numbers[i].length; k++) {
				System.out.print(numbers[i][k] + "\t");
			}
			System.out.println();
		}
	}
}
