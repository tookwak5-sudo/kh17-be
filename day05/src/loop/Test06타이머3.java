package loop;

import java.util.Scanner;

public class Test06타이머3 {
	public static void main(String[] args) throws Exception{
		
		// 시작 값을 변수 처리
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("분 입력 : ");
		int inputMinute = sc.nextInt();
		System.out.print("초 입력 : ");
		int inputSecond = sc.nextInt();
		
		//처리
		int time = inputMinute * 60 + inputSecond;
		
		//출력
		for(int i = time * 100 ; i >=0 ; i--) {
			int minute = i / 6000;
			int second = i / 100 %60;
			int ms = i % 100;
			System.out.println(minute + "분" + second + "초" + ms);
			
			Thread.sleep(10); // 1초 대기
		}
		System.out.println("★시간종료★");
		java.awt.Toolkit.getDefaultToolkit().beep();
    }
}

