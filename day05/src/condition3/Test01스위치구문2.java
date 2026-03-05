package condition3;

public class Test01스위치구문2 {
	public static void main(String[] args) {
		//switch 구문 사용법 및 그 이유
		// - 조건부 코드를 실행할 수 있는 if와 다른 실행원리를 가진 구문
		// - 게임할 때 wasd가 입력되는 방식 구현하기
		// - if문의 조건 순서대로 실행 여기서 순서대로 입력이 문제가 됨
		// - wasd는 실행 시 독립적으로 누름
		// - 게임할 때 가장 중요한 점 : 반응 속도! // 
		// - 순차적 실행이 아니라 동시실행이 가능하도록 설계된 구문 switch문
		// - switch의 목표는 한 번에 알아보기 위한 것 이 목적
		// - switch문의 단점 1. 범위가 구현이 안됨 2. 개수가 적당해야한다 30개가 마지노선
		
 		int keycode = 'k'; 
		
		switch(keycode) {//keycode의 값을 가지고 이동할 지점을 한번에 찾겠다!
		case 'w' : 
			System.out.println("앞으로 이동");
			break;
		case 'a' :
			System.out.println("좌로 이동");
			break;
		case 's' :
			System.out.println("아래로 이동");
			break;
		case 'd' :
			System.out.println("우로 이동");
			break;
		default : //case에 해당하는 것이 없다면 기본 실행되는 위치 (else 역할)
			System.out.println("지원하지 않는 키");
			//break;	 // 사용해도 안 사용해도 무방
		}		
	}
}
