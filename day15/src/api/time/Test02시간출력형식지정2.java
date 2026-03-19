package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Test02시간출력형식지정2 {
	public static void main(String[] args) {

		
	
//		Format f = new SimpleDateFormat("y년 M월 d일 E요일 a h시 m분 s초"); // 언어가 바뀌면 쓸 수없기 때문에 권장하지 않는 방식
//		
//		while(true) {
//			//현재 시점의 Date 객체를 매번 새로 생성하기!!!
//			Date current = new Date();
//			
//			String timeString = f.format(current);
//			// /r을 사용해 커서를 줄 맨 앞으로 보낸 뒤 출력(한 줄 갱신)
//			System.out.print("\r현재 시간: " + timeString) ;
//			
//			try {
//				Thread.sleep(1000);
//			}catch(Exception e) {
//				break;
//			}
//		}
		Format sdf = new SimpleDateFormat("y년 M월 d일 E요일 a h시 m분 s초");
		
		while(true) {
			Date current = new Date();
			
			String timeString = sdf.format(current);
			System.out.print("\r 현재 시간:" + timeString);
			
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				break;
			}
		}
		
		
	}
}
