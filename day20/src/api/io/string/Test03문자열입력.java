package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test03문자열입력 {
	public static void main(String[] args) throws IOException {
		//문자열 입력
		//-FileInputStream으로도 가능하지만 변환을 내가 직접 하고 버퍼도 내가 설정한다는 문제가 있음 -> byte[] : 실제 저장되는 값
		//-FileReader로 입력을 받으면 변환은 자동으로 해주지만 지정한 글자수만 읽을 수 있음(ex: 10글자) -> char[] : 한글이든 영어든 한글자
		//-BufferedReader로 입력을 받으면 "한 줄 씩 읽는 것이 가능해진다 (버퍼 자동설정)
		
		//입력 준비
		File target = new File("files", "string.kh");
		FileReader reader = new FileReader(target);
		BufferedReader buffer = new BufferedReader(reader);
		
		//입력 // 문자열, byte의 EOF는 null; 넣은만큼 계산하는게 어렵기 때문에  
		
		String line = buffer.readLine(); // 1줄을 읽으세요
		System.out.println("line = " + line);
		
		line = buffer.readLine(); // 1줄을 읽으세요
		System.out.println("line = " + line);
		
		line = buffer.readLine(); // 1줄을 읽으세요
		System.out.println("line = " + line);
		
		line = buffer.readLine(); // 1줄을 읽으세요
		System.out.println("line = " + line);
		
		line = buffer.readLine(); // 1줄을 읽으세요
		System.out.println("line = " + line);
		
		line = buffer.readLine(); // 1줄을 읽으세요
		System.out.println("line = " + line);
		
		buffer.close();
	}
}
