package api.util.etc;

import java.util.Scanner;

public class Test03스캐너의문제점2 {
	public static void main(String[] args) {
		// - 문제가 발생하는 상황
		// - next()는 처음에 정리를 하고 입력을 받음(밥먹기 전에 설겆이 하는 사람)
		// - nextLine()은 처음에 정리를 안하고 입력 받고 \n을 버림 (밥먹고 설겆이 하는 사람)
		
			Scanner sc = new Scanner(System.in);
			
			System.out.print("단어 : ");
			String word = sc.next();//next()는 구분기호가 많아서 입력만 받고 따로 정리를 안한다(= 지저분한 사람)
			
			//(중요) next()계열의 명령 이후에 nextLine()이 나오면 엔터 정리 작업을 무조건 한 번 해줘야 한다
			sc.nextLine(); // 저장하지 않는 입력을 한번 더 실행
			
			System.out.print("한 줄 : ");
			String line = sc.nextLine();//nextLine()은 \n으로만 구분하기 때문에 정리를 하고 나온다 (= 깔끔한 사람)
			
			System.out.println("word = " + word);
			System.out.println("line = " + line);
			
			sc.close();//열려있는 통로를 닫는 명령 이제부터 잊지말고 쓰기
	}
}
