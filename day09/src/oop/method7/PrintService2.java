package oop.method7;

public class PrintService2 {
	//멤버 필드(변수)
	String partName;
	String partCategory;
	int makeDuration;
	int unitPrice;
	String deliveryType;
	
	//세타메소드
	void setPartName(String partName) {
		if(partName.length() > 20) return;
		this.partName = partName; // 필드에 데이터를 대입하는 코드
	}
	void setPartCategory(String partCategory) {
		switch(partCategory) {
		case "재품", "소모품", "부품", "출력":
		 this.partCategory = partCategory;
		}
	}
	void setMakeDuration(int makeDuration) {
		if(makeDuration < 0) return;
		if(makeDuration % 24 != 0) return;
		this.makeDuration = makeDuration;
	}
	void setUnitPrice(int unitPrice) {
		if(unitPrice < 0) return;
		if(unitPrice % 1000 !=0) return;
		this.unitPrice = unitPrice;
	}
	void setDeliveryType(String deliveryType) {
		switch(deliveryType) {
		case "일반", "퀵", "방문수령":
		this.deliveryType = deliveryType;
		}
	}
	//멤버메소드
	void init(String partName, String partCategory, int makeDuration, int unitPrice, String deliveryType) {
	//	this.partName = partName; //필드에 데이터를 대입하는 코드
		this.setPartName(partName); //메소드를 호출하면서 값을 전달하는 코드
		this.setPartCategory(partCategory);
		this.setMakeDuration(makeDuration);
		this.setUnitPrice(unitPrice);
		this.setDeliveryType(deliveryType);
	}
	void show() {
		System.out.println("<" + this.partName + ">");
		System.out.println("카테고리 :" + this.partCategory);
		System.out.println("제작시간 : " + this.makeDuration + "H");
		System.out.println("제작단가 : " + this.unitPrice + "원");
		System.out.println("배달유형" + this.deliveryType);
	}
}




















