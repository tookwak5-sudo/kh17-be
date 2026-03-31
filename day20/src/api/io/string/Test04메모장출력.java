package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test04메모장출력 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 입력: " );
		String fileName = sc.nextLine();
		
		File target = new File("files", fileName);
		FileWriter writer = new FileWriter(target);
		BufferedWriter buffer = new BufferedWriter(writer);
		PrintWriter printer = new PrintWriter(buffer);
		
		while(true) {
			System.out.print("입력 : " );
			String input = sc.nextLine();
			if(input.equals("종료")) break;
			printer.println(input);	
		}
		printer.close();
		sc.close();
	}
}
