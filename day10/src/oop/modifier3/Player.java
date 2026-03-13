package oop.modifier3;

public class Player {
	private String id;
	private String type;
	private int level;
	private long cash;
	
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
		//if(level < 1) level = 1;  // 상황에 따라 설정
		this.level = level;
	}
	public long getCash() {
		return cash;
	}
	public void setCash(long cash) {
		if(cash < 0L) return;
		this.cash = cash;
	}
	
	// 추가
	public long getFullExp() { // 레벨당 필요 경험치
		return (long) this.level * this.level * this.level;
		//int끼리 계산하면 int가 나오니까 한개라도 long으로 바꿔서 계산
	}
	
	public String getTitle() {
		if(level < 10) return "초보자";
		else if(level < 50) return "중수";
		else return "고수";
	}
	
	//생성자
	//public Player() {} // 기본 생성자(default constructor) : 아무것도 안하는 생성자 (자동생성됨)
	
	public Player(String id, String type,long cash) {
		this(id, type, cash, 1);
	}
	public Player(String id, String type,long cash, int level) {
		this.setId(id);
		this.setType(type);
		this.setCash(cash);
		this.setLevel(level);
	}
	public void show() {
		System.out.println("<플레이어 정보>");
		System.out.println("아이디 : " + this.id); // get메소드가 아닌 것은 필드를 가져와도 무방
		System.out.println("직  업 : " + this.getType());
		System.out.println("레  벨 : " + this.getLevel() + "(요구Exp : " + this.getFullExp() + ")");
		System.out.println("칭호 : " + this.getTitle());
		System.out.println("소지금 : " + this.getCash() + "원");
		System.out.println("--------------------");
	}
}
