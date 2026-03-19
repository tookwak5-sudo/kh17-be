package api.lang.etc;

import java.io.IOException;

public class Test03런타임클래스 {
	public static void main(String[] args) {
		//Runtime 클래스
		//- 생성이 잠겨있고 생성명령이 존재하는 클래스
		//- static 메소드 중에 반드시 생성메소드가 존재 (이름은 보통 getRuntime(), getInstance())
		//- 외부 실행환경을 이용할 수 있도록 도와주는 클래스
		
		//Runtime rt = new Runtime(); //불가능
		Runtime rt = Runtime.getRuntime(); // 가능
		
//		System.out.println(rt.availableProcessors()); //cpu코어갯수
//		System.out.println(rt.freeMemory());// // 여유메모리 바이트
		//운래는 get어쩌구여야하는데 이름이 다르다! why?
		//자바 버전이 1.0,1.4시대 지금과는 개발환경이 다르다.
		//이름이 체계를 갖추고 만들어지기 시작한 것은 1.7정도 부터
		//rt.exec("터미널로 전송할 명령");
		try {
		//	rt.exec("notepad");//터미널에 notepad라고 입력하세요!
		//	rt.exec("cmd /c start https://www.naver.com");//터미널에 start https://www.google.com 이라고 입력하세요!
			// 권한이 없어서 못열음.. 피싱위험!!! // 권한을 확보하고
			
			String[] command = new String[] {"cmd", "/c", "start", "https://www.google.com"};
			rt.exec(command);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
