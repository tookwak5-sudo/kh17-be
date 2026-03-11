package array;

//30, 50, 20, 10, 40 배열을 준비
//실행하면 배열 전체 데이터 위치를 뒤집어라!
//뒤집힌 배열을 출력!
//배열의 칸 수와 무관하게 뒤집혀서 출력되도록 최적화

public class Test09배열뒤집기3 {
	public static void main(String[] args) {
		int[]data = new int[] {30, 50, 20, 10, 40};
		
		for(int i = 0; i <= data.length/2; i++) {
			int backup = data[data.length - 1 - i];
			data[data.length - 1 - i] = data[i] ;
			data[i] = backup;
		}
		
		for(int i =0; i< data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
