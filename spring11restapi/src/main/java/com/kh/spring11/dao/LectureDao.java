package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.LectureDto;
import com.kh.spring11.vo.LectureComplexRequestVO;

public interface LectureDao {
	int sequence(); //등록
	void insert(LectureDto lectureDto); //등록
	boolean update(LectureDto lectureDto); //수정
	boolean delete(int lecture_no); //삭제
	LectureDto selectOne(int lectureNo); //상세
	List<LectureDto> selectList(Integer lastLectureNo, int size); // 목록(더보기)
	int count(int lastLectureNo); //개수
//	List<LectureDto> searchByLectureTitle(String keyword);
	List<LectureDto> complexSearch(LectureComplexRequestVO vo);
	int complexSearchCount(LectureComplexRequestVO vo);
}
