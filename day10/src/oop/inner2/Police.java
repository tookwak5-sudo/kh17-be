package oop.inner2;

public class Police {
	//필드
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	private Gun gun;
	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public Gun getGun() {
		return gun;
	}
	
	public Police() {
		// 내 소유의 클래스이므로 내가 생성해서 설정해야 한다(외부에선 불가능)
		Gun g = new Gun();
		this.setGun(g);
	}
	
	//중첩클래스
	// - 현재 클래스에 소속된 하위 클래스를 생성
	private class Gun{}
}
