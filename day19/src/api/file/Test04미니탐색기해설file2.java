package api.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//(+추가) 다음과 같은 입력은 특수한 효과가 작동하도록 처리해보세요
//한 번만 보여주고 끝나는 것이 아니라 클래스를 사용하여 윈도우 탐색기처럼 위치가 계속해서 누적되도록 구현해보세요
//시작은 최상위 위치에서 합니다(드라이브 정보)
// ../ 을 입력하면 현재 위치의 상위 폴더로 이동해서 내용이 출력되어야 합니다.
// / 을 입력하면 최상위 위치가 나와야 합니다(드라이브 정보)
//이 정보는 File 클래스에 구하는 메소드가 존재합니다.
public class Test04미니탐색기해설file2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		FileExplorer explorer = new FileExplorer();
		
		while(true) {
			System.out.println("위치 : ");
			String input = sc.nextLine();
			
			if(input.equals("종료")) break;

			//explorer.setPath(input);
			explorer.move(input); // 이 메소드를 실행하면 
			explorer.show();
		}
		
		sc.close();
	}
}
