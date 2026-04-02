package kh.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import kh.dto.MusicDto;
import kh.mapper.MusicMapper;
import kh.util.JdbcUtils;

public class MusicDao {
	//삽입
	public void insert(MusicDto musicDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "insert into music("
				+ "music_id, music_title, music_artist, "
				+ "music_album, music_release, "
				+ "music_play, music_like, "
				+ "music_dislike, "
				+ "music_genre) values(music_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(),
				musicDto.getMusicRelease(), musicDto.getMusicPlay(), musicDto.getMusicLike(),
				musicDto.getMusicdislike(), musicDto.getMusicGenre()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//조회
	public List<MusicDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from music order by music_id asc";
		MusicMapper musicMapper = new MusicMapper();
		return jdbcTemplate.query(sql, musicMapper);
	}
	
	//검색
	public List<MusicDto> selectList(String column, String keyword){
		//if(데이터가 부족하면)  return this.selectList(); // 목록반환
		if(column == null || keyword == null) return selectList();
		Set<String> allowList = Set.of("music_title,", "music_artist", "music_album", "music_rank_point");
		if(allowList.contains(column) == false) return List.of();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from music where instr("+ column +", ?) > 0 order by "+ column +" asc";
		if(column != null && keyword == null) {
			String rankSql = "select music_play * 2 + music_like * 5 - music_dislike * 10";
		}
		Object[] params = { keyword };
		MusicMapper musicMapper = new MusicMapper();
		return jdbcTemplate.query(sql, musicMapper, params);
	}
	
	
	//상세검색
	public MusicDto selectOne(int musicId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from music where music_id = ?";
		Object[] params = {musicId};
		MusicMapper musicMapper = new MusicMapper();
		List<MusicDto> list = jdbcTemplate.query(sql, musicMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//수정
	public boolean update(MusicDto musicDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "update music set music_title =?, "
				+ "music_artist =?, "
				+ "music_album =?, "
				+ "music_release =?, "
				+ "music_play =?, "
				+ "music_like =?, "
				+ "music_dislike =?, "
				+ "music_genre =? "
				+ "where music_id =?";
		Object[] params = {
				musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(),
				musicDto.getMusicRelease(), musicDto.getMusicPlay(), musicDto.getMusicLike(),
				musicDto.getMusicdislike(), musicDto.getMusicGenre(), musicDto.getMusicID()
		};
		return jdbcTemplate.update(sql, params) > 0;
		
	}
	
	//삭제
	public void delete(int musicId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete music where music_id =?";
		Object[] params = {musicId};
		jdbcTemplate.update(sql, params);
	}
}
