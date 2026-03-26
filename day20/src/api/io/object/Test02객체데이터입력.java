package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02객체데이터입력 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//준비물 : 파일 + 각종 통로들
		
		//출력준비
		File target = new File("files", "time.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream object = new ObjectInputStream(buffer);
		
		//oject를 이용해서 "객체" 1개를 읽도록 지시
		Date d = (Date)object.readObject();//변환하는게 아니라 되돌리는 것(다운캐스팅)
		
		object.close();
		Format f = new SimpleDateFormat("y년 M월 d일 a h시  m분 s초");
		System.out.println("저장했던 시각 : " + f.format(d));
	}
}
