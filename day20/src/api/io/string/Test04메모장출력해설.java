package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test04메모장출력해설 {
	public static void main(String[] args) throws IOException {
		
		//정상 종료가 이뤄지지 않아도 입력한 내용들이 출력되게 하려면?
		//- 버퍼를 효율적으로 쓰면 안된다.
		
		//파일명 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 : " );
		String fileName = sc.nextLine();
		
		//파일 저장 준비
		File target = new File(fileName);
		FileWriter writer = new FileWriter(target);
//		BufferedWriter buffer = new BufferedWriter(writer);
//		PrintWriter printer = new PrintWriter(buffer);
		PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(target)));
		
		//사용자 입력 및 파일 출력
		while(true) {
			System.out.print("입력 : " );
			String input = sc.nextLine();
			if(input.equals("종료")) break;
			printer.println(input);	
			printer.flush(); // 사용자가 입력할 때마다 그때그때 전송
		}
		
		//파일 저장
		sc.close();
		printer.close();
		System.out.println("저장이 완료되었습니다.");
	}
}
