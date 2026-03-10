package array2;
//첫 번째 턴만 먼저 구현
//전체 턴으로 업그레이드
//배열 개수가 달라지더라도 처리되도록 최적화
public class Test01선택정렬2 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		int location = 0;
		int backup = data[0];
		// 최솟값 구하기
		for(int k = 0; k < data.length; k++) {
			if(data[0] > data[k]) {
				location = k;
				data[0] = data[k];
			}
		}
		data[location] = backup;
		
		//교체 최소값의 위치에 백업을 넣어줘야한다. 백업위치는?
		
		
		
		
		// 출력
		for(int i = 0; i< data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
