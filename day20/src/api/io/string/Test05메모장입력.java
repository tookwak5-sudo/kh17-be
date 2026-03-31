package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
//사용자에게 파일명을 입력받아 해당하는 파일에 작성된 모든 내용을  불러와서 출력
public class Test05메모장입력 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		
		//입력 준비
		File target = new File("files", fileName);
		FileReader reader = new FileReader(target);
		BufferedReader buffer = new BufferedReader(reader);
		
		//입력
		while(true) {
			String line = buffer.readLine();
			if(line == null) break;
			System.out.println("line = " + line);
		}
		buffer.close();
		sc.close();
	}
}
