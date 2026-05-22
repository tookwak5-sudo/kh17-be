package com.kh.spring09.stat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring09.dao.StatDao;
import com.kh.spring09.vo.StatVO;

@SpringBootTest
//역할
//1. 테스트파일임을 명시, jsp기능
//2. SpringContainer에 있는 기능을 사용가능하게 해준다
public class Test04장르별도서개수조회 {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	@Autowired
//	private StatMapper statMapper;
	
	@Autowired
	private StatDao statDao;
	
	@Test
	public void test() {
//		String sql = "select book_genre title, count(*) value "
//					+ "from book group by book_genre "
//					+ "order by book_genre asc";
//		
		//Map과 queryForList를 통해서 Mapper의 역할을 대신
//		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//		System.out.println("조회 결과 수 : " + list);
//		for(Map<String, Object> data : list) {
////			System.out.println(data);
//			System.out.println(data.get("title") + ", " + data.get("value"));
//		}
		
//		List<StatVO> list = jdbcTemplate.query(sql, statMapper);
//		System.out.println("조회 결과 수 : " + list.size());
//		for(StatVO statVO : list) {
//			System.out.println(statVO.getTitle() + ", " + statVO.getValue());
//		}
		
		List<StatVO> list = statDao.bookByGenre();
		for(StatVO statVO : list) {
			System.out.println(statVO);
		}
	}
}
