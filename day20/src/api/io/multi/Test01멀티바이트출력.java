package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Test01멀티바이트출력 {
	public static void main(String[] args) throws Exception {
		//원시형 데이터(raw type)와 같은 크기가 정해진 멀티바이트의 출력 
		//객체와는 다름 / 객체는 크기를 예측할 수 없으나 원시형 데이터는 크기를 측정 가능
		// - 준비물 : 파일객체, 출력통로, 임시저장소, 분해도구
		
		File dir = new File("files");
		//dir.mkdir(); // 디렉터리 생성(mkdir - 1차폴더까지만 생성) 
		dir.mkdirs(); // 디렉터리 생성(mkdirs - 전체를 다 생성) // 내가 만든 것 중 누락된 중간 디렉터리가 있다면 자동으로 채워줌
		
		File target = new File(dir, "multi.kh");  // 이렇게만 코드를 짜면 디렉토리가 반드시 있어야함
		
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		DataOutputStream data = new DataOutputStream(buffer);
		
		// 최종구조 : [프로그램] -> [data] -> [buffer] -> [stream] -> [target] -> [실제파일]
		//분대 도구(data)에게 어떤 종류의 데이터인지 알려주면서 출력을 지시
		//stream.write(바이트);
		data.writeInt(100); // `100`을 int로 생각하고 조각내서 출력하라 (예상 아마 4조각으로 나눠서 전송하겠지?)
		data.writeDouble(100); // `100`을 double로 생각하고 조각내서 출력하라(예상 아마 8조각으로 나눠서 전송하겠지?)
		data.writeChar(100); // `100`을 double로 생각하고 조각내서 출력하라(예상 아마 8조각으로 나눠서 전송하겠지?)
		data.writeFloat(100);
		data.writeLong(100);
		
		//정리 코드
		//data.flush(); // 남아있는 데이터를 밀어내라! ex)변기 물만 내리면 flush
		data.close();  // ex)변기 물 내리고 변기를 부수면 close
		// 정리코드의 유무에 따라 파일(multi.kh)에 데이터가 저장이 되거나 되지 안거나 함
		// 남아있는 데이터를 밀어내고 통로를 폐쇄하라!
		// ? 왜 데이터를 닫지? buffer에 데이터가 안 모여서 데이터 전송이 안되는거였는데?
		// 통로는 위에서 전부 연결시켜 놓았기 때문에 데이터를 닫아도 나머지가 자동으로 닫침
	}
}
