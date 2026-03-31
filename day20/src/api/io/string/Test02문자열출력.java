package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test02문자열출력 {
	public static void main(String[] args) throws IOException {
		//FileOutputStream 대신 여러 처리가 추가되어 있는 FileWriter를 사용
		//+ 크기조절이 가능한 외장 버퍼 추가
		// + 출력의 자유도를 높여주는 보조 도구(PrintWriter) 추가
		File target = new File("files", "string.kh");
		FileWriter writer = new FileWriter(target);
		BufferedWriter buffer = new BufferedWriter(writer); // 얘도 버퍼 크기 조절가능
		PrintWriter printer = new PrintWriter(buffer);
		
		
		//writer를 이용해서 문자열을 출력
		//writer.write("안녕하세요 반갑습니다");
		
		//buffer를 이용해서 문자열을 출력
//		buffer.write("안녕하세요 반갑습니다");
//		buffer.write("안녕하세요 반갑습니다");
//		buffer.write(100); // print처럼 자동 변환이 안됨.. 
		
		//프린터를 이용해서 다양한 데이터를 출력
		//-write대신 print명령이 나옴 들어가는건 숫자열이더라도 print작동하고 나면 문자열로 변환
		printer.println("안녕하세요 반갑습니다.");
		printer.println("안녕하세요 반갑습니다.");
		printer.println(100 + 200);
		printer.println(3.141592);
		
		//비우기 및 종료
		printer.close();
	}
}
