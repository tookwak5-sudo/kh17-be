package array2;

public class Test02버블정렬6 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//1회차 버블정렬
		for(int i = 0; i <=3; i++) {
			if(data[i] > data[i+1]) { // 앞 데이터가 크다면
				int backup = data[i];
				data[i] = data[i+1];
				data[i+1] = backup;
			}
		}
		
		
		//출력
		for(int i =0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}
