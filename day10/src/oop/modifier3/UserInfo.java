package oop.modifier3;

public class UserInfo {
	private String id;
	private String type;
	private int level;
	private int cash;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		switch(type) {
		case "전사", "마법사", "궁수":
			this.type = type;
		}
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level < 1) return;
		this.level = level;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		if(cash < 0) return;
		this.cash = cash;
	}
	
	// 추가
	public long getFullExp() { // 레벨당 필요 경험치
		return this.level * this.level * this.level;
	}
	
	
	public UserInfo(String id, String type,int cash,int level) {
		this.setId(id);
		this.setType(type);
		this.setCash(cash);
		this.setLevel(level);
	}
	public UserInfo(String id, String type,int cash) {
		this(id, type, cash, 1);
	}
	
	public void show() {
		System.out.println("아이디 : " + this.getId());
		System.out.println("직업 : " + this.getType());
		System.out.println("레벨 : " + this.getLevel() + "(요구Exp : " + this.getFullExp() + ")");
		
		if(this.level < 10) {
			System.out.println("칭호 : 초보자");
		}
		else if(this.level < 50) {
			System.out.println("칭호 : 중수");
		}
		else {
			System.out.println("칭호 : 고수");
		}
		System.out.println("소지금 : " + this.getCash() + "원");
		System.out.println("--------------------");
	}
	
}
