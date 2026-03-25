package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//		프로젝트 내에 있는 files/single.kh 파일을 읽어와서 같은 위치에 
//		copy.kh라는 이름의 파일에 그대로 복사하세요
public class Test03파일복사해설 {
	public static void main(String[] args) throws Exception { // IO 
		
		//입력용 준비물
		File target = new File("D:\\kh17\\설치파일", "eclipse-java-2025-12-R-win32-x86_64.zip"); 
		if(!target.isFile()) { // 이게 없으면 파일이 없을 때 오류가 생김
			System.out.println("복사가 가능한 파일이 아닙니다.");
			System.exit(1);
			// return은 메소드 중지 exit(1)은 외부의 도움을 받아서 프로그램을 종료
		}
		FileInputStream streamIn = new FileInputStream(target);
		
		//출력용 준비물 : 기본적으로 파일이 없기 때문에 있는지 없는지 검사할 필요x
		File copy = new File("D:\\kh17\\설치파일", "copy.zip");
		FileOutputStream streamOut = new FileOutputStream(copy);
		
		//한 글자 입력받아 출력(= 복사)
		//for(int i = 0; i < streamIn.length(); i++){}
		while(true) {
			int n = streamIn.read();
			if(n == -1) break; //EOF(End-Of-File) 발견
			streamOut.write(n);
		}
		//정리정돈
		streamOut.close();
		streamIn.close();
		
	}
}
