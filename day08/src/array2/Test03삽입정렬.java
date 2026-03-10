package array2;

public class Test03삽입정렬 {
	public static void main(String[] args) {
		//배열준비
		int[] data = new int[] {10, 50, 20, 30, 40};
		
		//삽입정렬 (3회차)
		//1. +2지점의 데이터를 임시 백업한다.
		//2. 앞 지점들(+1, +0)과 비교하여 더 작은 값이 나오면 중지
		int backup = data[2];
		System.out.println(backup > data[1]);
		System.out.println(backup > data[0]);
		
		
		//출력
		for(int i =0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}	
	
}
