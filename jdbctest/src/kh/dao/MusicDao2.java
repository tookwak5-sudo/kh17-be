package kh.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import kh.dto.MusicChartDto;
import kh.dto.MusicDto;
import kh.mapper.MusicChartMapper;
import kh.mapper.MusicMapper;
import kh.util.JdbcUtils;

public class MusicDao2 {
	//자주 쓰는 도구들을 필드로 미리 정의
	private JdbcTemplate jdbcTemplate = JdbcUtils.create();
	private MusicMapper musicMapper = new MusicMapper();
	private MusicChartMapper musicChartMapper = new MusicChartMapper();
	private Set<String> allowColumns = Set.of(
				"music_title", "music_artist", "music_album", "music_genre"
			);
	
	//삽입 play like dilike를 입력하게 하는게 맞을까? ㄴㄴ default 0으로 해서 입력자체를 없애기
	public void insert(MusicDto musicDto) {
		String sql = "insert into music("
				+ "music_id, music_title, music_artist, "
				+ "music_album, music_release, "
				+ "music_genre"
				+ ") values(music_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] params = {
				musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(),
				musicDto.getMusicRelease(), musicDto.getMusicGenre()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//수정 마찬가지로 3개 지우기
	public boolean update(MusicDto musicDto) {
		String sql = "update music set music_title =?, "
				+ "music_artist =?, "
				+ "music_album =?, "
				+ "music_release =?, "
				+ "music_genre =? "
				+ "where music_id =?";
		Object[] params = {
				musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(),
				musicDto.getMusicRelease(), musicDto.getMusicGenre(), musicDto.getMusicID()
		};
		return jdbcTemplate.update(sql, params) > 0;
		
	}
	//(번외)재생수
	public boolean updateMusicPlay(long musicId) {
		String sql = "update music set music_play = music_play + 1 where music_id = ?";
		Object[] params = {musicId};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//삭제
	public boolean delete(long musicId) {
		String sql = "delete music where music_id =?";
		Object[] params = {musicId};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//목록 및 검색
		public List<MusicDto> selectList(){
			String sql = "select * from music order by music_id asc";
			return jdbcTemplate.query(sql, musicMapper);
		}
		public List<MusicDto> selectList(String column, String keyword) {
			if(column == null || keyword == null) return selectList();
			//if(column.strip().isEmpty() || keyword.strip().isEmpty()) return selectList();
			if(column.isBlank() || keyword.isBlank()) return selectList();
			
			if(!allowColumns.contains(column)) return List.of();
			
			String sql = "select * from music "
								+ "where instr("+column+", ?) > 0 "
								+ "order by "+column+" asc, music_id asc";
			Object[] params = { keyword };
			return jdbcTemplate.query(sql, musicMapper, params);
		}
	
	public List<MusicChartDto> selectListRank(){
		String sql = "select * from music_chart";
		return jdbcTemplate.query(sql, musicChartMapper);
	}
	public List<MusicChartDto> selectListRank(String column, String keyword) {
		if(column == null || keyword == null) return selectListRank();
		//if(column.strip().isEmpty() || keyword.strip().isEmpty()) return selectList();
		if(column.isBlank() || keyword.isBlank()) return selectListRank();
		
		if(!allowColumns.contains(column)) return List.of();
		
		String sql = "select * from music_chart "
						+ "where instr("+column+", ?) > 0 "
						+ "order by music_point desc, music_id asc";
		Object[] params = { keyword };
		return jdbcTemplate.query(sql, musicChartMapper, params);
	}
	
	//상세검색
	public MusicDto selectOne(long musicId) { // 기본키가 들어옴
		String sql = "select * from music where music_id = ?";
		Object[] params = {musicId};
		List<MusicDto> list = jdbcTemplate.query(sql, musicMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	

}
