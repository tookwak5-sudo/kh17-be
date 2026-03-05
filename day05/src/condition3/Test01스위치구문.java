package condition3;

public class Test01스위치구문 {
	public static void main(String[] args) {
		//switch 구문 사용법 및 그 이유
		// - 조건부 코드를 실행할 수 있는 if와 다른 실행원리를 가진 구문
		// - 게임할 때 wasd가 입력되는 방식 구현하기
		// - if문의 조건 순서대로 실행 여기서 순서대로 입력이 문제가 됨
		// - wasd는 실행 시 독립적으로 누름
		// - 게임할 때 가장 중요한 점 : 반응 속도! // 
		// - 동시 실행의 어려움을 해결하고 자 나온 구문이 switch문
		// - switch의 목표는 한 번에 알아보기 위한 것 이 목적
		int keycode = 'a';
		
		if(keycode == 'w') {		// 1번의 검사
			System.out.println("앞으로 이동");
		}
		else if(keycode == 'a') { // 2번 검사 필요
			System.out.println("왼쪽으로 이동");
		}
		else if(keycode == 's') { // 3번 검사 필요
			System.out.println("뒤로 이동");
		}
		else if(keycode == 'd') { // 4번 검사 필요
			System.out.println("오른쪽으로 이동");
		}
		else { 						// 5번 검사 필요
			System.out.println("지원하지 않는 키");
		}
		
	}
}
