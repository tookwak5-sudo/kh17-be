package com.kh.spring09.stat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest //1 테스트파일임을 명시하여 jsp기능 //2. springcontainer에 있는 기능을 자동으로 가져다 사용가능하게 해준다
public class Test01대륙별국가개수조회 {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
//		String sql = "select country_region title, count(*) value "
//				+ "from country group by country_region order by country_region asc";
		String sql = "select book_genre title, count(*) value from book group by book_genre";
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		System.out.println("조회 결과 수  : " + list.size());
		for(Map<String, Object> data : list) {
			System.out.println(data);
			System.out.println(data.get("TITLE") + ", " + data.get("VALUE"));
		}
	}
}
