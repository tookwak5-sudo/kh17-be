package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.RoomDto;

public interface RoomDao {
	int sequence();
	void insert(RoomDto roomDto);
	boolean delete(int roomNo);
	RoomDto selectOne(int roomNo);
	List<RoomDto> selectList();
}
