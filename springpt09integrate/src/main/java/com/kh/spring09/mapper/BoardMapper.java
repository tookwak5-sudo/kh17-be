package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09.dto.BoardDto;

@Component
public class BoardMapper implements RowMapper<BoardDto>{

	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setBoardHead(rs.getString("board_head"));
		boardDto.setBoardTitle(rs.getString("board_title"));
		boardDto.setBoardContent(rs.getString("board_content"));
		boardDto.setBoardWriter(rs.getString("board_writer"));
		boardDto.setBoardWtime(rs.getTimestamp("board_wtime"));
		boardDto.setBoardEtime(rs.getTimestamp("board_etime"));
		boardDto.setBoardReadcount(rs.getInt("board_readcount"));
		boardDto.setBoardLikecount(rs.getInt("board_likecount"));
		boardDto.setBoardReplycount(rs.getInt("board_replycount"));
		return boardDto;
	}
}
