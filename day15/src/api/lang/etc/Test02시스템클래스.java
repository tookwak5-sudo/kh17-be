package api.lang.etc;

public class Test02시스템클래스 {
	public static void main(String[] args) {
		//System 클래스
		//- 프로그램 외부 시스템(ex : 운영체제)의 정보를 불러오는 클래스
		//- 객체 생성은 불가(이미 설정된 정보만 이용가능)
		
		//1. 시스템의 시간 읽기
		long current = System.currentTimeMillis();
		System.out.println("현재시각 =" + current);
		
		//2. 시스템의 정보 읽기( 환경변수 등)
		//System.out.println(System.getProperties());
		System.out.println(System.getProperty("os.name"));//운영체제의 이름
		System.out.println(System.getProperty("user.country"));//운영체제에 설정된 지역
		System.out.println(System.getProperty("user.language"));//운영체제에 설정된 언어
		//ko-kr / en-Us : 언어 - 지역 
		System.out.println(System.getProperty("java.version"));//이 pc에 설치된 자바버전
		System.out.println(System.getProperty("user.home"));// 현재 사용자의 전용폴더; 권한제한없이 쓸 수 있는 폴더
		System.out.println(System.getProperty("user.dir")); // 프로그램이 실행되는 폴더
		
		//운영체제 탐지
		String name = System.getProperty("os.name");
		
		if(name.toLowerCase().startsWith("windows")) {
			System.out.println("윈도우 사용중이네");
		}
		else if(name.toLowerCase().startsWith("mac")) {
			System.out.println("맥 사용중이네");
		}
		
		//3. 각종 스트림(통로)을 필드로 가짐
		// - 표준 출력 : System.out
		// - 표준 입력 : System.in
		// - 표준 오류 : System.err
		System.err.println("테스트");
		System.out.println("테스트");
		//통로가 한 개일 때는 순서대로 나오지만 , err, out은 서로 다른 통로(stream)를 가지고 있기 때문에 
		//원하는 결과가 안나올 수 있기 때문에 색상이 아니라 용도로서 사용(ex. err은 try-catch에서 오류 났을 때 사용)
		
		//4. 시스템의 종료 기능 사용(프로그램 종료)
		System.exit(0); //어디서 실행하든 프로그램이 끝나버림
		// 메소드를 끄는 return이나 반복문을 끄는 break 시스템을 끄는 exit();
		// 0 : 아무 문제 없이 꺼졌다 / 0이 아닌 무언가 : 문제가 생김
		System.out.println("이 메세지는 절대 안나옴");
	}
}
