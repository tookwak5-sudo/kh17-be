package array2;
//첫 번째 턴만 먼저 구현
//전체 턴으로 업그레이드
//배열 개수가 달라지더라도 처리되도록 최적화
public class Test01선택정렬 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		// 최솟값 구하기
		int min = data[0];
		for(int i =0; i< data.length; i++) {
			if(min > data[i]) {
				min = data[i];
			}
		}
		System.out.println(min);
		//교체
		
		
		
		// 출력
//		for(int i = 0; i< data.length; i++) {
//			System.out.println(data[i]);
//		}
	}
}
