package array2;

import java.util.Arrays;

public class Test03삽입정렬7 {
	public static void main(String[] args) {
		//배열준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//정렬
		Arrays.sort(data);
		
		//출력
		for(int i =0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}	
	
}
