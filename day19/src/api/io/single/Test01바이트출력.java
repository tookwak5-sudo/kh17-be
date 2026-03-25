package api.io.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01바이트출력 {
	public static void main(String[] args) throws IOException {
		//절대규칙 : 파일 및 네트워크는 무조건 1byte 규격의 데이터만 주고받을 수 있다.
		// - 바이트 출력은 규격에 딱 맞는 형태인 byte 데이터를 파일에 내보내는 것을 의미( = 저장)
		
		// 준비물 : 파일객체1개 , 파일 출력스트림 1개
		
		// 객체 생성
		File target = new File("files", "single.kh"); // 확장자 없어도 되는데 확장자 없는건 보통 매너가 아님 // 이클립스 내에서 볼거기 때문에 굳이 txt가 아니어도됨
		
//		if(!target.exists()) {
//			target.createNewFile();
//		}
		
		FileOutputStream stream = new FileOutputStream(target);
		
//		Streaam에 "byte" 데이터를 전달 ( -128 ~ +127);
		stream.write(104);//h
		stream.write(101);//e
		stream.write(108);//l
		stream.write(108);//l
		stream.write(111);//o
		stream.write(32);//띄어쓰기
		stream.write('j'); // 'j'에 해당하는 코드가 들어감 
		stream.write('a'); //'a'에 해당하는 코드가 들어감 
		stream.write('v'); // 'v'에 해당하는 코드가 들어감
		stream.write('a'); // 'a'에 해당하는 코드가 들어감
		stream.write('\n'); //w 줄바굼
	
		// 범위를 초과하는 값은 자동으로 byte로 변환되어 전송됨 (ex : 문방구 팔찌);
//		stream.write('가'); // 되나??
//		stream.write(30000); // 범위 초과?
		
		// 스트림은 메모리 점유가 높으므로 사용 종료 후에 정리하도록 습관을 들인다
		stream.close();
	}
}
