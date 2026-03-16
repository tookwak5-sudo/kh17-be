package oop.poly3_1;


public class Test01다형성을활용한풀이 {
	public static void main(String[] args) {
		//입력
		int type = 1;
		int action = 1;
		
//		.NoteBook noteBook = 갤럭시북 or 맥북;
		NoteBook noteBook = null;
		if(type == 1) {
			noteBook = new GalaxyBook();
		}
		else if(type == 2) {
			noteBook = new MacBook();
		}
//		else {
//			noteBook = null;
//		}
		
		if(action == 1) {
			noteBook.power();
		}
		else if(action == 2) {
			noteBook.video();
		}
		else if(action == 3) {
			noteBook.typing();
		}
		
		
	}
}
