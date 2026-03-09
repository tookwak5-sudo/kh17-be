package array;

public class Test08배열데이터교체 {
	public static void main(String[] args) {
		
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//원하는 두 지점의 데이터를 서로 교체할 수 있는가?
		// - 자바에서는 맞교환이 불가능
		// -(ex) +0지점과 + 3지점의 데이터를 교체
		int backup = data[0]; // 아무 데이터나 미리 백업
		data[0] = data[3];
		data[3] = backup;
		
		//출력
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
