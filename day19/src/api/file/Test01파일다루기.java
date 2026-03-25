package api.file;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01파일다루기 {
	public static void main(String[] args) throws IOException {
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
		
		//파일 or 디렉터리? 어떤건지 확인
		if(a.exists() == false) return;
		// - 파일은 총 3가지 상태가 존재(없음 : 잘못지정했을때, 파일, 디렉터리)
		System.out.println("a가 파일? = " + a.isFile());
		System.out.println("a가 디렉터리? = " + a.isDirectory());
		
		// 여기까지 확인을 해야 파일(디렉터리)에 대한 처리를 할 수 있다!! 
		
		if(a.isFile()) { //a가 파일일 때만 작업을 진행할게!
			//파일 정보 분석
			System.out.println("이름 = " + a.getName());
			System.out.println("이름 = " + a.getPath()); // 생성 시 입력한 경로
			System.out.println("이름 = " + a.getAbsolutePath()); // 절대경로(실제 위치)
			System.out.println("위치 = " + a.getCanonicalPath()); // 깔끔한 위치, 불필요한 글자 제거되어 있는;
			System.out.println("크기 = " + a.length()); // 파일의 크기 = 파일에 들어있는 글자의 길이 -> lenght();
			//System.out.println("파일 최종 수정시각 = " + a.lastModified());
			
			// 최종 수정 시각을 '2026년 3월 25일 오전 9시 3131 형태로
			// Date + SimpleDateFormat 
			Date d = new Date(a.lastModified());
			Format f = new SimpleDateFormat("y년 M월 dd일 a h:MM:ss");
			System.out.println("파일 최종 수정시각 =" + f.format(d));
			
			//파일의 상태 분석
			System.out.println("읽기 가능 = " + a.canRead());
			System.out.println("쓰기 가능 = " + a.canWrite());
			System.out.println("실행 가능 = " + a.canExecute());
			System.out.println("숨김 파일 = " + a.isHidden());
			
			//(Q) 이 파일의 확장자를 출력해보기
			// - 확장자는 파일의 마지막에 있는 : 뒤의 글자
			// - 파일의 종류를 구분할 수 있으며 운영체제에서 이 확장자에 따라 실행해야할 프로그램을
			// - 확장자는 없을 수 있으며 없어도 아무 문제 없음
			String name = a.getName();
			int dotPosition = name.lastIndexOf("."); // 맨 오른쪽 점의 위치를 찾아라!
			if(dotPosition == -1 || name.endsWith(".")) { // 점이 없거나 점으로 끝나면 확장자 없음
				System.out.println("확장자가 없는 파일입니다.");
			}
			else {// 나머지는 확장자 있음
				String extension = name.substring(dotPosition + 1);
				System.out.println("확장자 = " + extension);
			}
		}
		
		
	}
}
