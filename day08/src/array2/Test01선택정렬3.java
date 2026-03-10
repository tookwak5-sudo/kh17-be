package array2;

//전체 턴으로 업그레이드
//배열 개수가 달라지더라도 처리되도록 최적화
public class Test01선택정렬3 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		int location = 0;
		
		for(int i =0; i < data.length; i++) {
			int backup = data[i];
			for(int k = i; k < data.length; k++) {
				if(data[i] > data[k]) {
					location = k;
					data[i] = data[k];
				}
			}
			data[location] = backup;
		}
		// 출력
		for(int i = 0; i< data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}
