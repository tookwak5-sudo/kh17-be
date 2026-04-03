package kh.program;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import kh.dao.MusicDao;
import kh.dao.MusicDao2;
import kh.dto.MusicDto;
import kh.mapper.MusicMapper;
import kh.util.JdbcUtils;

public class Exam02음원목록 {
	public static void main(String[] args) {
		//입력
		String column = "music_title";
		String keyword = "사건";
		//처리: 전체 곡 목록 조회
		MusicDao2 musicDao2 = new MusicDao2();
		List<MusicDto> list = musicDao2.selectList(column, keyword);
		//출력
			System.out.println("음원 수 : " + list.size());
			for(MusicDto musicDto : list) {
				System.out.println(musicDto);
			}
	}
}
