package oop.poly1;

public class Test01다형성의활용 {
	public static void main(String[] args) {
		//목표: Box를 만들어서 후라이드 치킨 or 양념 치킨을 보관시키는 것
		
		Box box = new Box();
		
		Chicken chicken = new FriedChicken(); //private Chicken chicken에 상위형태로 (업캐스팅)되어 보관됨
		
		box.setChicken(chicken); // Friedchicken이 Chicken으로 업캐스팅되어 보관된다.
		
		//상자에 양념치킨 보관
		Chicken chicken2 = new SpicyChicken();
		box.setChicken(chicken2); // SpicyChicken이 Chicken으로 업캐스팅되어 보관된다.
		
	}
}
