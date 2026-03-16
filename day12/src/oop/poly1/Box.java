package oop.poly1;

//치킨 포장 상자
public class Box {
	//다음과 같이 만들면 모든 치킨을 보관할 수 없다
	// private Spicychicken chicken;
	//private FriedChicken chicken2;
	
	//상위 형태를 필드로 만들면 상속받은 모든 형태를 보관할 수 있다.
	private Chicken chicken;

	public Chicken getChicken() {
		return chicken;
	}

	public void setChicken(Chicken chicken) {
		this.chicken = chicken;
	}
	
	
}
