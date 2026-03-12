package oop.constructor1;

//상품
public class Item {
	private String name;
	private int price;
	private int stock;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		if(stock < 0) return;
		this.stock = stock;
	}

	//public void init(String name, int price, int stock) 
	//생성자(Constructor)
	// -객체 생성 시 반드시 설정할 정보를 받는 구문
	// - 메소드 처럼 생겼지만 메소드가 아님 
	// - 이름을 내 마음대로 지을 수 없고 클래스와 이름이 동일해야함
	// - 생성전용 구문
	// - 필요하다면 오버로딩이 가능
	public Item(String name, int price) {
		//this.init(name, price, 0);
		this(name, price, 0);
	}
	public Item(String name, int price, int stock) {
		this.setName(name);
		this.setPrice(price);
		this.setStock(stock);
	}

	
	public void show() {
		System.out.println("<아이템 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("가격 : " + this.getPrice() + "원");
		System.out.println("재고 : " + this.getStock() + "개");
	}
}
