package api.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
//(+추가) 다음과 같은 입력은 특수한 효과가 작동하도록 처리해보세요
//한 번만 보여주고 끝나는 것이 아니라 클래스를 사용하여 윈도우 탐색기처럼 위치가 계속해서 누적되도록 구현해보세요
//시작은 최상위 위치에서 합니다(드라이브 정보)
// ../ 을 입력하면 현재 위치의 상위 폴더로 이동해서 내용이 출력되어야 합니다.
// / 을 입력하면 최상위 위치가 나와야 합니다(드라이브 정보)
//이 정보는 File 클래스에 구하는 메소드가 존재합니다.
public class Test04미니탐색기 {
	public static void main(String[] args) {
		
		//사용자에게 경로 입력받기(임의로 입력해놈)
		File input = new File("D:\\");
		
		//입력한 파일or디렉토리가 존재하지 않는 경우
		if(input.exists() == false) {
			System.out.println("존재하지 않는 경로입니다");
		}
		else {
			if(input.isDirectory()) {
				String[] names = input.list();
				for(String name : names) {
					System.out.println(name + "\t [파일]");
				}
			}
			if(input.isFile()) {
				System.out.println("파일명 = " + input.getName()); //이름
				System.out.println("파일크기 = " + input.length()); // 크기
				System.out.println("!!!!!!!! = " + input.toPath()); // 크기
				Date d = new Date(input.lastModified());
				Format f = new SimpleDateFormat("y년 M월 dd일 a h:MM:ss");
				System.out.println("최종수정시각 = " + f.format(d));
			}
			
		}
	}
}
