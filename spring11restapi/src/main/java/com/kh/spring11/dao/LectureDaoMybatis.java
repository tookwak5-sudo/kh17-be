package com.kh.spring11.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.LectureDto;
import com.kh.spring11.vo.LectureComplexRequestVO;

@Repository
public class LectureDaoMybatis implements LectureDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int sequence() {
		return sqlSession.selectOne("mapper.lecture.sequence");
	}

	@Override
	public void insert(LectureDto lectureDto) {
		sqlSession.insert("mapper.lecture.add", lectureDto);
	}

	@Override
	public boolean update(LectureDto lectureDto) {
		return sqlSession.update("mapper.lecture.updateUnit", lectureDto) > 0;
	}

	@Override
	public boolean delete(int lectureNo) {
		return sqlSession.delete("mapper.lecture.delete", lectureNo) > 0;
	}

	@Override
	public LectureDto selectOne(int lectureNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("lectureNo", lectureNo); // 이건 이름을 줬기 때문에 mapper에서 #{lectureNo}라고 똑같이 써줘야함
		return sqlSession.selectOne("mapper.lecture.find", params);
	}
	
	@Override
	public List<LectureDto> selectList(Integer lastLectureNo, int size) {
		Map<String, Object> params = new HashMap<>();
		params.put("lastLectureNo", lastLectureNo);
		params.put("size", size);
		return sqlSession.selectList("mapper.lecture.listMore", params);
	}

	@Override
	public int count(int lastLectureNo) {
		return sqlSession.selectOne("mapper.lecture.count", lastLectureNo);
	}

	@Override
	public List<LectureDto> complexSearch(LectureComplexRequestVO vo) {
		return sqlSession.selectList("mapper.lecture.complexSearch", vo);
	}

	@Override
	public int complexSearchCount(LectureComplexRequestVO vo) {
		return sqlSession.selectOne("mapper.lecture.complexSearchCount", vo);
	}

}
