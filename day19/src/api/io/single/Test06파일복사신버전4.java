package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test06파일복사신버전4 {
	public static void main(String[] args) throws IOException {
		//목표 : 바이트배열을 이용하여 파일복사의 성능을 향상시키는 것  + 최적의 버퍼 크기
		
		//준비물은 전과 동일 (버퍼 역할을 할 배열이 추가됨)
		File readTarget = new File("files", "single2.kh");
		//파일은 무조건 있다고 생각
		FileInputStream readStream = new FileInputStream(readTarget);
		File writeTarget = new File("files", "copy2.kh");
		FileOutputStream writeStream = new FileOutputStream(writeTarget);
		byte[] buffer = new byte[5]; 
		
		while(true) {
			int size = readStream.read(buffer);
			if(size == -1) break; //EOF
			writeStream.write(buffer, 0, size);
		}
		
		//통로 정리
		writeStream.close();
		readStream.close();
		
	}
}
