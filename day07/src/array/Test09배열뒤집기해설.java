package array;

public class Test09배열뒤집기해설 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//데이터 교체
		// -[0] 과 [4]
		int backup = data[0];
		data[0] = data[4];
		data[4] = backup;
		// -[1] 과 [3]
		backup = data[1];
		data[1] = data[3];
		data[3] = backup;
		
		
		//출력
		//-출력을 반대로 하는건 데이터가 뒤집힌 것이 아니다
//		for(int i = data.length - 1; i > 0; i++) {
//			System.out.print(data[i] + "\t");
//		}
		for(int i =0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println();
	}
}
