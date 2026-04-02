	package jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.mapper.LectureMapper;
import jdbc.util.JdbcUtils;

public class LectureDao {
	//삽입
	public void insert(LectureDto lectureDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create(); // 이 한 줄로 DB 도구 생성이 끝남
		String sql = "insert into lecture("
				+ "lecture_no, lecture_title, lecture_category,"
				+ " lecture_duration, lecture_price, lecture_type"
				+ ") "
				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] params = {
				lectureDto.getLectureTitle(),lectureDto.getLectureCategory(), lectureDto.getLectureDuration(), 
				lectureDto.getLecturePrice(), lectureDto.getLectureType()
		};
		jdbcTemplate.update(sql, params);
	}
	//수정
	public boolean update(LectureDto lectureDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "update lecture set "
				+ "lecture_title =?, "
				+ "lecture_category =?, "
				+ "lecture_duration =?, "
				+ "lecture_price =?, "
				+ "lecture_type =? "
				+ "where lecture_no =?";
		Object[] params = {
				lectureDto.getLectureTitle(), lectureDto.getLectureCategory(),
				lectureDto.getLectureDuration(), lectureDto.getLecturePrice(),
				lectureDto.getLectureType(), lectureDto.getLectureNo()
		};
		return jdbcTemplate.update(sql, params) > 0; 
//		int row = jdbcTemplate.update(sql, params);
//		return row > 0;
	}
	//삭제
	public boolean delete(int lecture_no) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete lecture where lecture_no = ?";
		Object[] params = { lecture_no };
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//조회
	public List<LectureDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from lecture order by lecture_no asc";
		//Object[] params = {}; //홀더 없음
		LectureMapper mapper = new LectureMapper();
		return jdbcTemplate.query(sql, mapper);
	}
	
	//검색
	public List<LectureDto> selectList(String column, String keyword){
		
		if(column == null || keyword == null) return selectList();//또는 return List.of()
		Set<String> allowList = Set.of("lecture_title", "lecture_category", "lecture_type");
		if(!allowList.contains(column)) return selectList(); //또는 return List.of()
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from lecture where instr("+ column +", ?) > 0 order by lecture_no asc";
		Object[] params = { keyword };
		LectureMapper lecturemapper = new LectureMapper();
		return jdbcTemplate.query(sql, lecturemapper, params);
	}
	
	//상세검색
	public LectureDto selectOne(int lectureNo) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from lecture where lecture_no =?";
		Object[] params = {lectureNo};
		LectureMapper lectureMapper = new LectureMapper();
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
}
