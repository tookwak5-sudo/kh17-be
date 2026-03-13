package oop.inherit3;

public class XTest01상속예제 {
	public static void main(String[] args) {
	//	Browser b = new Brower(); // 작성되면 안되는 코드
		
		ChromeBrowser b1 = new ChromeBrowser();
		b1.refresh(); //상속받은 기능(공통기능)
		b1.move(); //상속받은 기능(공통기능)
		b1.develop(); //고유기능
		b1.chromeStore();//고유기능
		System.out.println("------------------");
		
		EdgeBrowser b2 = new EdgeBrowser();
		b2.refresh(); //상속받은 기능(공통기능)
		b2.move(); //상속받은 기능(공통기능)
		b2.fullScreen();//고유기능
		System.out.println("------------------");
		
		WhaleBrowser b3 = new WhaleBrowser();
		b3.refresh(); //상속받은 기능(공통기능)
		b3.move(); //상속받은 기능(공통기능)
		b3.papago();//고유기능
		b3.naverSearch();//고유기능
		System.out.println("------------------");
		
	}
}
