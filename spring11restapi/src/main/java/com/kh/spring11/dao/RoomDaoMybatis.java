package com.kh.spring11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.RoomDto;

@Repository
public class RoomDaoMybatis implements RoomDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int sequence() {
		return sqlSession.selectOne("mapper.room.sequence");
	}

	@Override
	public void insert(RoomDto roomDto) {
		sqlSession.insert("mapper.room.create", roomDto);
	}

	@Override
	public boolean delete(int roomNo) {
		return sqlSession.delete("mapper.room.delete", roomNo) > 0;
	}

	@Override
	public RoomDto selectOne(int roomNo) {
		return sqlSession.selectOne("mapper.room.find", roomNo);
	}

	@Override
	public List<RoomDto> selectList() {
		return sqlSession.selectList("mapper.room.list");
	}

}
