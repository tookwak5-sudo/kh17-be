package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test06파일복사신버전2 {
	public static void main(String[] args) throws IOException {
		//목표 : 바이트배열을 이용하여 파일복사의 성능을 향상시키는 것  + 최적의 버퍼 크기
		
		//준비물은 전과 동일 (버퍼 역할을 할 배열이 추가됨)
		File readTarget = new File("files", "single2.kh");
		//파일은 무조건 있다고 생각
		FileInputStream readStream = new FileInputStream(readTarget);
		File writeTarget = new File("files", "copy2.kh");
		FileOutputStream writeStream = new FileOutputStream(writeTarget);
		byte[] buffer = new byte[5]; // 나는 5글자 씩 옮기겠다
		
		//한 덩어리를 복사
		int size = readStream.read(buffer); //buffer에 가득 채워 읽고 실제로 얼마 읽었는지 size를 반환하세요
		writeStream.write(buffer);//buffer에 있는 모든 데이터를 내보내세요
		
		size = readStream.read(buffer);
		writeStream.write(buffer);
		
		size = readStream.read(buffer);
		writeStream.write(buffer); // 다음 차례에도 똑같이 쓰면 데이터가 늘어남
		
		//크기를 조절
		size = readStream.read(buffer);
		writeStream.write(buffer, 0, 2);
		
		//통로 정리
		writeStream.close();
		readStream.close();
		
		
	}
}
