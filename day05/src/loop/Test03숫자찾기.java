package loop;
//1부터 100까지 범위에서 5가 들어간 숫자를 찾아서 출력
public class Test03숫자찾기 {
	public static void main(String[] args) {
 // 1. 최대한 규칙을 찾아서 반복문만으로 // 모듈화가 안되어있음
// 구간 1 : 5, 15 ,25 ,35, 45
// 구간 2 : 50, 51, 52, 53, 54, 55, 56, 57, 58, 59
// 구간 3 : 65, 75, 85, 95
		for(int i =5; i <=45; i += 10) {
			System.out.println("5가 들어간 숫자 = " + i);
		}
		for(int i = 50; i<= 59; i++) {
			System.out.println("5가 들어간 숫자 = " + i);
		}
		for(int i = 65; i<= 95; i += 10) {
			System.out.println("5가 들어간 숫자 = " + i);
		}
		
	}
}

