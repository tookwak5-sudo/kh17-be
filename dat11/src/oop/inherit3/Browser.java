package oop.inherit3;

//슈퍼클래스(상위클래스)
//비슷한 클래스들의 공통점을 보관하기 위한 클래스
//객체 생성이 목적이 아님
public class Browser {
	//공통필드
	private String url;

	//공통메소드
	public void refresh() {
		System.out.println("새로고침 기능 실행");
	}
	public void move() {
		System.out.println("페이지 이동 기능 실행");
	}
	
	//getset은 필드랑 한몸이기 때문에 필드라고 봐도 무방
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void init(String url) {
		this.setUrl(url);
	}
	public void show() {
		System.out.println(this.getUrl());
	}
}
