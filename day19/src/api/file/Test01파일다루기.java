package api.file;

import java.io.File;

public class Test01파일다루기 {
	public static void main(String[] args) {
		//파일을 만들고, 만든 파일의 정보를 프로그래밍 코드로 읽어서 출력
		// - 파일은 실재로 존재하야한다 (코드로 만들어도 되고(굳이?) 직접 생성해도 되고)
		// - 같은 프로젝트에 만들면 짧은 경로로 찾을 수 있고(상대경로) 
		// - 외부에 만들면 전에 경로를 다 작성해야 찾을 수 있다(절대경로)
		
		// 파일 제어를 위한 객체 생성
		
		//- 경로를 다 적지 않으면 자동으로 같은 프로젝트로 인지(상대경로 : relative pass)
		File a = new File("files/hello.txt");
//		File b = new File("경로1", "경로2"); // 집에서는 전체 경로 [ex) 집에서는 D드라이브가 없음] 가 없기 때문에 상대경로로 저장
		File b = new File("files", "hello.txt"); 
		
		//파일이 실재로 존재하는 지 확인
		System.out.println("a가 존재하는가 = " + a.exists());  // 옛날에 나온 클래스
		System.out.println("b가 존재하는가 = " + b.exists());
	}
}
