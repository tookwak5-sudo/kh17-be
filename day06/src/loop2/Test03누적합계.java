package loop2;

public class Test03누적합계 {
	public static void main(String[] args) {
		// (Q) 1부터 10까지 더하면 얼마?
		//int total = 1 + 2 + 3 + 4 + 5 + 6 + 7+ 8 + 9 + 10;
		//System.out.println("tota; + " + total)
		//**번외 : 기본값 int = 0; double = 0.0; String = null; boolean = false;
		int total = 0;
		for(int i =1; i <=10; i++) {
			total +=i;
		}
		System.out.println(total);
	}
}
