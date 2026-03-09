package array;
//[30, 20, 10, 50, 40]을 배열에 저장합니다.
//사용자에게 회전시킬 칸 수를 입력받습니다. (ex : 3)
//배열을 끝과 끝이 이어진 원형 테이블이라고 생각하고 시계방향으로 입력받은 칸 수만큼 회전시킵니다.

// 1칸 회전시켜보기

public class Test07배열회전 {
	public static void main(String[] args) {
		int[] seats = new int[] {30, 20, 10, 50, 40};
		
			seats[0] = 40;
			seats[1] = 30;
			seats[2] = 20;
			seats[3] = 10;
			seats[4] = 50;
			
			for(int i = 0; i <seats.length; i++) {
				seats[i] = seats[i+1];
				if(i > seats.length) {
					 
				}
			}
			
			for(int i = 0; i< seats.length; i++) {
				System.out.println(seats[i]);
			}
	}
}
