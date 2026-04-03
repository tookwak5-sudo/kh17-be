package kh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kh.dto.MusicChartDto;
import kh.dto.MusicDto;

public class MusicChartMapper implements RowMapper<MusicChartDto> {

	@Override
	public MusicChartDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MusicChartDto musicChartDto = new MusicChartDto();
		musicChartDto.setMusicID(rs.getLong("music_id"));
		musicChartDto.setMusicTitle(rs.getString("music_title"));
		musicChartDto.setMusicArtist(rs.getString("music_artist"));
		musicChartDto.setMusicAlbum(rs.getString("music_album"));
		musicChartDto.setMusicRelease(rs.getString("music_release"));
		//musicChartDto.setMusicPlay(rs.getLong("music_play")); // long일 때 (not null일 때, null이 0으로 바뀜)
		musicChartDto.setMusicPlay(rs.getObject("music_play", Long.class)); // Long일 때 가능(null 가능)
		musicChartDto.setMusicLike(rs.getLong("music_like"));
		musicChartDto.setMusicdislike(rs.getLong("music_dislike"));
		musicChartDto.setMusicGenre(rs.getString("music_genre"));
		return musicChartDto;
	}

}
