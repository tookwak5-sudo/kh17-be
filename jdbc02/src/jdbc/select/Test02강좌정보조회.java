package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.mapper.LectureMapper;
import jdbc.util.JdbcUtils;

public class Test02강좌정보조회 {
	public static void main(String[] args) {
		// 강좌 정보 조회
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from lecture order by lecture_no asc";
		
		LectureMapper lectureMapper = new LectureMapper();
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper);
		
		System.out.println("조회 결과 : " + list.size() + "개");
		for(LectureDto lectureDto : list) {
			System.out.println(lectureDto);
		}
	}
}
