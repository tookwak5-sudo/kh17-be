package oop.modifier2;

public class Phone {
	//멤버변수
	private String model;
	private int memory;
	private String agency;
	private int price;
	private int period;
	
	// 세터 메소드
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return this.model;
	}
	
	public void setMemory(int memory) {
		switch(memory) {
		case 64,  128, 256, 512:
		this.memory = memory;
		}
	}
	public int getMemory() {
		return this.memory;
	}
	
	public void setAgenct(String agency) {
		switch(agency) {
		case "SKT", "KT", "LG", "알뜰폰":
		this.agency = agency;
		}
	}
	public String getAgency() {
		return this.agency;
	}
	
	public void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	
	public void setPeriod(int period) {
		switch(period) {
		case 0, 24, 36:
		this.period = period;
		}
	}
	public int getPeriod() {
		return this.period;
	}
	
//	public int getMonthPrice() {
//		String monthPrice = "월 분납금";
//		
//	}
	
	public float getExtraPrice() {
		float extraPrice = 0;
		float realPrice = 0;
		if(period < 0) {
			extraPrice = this.price * 10 / 100;
			realPrice = this.price + extraPrice;
		}
			return realPrice;
	}
	
	// 일반 메소드
	void init(String model, int memory, String agency, int price, int period) {
		this.setModel(model);
		this.setMemory(memory);
		this.setAgenct(agency);
		this.setPrice(price);
		this.setPeriod(period);
	}
	void init(String model, int memory, String agency, int price) {
		this.init(model, memory, agency, price, 0);
	}
	
	void show() {
		System.out.println("<개통가능한 핸드폰 목록>");
		System.out.println("기종 : " + this.getModel());
		System.out.println("메모리 : " + this.getMemory() + "GB");
		System.out.println("통신사 : " + this.getAgency());
		System.out.println("판매가 : " + this.getPrice() + "원");
		System.out.println("약정기간 : " + this.getPeriod() + "개월");
	}
}
