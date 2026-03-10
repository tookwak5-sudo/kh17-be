package array;

public class Test09배열뒤집기해설3 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//데이터 교체
		int left = 0; // 처음
		int right = data.length - 1; // 마지막
		for(int i = 0; i < data.length / 2; i++) { //횟수가 데이터개수 나누기 2번
			System.out.println("[" + left + "] + <->["+ right + "]");
			int backup = data[left];
			data[left] = data[right];
			data[right] = backup;
			left++;
			right--;
		}
		
		
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
