package jdbc2;

import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;
import jdbc.JdbcUtils;

public class Test02강좌정보수정 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정번호:  ");
		int lectureNo = sc.nextInt();
		sc.nextLine();
		
		System.out.println("강좌명:  ");
		String lectureTitle = sc.nextLine();;
		
		System.out.println("이론 실시 시험 choice :  ");
		String lectureCategory = sc.nextLine();;
		
		System.out.println("수강필요시간:  ");
		int lectureDuration = sc.nextInt();
		
		System.out.println("강좌가격:  ");
		long lecturePrice = sc.nextLong();
			
		System.out.println("온라인 오프라인 혼합:  ");
		String lectureType = sc.nextLine();;
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		// 모든 형태가 이 구문을 실행하기 위해서
		String sql = "update lecture "
				+ "set lecture_title =?, "
					+ "lecture_category =?, "
					+ "lecture_duration =?,"
					+ "lecture_price =?, "
					+ "lecture_type =? "
				+ "where lecture_no = ?";
		Object[] params = {
				lectureTitle, lectureCategory, lectureDuration,
				lecturePrice, lectureType, lectureNo
		};
			
		int rows = jdbcTemplate.update(sql, params);
		
		//출력
		if(rows > 0) { // 한 개 이상의 정보가 고쳐졌다는 뜻이기 때문에
			System.out.println("강의 정보가 변경되었습니다.");
		}
		else {
			System.out.println("해당 번호의 강의는 없습니다.");
		}
	}
}
