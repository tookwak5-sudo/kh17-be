package oop.modifier2;

public class Phone2 {
	//멤버변수
	private String name;
	private int memory;
	private String telecom;
	private int price;
	private int contract;
	
	// 세터 메소드
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setMemory(int memory) {
		switch(memory) {
		case 64, 128, 256, 512:
			this.memory = memory;
		}
	}
	public int getMemory() {
		return this.memory;
	}
	public void setTelecom(String telecom) {
		switch(telecom) {
		case "SKT", "KT", "LG", "알뜰폰":
			this.telecom = telecom;
		}
	}
	public String getTelecom() {
		return this.telecom;
	}
	public void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	public void setContract(int contract) {
		switch(contract) {
		case 0, 24, 36:
			this.contract = contract;
		}
	}
	public int getContract() {
		return this.contract;
	}
	//추가 : 약정기간이 있는지 (있으면 t, 없으면 f)
	//1. 논리 데이터를 반환하는 메소드는 get 대신 is로 시작(표준)
	//2. has, can로 시작하는 방법(과거)
	public boolean isContractExist() {
//		if(this.contract > 0) return true;
//		else return false;
		return this.contract > 0;  //약정기간이 0보다 큰지 판정해서 반환
	}
	
	// 추가 : 월 분납금
	public int getMonthlyPrice() {
		if(this.contract == 0) return 0;      // 약정기간이 없으면 월분납금 0
		return this.price / this.contract; 	// contract가 0이면 에러 발생
	}
	// 추가 : 할증 가격
//	public int getExtraPrice() {
//		return this.price * (100 + 10) /100;
//	}
	public int getExtraPrice(int rate) {
		return this.price * (100 + rate) /100;
	}
	public void init(String name, int memory, String telecom, int price, int contract) {
		this.setName(name);
		this.setMemory(memory);
		this.setTelecom(telecom);
		this.setPrice(price);
		this.setContract(contract);
			
	}
	
	void show() {
		System.out.println("<개통가능한 핸드폰 목록>");
		System.out.println("기종 : " + this.getName());
		System.out.println("메모리 : " + this.getMemory() + "GB");
		System.out.println("통신사 : " + this.getTelecom());
		if(this.isContractExist()) {//약정기간이 있으면
			System.out.println("판매가 : " + this.getPrice() + "원 (월 " + this.getMonthlyPrice() + "원)");
			System.out.println("약정기간 : " + this.getContract() + "개월");
		}
		else {
			System.out.println("판매가 : " + this.getExtraPrice(10) + "원 (약정기간 없을 경우 10% 인상됩니다.)");
		}
		
	}
}
