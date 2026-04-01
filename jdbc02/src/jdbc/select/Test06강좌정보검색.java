package jdbc.select;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.mapper.LectureMapper;
import jdbc.util.JdbcUtils;

public class Test06강좌정보검색 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색 항목 : ");
		String column = sc.nextLine();
		System.out.print("검색 키워드 : ");
		String keyword = sc.nextLine();
		sc.close();
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from lecture where "+column+" like ?||'%' order by lecture_no asc";
	//	sql = "select * from lecture where instr("+column+" , ?) > 0 order by lecture_no asc";
		Object[] params = {keyword};
		LectureMapper lectureMapper = new LectureMapper();
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
		
		
		//출력
		System.out.println("실행구문 : " + sql);
		System.out.println("조회 결과 : " + list.size());
		if(keyword.isEmpty()) {
			System.out.println("검색결과가 존재하지 않습니다.");
		}
		else{
			System.out.println("검색결과 : " + list.size());
			for(LectureDto lectureDto : list) {
				System.out.println(lectureDto);
			}
		}
	}
}
