package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test04메모장출력해설2 {
	public static void main(String[] args) throws IOException {
		
		//정상 종료가 이뤄지지 않아도 입력한 내용들이 출력되게 하려면?
		//- 버퍼를 효율적으로 쓰면 안된다.
		
		//파일명 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 : " );
		String fileName = sc.nextLine();
		
		//임시 파일 생성 및 저장 준비
		//-notepad어쩌구저쩌구.kh 형태로 files 폴더에 생성
		File dir = new File("files");
		File backup = File.createTempFile("notepad", ".kh", dir);
		PrintWriter backupPrinter = new PrintWriter(new BufferedWriter(new FileWriter(backup)));
		
		//사용자 입력 및 파일 출력
		while(true) {
			System.out.print("입력 : " );
			String input = sc.nextLine();
			if(input.equals("종료")) break;
			backupPrinter.println(input);	
			backupPrinter.flush(); // 사용자가 입력할 때마다 그때그때 전송
		}
		//파일 저장
		sc.close();
		backupPrinter.close();

		//파일 복사
		File target = new File(fileName);
		FileInputStream readStream = new FileInputStream(backup);
		FileOutputStream writeStream = new FileOutputStream(target);
		
		byte[] buffer = new byte[8192];
		
		
		//파일 저장 준비
//		printer.close();
//		PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(target)));
		
		
	}
}
