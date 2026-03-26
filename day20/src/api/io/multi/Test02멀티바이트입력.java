package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02멀티바이트입력 {
	public static void main(String[] args) throws IOException {
		// 멀티바이트 입력
		// -딱 내보낸 만큼만 입력 // 출력에서 보면 데이터는 입력한 순서로 데이터를 입력해야함
		
		//준비물 생성
		File target = new File("files", "multi.kh"); // 디렉토리 만드나? No 디렉토리가 없으면 못읽는게 정상
		
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);
		
		//구조 : [프로그램] ← [data] ← [buffer] ← [stream] ← [target] ← [실제파일]
		//입력은 data를 이용해서 데이터의 종류별 입력 명령을 사용한다
		int a = data.readInt();  // 파일에서 4byte 읽어와서 int로 만들어서 내놔!
		double b = data.readDouble(); // 파일에서 8byte 읽어와서 double로 만들어서 내놔
		char c = data.readChar(); //파일에서 2byte읽어와서 double로 만들어서 내놔
		float d = data.readFloat(); //파일에서 4byte읽어와서 double로 만들어서 내놔
		long e =data.readLong();//파일에서 8byte읽어와서 double로 만들어서 내놔
		
		
		//통로정리
		data.close();
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
	}
}

