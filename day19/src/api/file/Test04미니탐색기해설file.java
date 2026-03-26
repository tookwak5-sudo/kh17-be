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
public class Test04미니탐색기해설file {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("위치 : ");
		String input = sc.nextLine();
		sc.close();
		
		FileExplorer explorer = new FileExplorer(input);
		
		
		
		File target = new File(input);
		
		if(target.isFile()) { // 파일이라면
			System.out.println("파일명 : " + target.getName());
			System.out.println("파일크기 : " + target.length() + "bytes");
			Date d = new Date(target.lastModified());
			Format f = new SimpleDateFormat("y년 M월 dd일 a h:MM:ss");
			System.out.println("최종수정시각 : " + f.format(d));
		}
		else if(target.isDirectory()) {
			File[] files =target.listFiles();
			System.out.println("<" + target.getAbsolutePath() + " 폴더의 구성 요소>");
			for(File file : files) {
				String type = file.isFile() ? "[파일]" : "[폴더]";
				System.out.println("-> " + file.getName() + " " + type);
//				if(file.isFile()) {
//					System.out.println("-> " + file.getName() + " " + "[파일]");
//				}
//				else {
//					System.out.println("-> " + file.getName() + " " + "[폴더]");
//				}
			}
		}
		else {
			System.out.println("존재하지 않는 대상입니다.");
		}
		
	}
}
