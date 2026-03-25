package api.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExplorer {
	
	//필드
	private String path;
	
	//메소드
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	
	//생성자
	public FileExplorer() {}
	public FileExplorer(String path) {
			this.setPath(path);
	}
	public void show() {
		File target = new File(this.path);
		
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
	public void move(String input) {
		//원래 가진 path와 전달받은 input을 잘 === 합쳐서 하나의 경로로 완성시킨다
		//문자열 계산을 하면 안되기 때문에 파일로 변환해서 계산
		
		if(path == null) { // 주소가 설정된 적이 없으면
			this.setPath(input); // 첫 주소에 넣어주겠다
		}
		else {
			File current = new File(path); // 현재위치
			File destination = new File(current, input); // 현재위치 안에서 입력된 위치를 지정
			this.setPath(destination.getAbsolutePath()); // 주소창을 목적지 절대경로로 변경
		}
	}
}
