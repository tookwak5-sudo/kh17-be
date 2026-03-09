package array;
//[30, 20, 10, 50, 40]을 배열에 저장합니다.
//사용자에게 회전시킬 칸 수를 입력받습니다. (ex : 3)
//배열을 끝과 끝이 이어진 원형 테이블이라고 생각하고 시계방향으로 입력받은 칸 수만큼 회전시킵니다.

import java.util.Scanner;

// 1칸 회전시켜보기

public class Test07배열회전3 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 20, 10, 50, 40};
		
		//회전
		Scanner sc = new Scanner(System.in);
		System.out.print("회전할 횟수 : ");
		int size = sc.nextInt();
		for(int i = 0; i < size; i++) {
			int backup = data[data.length - 1]; // 마지막 칸 데이터를 backup에 담는다
				// 마지막 칸에 마지막 칸 앞 데이터를 옮긴다. ..... 두번째 칸에 첫번째 데이터를 옮긴다. 
				//첫번째 칸에 backup 데이터를 옮긴다
				for(int k = data.length -1; k >= 1; k--) {
					data[k] = data[k-1];
				}
				data[0] = backup;
		}
		
		
		//출력
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
