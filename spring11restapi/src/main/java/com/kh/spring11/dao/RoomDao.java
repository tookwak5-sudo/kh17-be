package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.RoomDto;

public interface RoomDao {
	int sequence();
	void insert(RoomDto roomDto);
	boolean delete(int roomNo);
	RoomDto selectOne(int roomNo);
	List<RoomDto> selectList();
	
	void enter(int roomNo, String accountId);
	void leave(int roomNo, String accountId);
	List<String> getMembers(int roomNo);
}
