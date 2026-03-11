package array;

//30, 50, 20, 10, 40 배열을 준비
//실행하면 배열 전체 데이터 위치를 뒤집어라!
//뒤집힌 배열을 출력!
//배열의 칸 수와 무관하게 뒤집혀서 출력되도록 최적화

public class Test09배열뒤집기 {
	public static void main(String[] args) {
		int[]data = new int[] {30, 50, 20, 10, 40};
		
		int backup4 = data[4];
		int backup3 = data[3];
		data[4] = data[0];
		data[3] = data[1];
		data[2] = data[2];
		data[1] = backup3; // 위에 1로 초기화 되어서 값은 그대로, 따라서 저장을 따로 해줘야함
		data[0] = backup4; // 위에 0으로 초기화 되어서 값은 그대로
		
		for(int i =0; i< data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
