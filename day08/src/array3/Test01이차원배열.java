package array3;

public class Test01이차원배열 {
	public static void main(String[] args) {
		//이차원 배열
		//-일차원 배열들이 모여있는 형태
		//-이해하기 가장 쉬운 형태는 "표"
		
		int[][] data = new int[][] {
			{2, 3, 6},
			{7, 1, 5}
		};
		//data ----> data[0] ----> [2, 3, 6]
		// 		     data[1] ----> [7, 1, 5]
		System.out.println(data); //리모컨 2차원
		System.out.println(data[0]); // 리모컨 1차원
		System.out.println(data[1]); // 리모컨 2차원
		
		System.out.println(data[0][0]);
		System.out.println(data[0][1]);
		System.out.println(data[0][2]);
		System.out.println(data[1][0]);
		System.out.println(data[1][1]);
		System.out.println(data[1][2]);
	}
}

