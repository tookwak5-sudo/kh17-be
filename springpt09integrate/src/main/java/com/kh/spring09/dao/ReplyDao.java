package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.ReplyDto;
import com.kh.spring09.mapper.ReplyMapper;

	@Repository
	public class ReplyDao {
		@Autowired
		private JdbcTemplate jdbcTemplate;
		@Autowired
		private ReplyMapper replyMapper;
		
		//댓글 등록 - 2개(시퀀스 생성 및 등록)
		public long sequence() {
			String sql = "select reply_seq.nextval from dual";
			return jdbcTemplate.queryForObject(sql, long.class);
		}
		
		public void insert(ReplyDto replyDto) {
			String sql = "insert into reply("
					+ "reply_no, reply_writer, reply_origin, reply_content"
					+ ") "
					+ "values(?, ?, ?, ?)";
			Object[] params = {replyDto.getReplyNo(), replyDto.getReplyWriter(), replyDto.getReplyOrigin(), replyDto.getReplyContent()};
			jdbcTemplate.update(sql, params);
		}
		
		//목록 - 전체 목록이 없고 replyOrigin별 목록이 존재
		public List<ReplyDto> selectList(long beginRownum, long endRownum){
			String sql = "select * from("
					+ "select rownum rn, TMP.* from("
						+ "select * from reply order by reply_no asc"
						+ ") TMP"
						+ ") where rn between ? and ?";
			Object[] params = { beginRownum, endRownum};
			return jdbcTemplate.query(sql, replyMapper, params);
		}
		
		
	}
