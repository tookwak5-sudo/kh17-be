package api.io.string;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test01문자열과바이트 {
	public static void main(String[] args) throws IOException {
		//목표 : 문자열과 바이트의 상호 변환
		
		//문자열 -> byte
		String a1 = "Hello Java";
		String a2 = "안녕 자바";
		
		byte[] b1 = a1.getBytes();
		byte[] b2 = a2.getBytes(); // UTF-8
//		byte[] b2 = a2.getBytes("MS949"); // UTF-8에 비해 숫자가 줄어듬
		System.out.println("b1 = " + Arrays.toString(b1));
		System.out.println("b2 = " + Arrays.toString(b2));  
		// 32는 띄어쓰기임
		
		//출력
		File target = new File("files", "string.kh");
		FileOutputStream stream = new FileOutputStream(target);
		
		stream.write(b2);
		
		stream.close();
	}
}
