package oop.multi1;

//갤럭시S26의 메인 속성
// 필드 메소드 생성자 추상메소드 정의
public abstract class Phone {
	private String number; // 번호는 따로 수정할 필요가 없으므로 생성자 생성x

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public abstract void call();
	public abstract void sms();
	
}
