package oop.inherit5;

public class Mp4MpFile extends MpFile{
	
	//추가 필드
	private float speed;

	public void setSpeed(float speed) {
		if(speed == 0.25f || speed == 0.5f || speed ==1f || speed == 1.25f || speed == 1.5f || speed == 2f) {
			this.speed = speed;
		}
	}
	public float getSpeed() {
		return speed;
	}
	
	
//	public Mp4MpFile() { // 재생 속도 미설정 시 1로 설정
//		this(1);
//	}
//	public Mp4MpFile(double speed) {
//		this.setSpeed(speed);
//	}
	public Mp4MpFile(String filename, long filesize) {
		super(filename, filesize);
		this.setSpeed(1f);
		//this(filename, filesize, 1f);
	}
	public Mp4MpFile(String filename, long filesize, float speed) {
		super(filename, filesize);
		this.setSpeed(speed);
	}
	
	//이 클래스 입장에서는 information 메소드가 맘에 안들음(내가 가진 정보 다 안나와요)
	// -> 재정의 해서 정보를 추가합니다.
	public void information() {
//		System.out.println("<파일 정보>");
//		System.out.println("이름 : "  + this.getFilename());
//		System.out.println("크기 : " + this.getFilesizeStr());
		super.information(); // 기존의 information을 부르고
		System.out.println("배속 : x" + this.getSpeed()); // 나는 한 줄만 추가하겠다.
	}
	
	
//	public void show() { // 이러면 상속을 하는 의미가 없기 때문에 information에서 정보를 상속하여 가져와 통일성을 만들기
//		System.out.println("재생 속도 : " + this.getSpeed());
//	}
	
}
