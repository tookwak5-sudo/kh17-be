package oop.inner1;

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
}
