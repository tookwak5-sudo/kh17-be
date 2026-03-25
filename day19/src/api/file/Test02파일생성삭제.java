package api.file;

import java.io.File;
import java.io.IOException;

public class Test02파일생성삭제 {
	public static void main(String[] args) throws IOException, InterruptedException {
		//파일을 만들 때도 파일 객체가 필요 (없는 대상을 만들어서 가리켜야함)
		//File target = new File("files/new.txt");
		File target = new File("files", "new.txt");
		System.out.println("파일이 있나요 = " + target.exists());
		
		boolean isCreated = target.createNewFile();
		System.out.println("생성 여부 = " + isCreated); 
		// eclipse 아쉬운점 : 프로그램으로 실시간으로 만든 파일이 갱신이 안됨 
		// : 폴더에 커서를 두고 f5를 눌러주기
		
		target.setWritable(false); //작성금지야
		
		//5~10초 후 삭제되도록 처리
		Thread.sleep(5000L);
		
		//파일 지우는 명령
		//target.delete(); //파일 삭제
		File target2 = new File("files", "change.txt");
		target.renameTo(target2);
	}
}
