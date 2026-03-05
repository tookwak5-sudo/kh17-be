package loop;

public class Test06타이머2 {
	public static void main(String[] args) {
		// 가장 작은 단위로 바꾸기 
		// 초로 환산한 반복문을 구현
		for(int i = 150; i >=0 ; i--) {
			int minute = i / 60;
			int second = i %60;
			System.out.println(minute + "분" + second + "초 후에 알람이 울립니다.");
		}
		
    }
}

