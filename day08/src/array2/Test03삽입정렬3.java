package array2;

public class Test03삽입정렬3 {
	public static void main(String[] args) {
		//배열준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//삽입정렬
		//1. +4지점의 데이터를 임시 백업한다.
		//2. 앞 지점들(+1, +0)과 비교하여 더 작은 값이 나오면 중지
		int backup = data[4];
		for(int i = 3; i >= 0; i--) {
			System.out.println(backup > data[i]);
			if(backup > data[i]) {//더 작은 데이터가 발견된다면
				break;
			}
		}
		//data[?] = backup;
		
		//출력
		for(int i =0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}	
	
}
