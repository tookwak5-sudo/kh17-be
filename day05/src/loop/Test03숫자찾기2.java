package loop;
//1부터 100까지 범위에서 5가 들어간 숫자를 찾아서 출력
public class Test03숫자찾기2 {
	public static void main(String[] args) {
 // 2. 주어진 범위에 조건을 걸어 필터링
		
		for(int i = 1; i <=100; i++) {
			boolean ten = i/10 == 5;
			boolean one = i%10 == 5;
			boolean five = ten || one;
			if(five) {
				System.out.println("5가 들어간 숫자= " + i);
			}
		}		
	}
}

