package array3;

public class Test01이차원배열3 {
	public static void main(String[] args) {
		//이차원 배열
		//-일차원 배열들이 모여있는 형태
		//-이해하기 가장 쉬운 형태는 "표"
		
//		int[][] data = new int[][] {// 크기와 데이터 지정
//			{2, 3, 6},
//			{7, 1, 5}
//		};
		int[][] data = new int[2][3]; // 크기만 지정
		data[0][0] = 2;
		data[0][1] = 3;
		data[0][2] = 6;
		data[1][0] = 7;
		data[1][1] = 1;
		data[1][2] = 5;
				
		//data ----> data[0] ----> [2, 3, 6]
		// 		     data[1] ----> [7, 1, 5]
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				System.out.print(data[i][k] + "\t");
				
			}
			System.out.println();
		}
		
		
//		System.out.println(data[0][0]);
//		System.out.println(data[0][1]);
//		System.out.println(data[0][2]);
//		
//		System.out.println(data[1][0]);
//		System.out.println(data[1][1]);
//		System.out.println(data[1][2]);
	}
}

