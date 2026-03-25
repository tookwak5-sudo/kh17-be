package api.file;

import java.io.File;

public class Test03디렉터리제어 {
	public static void main(String[] args) {
		//객체 생성
		File dir = new File("files");
		
		System.out.println("있나요 = " + dir.exists()); 
		System.out.println("디렉터리인가요 = " + dir.isDirectory()); // 디렉토리가 있냐 없냐만 검사하더라도 존재의 유무를 알 수 있다
		
		if(dir.isDirectory()) { //dir이 디렉터리일 경우
			System.out.println("이름 = " + dir.getName());
			System.out.println("상대경로 = " + dir.getPath()); // 기준점이 없으면
			System.out.println("절대경로 = " + dir.getAbsolutePath()); // 기준점이 있으면
			System.out.println("크기 = " + dir.length()); // 디렉터리의 크기는 없음 운영체제에 따라 아주 작은 크기를 주는 경우도 있음
			
			//디렉터리의 주요 작업은? 
			// - 내부에 존재하는 구성요소들의 이름을 확인하거나 객체를 추출하거나..
			
			System.out.println("-".repeat(20));
			// - 이름만 추출
			String[] names = dir.list();
			//for(int i = 0; i < names.length; i++) {} // 기존의 방식
			for(String name : names) { //확장방식 : 지금은 그냥 이름을 보여주기 위함이니까 
				System.out.println("-> " + name);
			}
			
			System.out.println("-".repeat(20));
			// - 객체를 추출
			 File[] files = dir.listFiles();
			 for(File file : files) {
				 System.out.println("->" + file.getAbsolutePath());
			 }
		}
	}
}
