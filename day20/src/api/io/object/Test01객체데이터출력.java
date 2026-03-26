package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test01객체데이터출력 {
	public static void main(String[] args) throws IOException {
		//객체 데이터 출력
		
		//객체 준비
		// - (중요) 아무 객체나 되는게 아니라  java.io.Serializable을 상속받은 클래스만 가능
		Date d = new Date(); // 시간이라는 객체를 저장해보고 싶다
		
		//출력 준비
		File target = new File("files", "time.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream object = new ObjectOutputStream(buffer);
		
		//object에 준비한 객체를 내보내도록 지시
		object.writeObject(d); // `d`라는 객체를 알아서 부숴서 파일로 출력해라! (실제로는 버퍼에 대기중: 모아서 가야하기 때문에);
		
		//버퍼 비우기 및 종료
		object.close();
	}
}
