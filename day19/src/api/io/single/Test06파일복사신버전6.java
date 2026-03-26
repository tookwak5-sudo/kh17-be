package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;

public class Test06파일복사신버전6 {
	public static void main(String[] args) throws IOException {
		//목표 : 바이트배열을 이용하여 파일복사의 성능을 향상시키는 것  + 최적의 버퍼 크기
		
		//준비물은 전과 동일 (버퍼 역할을 할 배열이 추가됨)
		File readTarget = new File("D:\\kh17\\설치파일", "eclipse-java-2025-12-R-win32-x86_64.zip");
		//파일은 무조건 있다고 생각
		FileInputStream readStream = new FileInputStream(readTarget);
		File writeTarget = new File("D:\\kh17\\설치파일", "copy2.zip");
		FileOutputStream writeStream = new FileOutputStream(writeTarget);
		byte[] buffer = new byte[8192]; // 컴퓨터는 2진법 계산 그래서 2의 배수를 쓰는게 좋다  // 1000에서 10000사이가 가장 크고 그 이후는 별차이가 없다
		//그래서 8192가 자바에서 권장하는 수
		long begin = System.currentTimeMillis();
		while(true) {
			int size = readStream.read(buffer);
			if(size == -1) break; //EOF
			writeStream.write(buffer, 0, size);
		}
		long end = System.currentTimeMillis();
		long time = end - begin;
		System.out.println("소요시간 :" + time + "ms");
		
		//통로 정리
		writeStream.close();
		readStream.close();
		
	}
}
