package array2;

//전체 턴으로 업그레이드
//배열 개수가 달라지더라도 처리되도록 최적화
public class Test01선택정렬4 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		for(int k = 1; k < data.length; k++) {
			//k회차 정렬
			int min = k-1; //0번 위치에 가장 작은 값이 있다고 치자
			for(int i = k; i < data.length; i++) {
				if(data[min] > data[i]) {
					min = i;
				}
			}
			
			int backup = data[min];
			data[min] = data[k-1];
			data[k-1] = backup;
		}
		
		// 출력
		for(int i = 0; i< data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}
