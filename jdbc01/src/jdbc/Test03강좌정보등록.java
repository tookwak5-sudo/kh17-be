package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03강좌정보등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 데이터 준비
		System.out.print("강좌명 : ");
		String lectureTitle = sc.nextLine();
		
		System.out.print("항목 : ");
		String lectureCategory = sc.nextLine();
		
		System.out.print("수강기간 : ");
		int lectureDuration = sc.nextInt();
		sc.nextLine();
		
		System.out.print("강좌가격 : ");
		int lecturePrice = sc.nextInt();
		sc.nextLine();
		
		System.out.print("유형 : ");
		String lectureType = sc.nextLine();
		
		//DB 등록 (처리)
		JdbcTemplate jdbcTemplate = JdbcUtils.create(); // 이 한 줄로 DB 도구 생성이 끝남
		
		String sql = "insert into lecture("
				+ "lecture_no, lecture_title, lecture_category,"
				+ " lecture_duration, lecture_price, lecture_type"
				+ ") "
				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] params = {
				lectureTitle, lectureCategory, lectureDuration, lecturePrice, lectureType
		};
		jdbcTemplate.update(sql, params);
		
		// 결과 알림 (출력)
		System.out.println("등록완료");
	}
}
