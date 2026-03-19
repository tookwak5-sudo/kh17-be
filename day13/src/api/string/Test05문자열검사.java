package api.string;

public class Test05문자열검사 {
	public static void main(String[] args) {
		//문자열을 다양한 방법으로 검사하는 코드
		
		String url = "https://www.naver.com";   
		String domain = "https://www.google.com";
//		System.out.println("보안이 적용된 주소인가요?");
//		System.out.println(url.startsWith("https://"));
		
		System.out.println("상업용 사이트인가요?");
//		System.out.println(url.endsWith(".com"));
		System.out.println(url.equals(domain));
//		System.out.println("네이버와 관련된 사이트 인가요?");
//		System.out.println(url.contains("naver")); //naver의 포함 여부
//		System.out.println(url.indexOf("naver")); //naver의 시작점 위치 // 없으면 -1
//		System.out.println(url.lastIndexOf("naver"));
//		
//		System.out.println("주소는 몇 글자 인가요?");
//		System.out.println(url.length());
//		
//		System.out.println("첫 글자가 무엇입니까?");
//		System.out.println(url.charAt(0));
//		int last = url.length() - 1;
//		System.out.println(url.charAt(last));
		
		
	}
}
