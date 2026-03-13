package oop.inherit7;

//추상클래스 = 일반클래스의 구성요소 + 추상메소드
public abstract class Camera {
	//멤버 필드
	private String name;
	private int resolution;
	
	//setter & getter 메소드
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name; 
	}
	
	public void setResolution(int resolution) {
		if(resolution < 0) return;
		this.resolution = resolution;
	}
	public long getResolution() {
		return this.resolution;
	}
	
	public String getResolutionStr() {
		int convert = resolution / 10000;
		return convert + "만";
	}
	
	//생성자
	public Camera(String name, int resolution) {
		this.setName(name);
		this.setResolution(resolution);
	}
	
	//출력정보
	public void show() {
		System.out.println("<카메라 정보>");
		System.out.println("모델명 : " + this.getName());
		System.out.println("해상도 : " + this.getResolutionStr() +"화소");
	}
	
	//추상 메소드
	public abstract void on();
	public abstract void off();
	public abstract void takePhoto();
	public abstract void zoom();
}
