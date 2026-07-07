package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.dao.LectureDao;
import com.kh.spring11.dto.LectureDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.LectureInsertVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//문서에 표시되기 위한 정보들도 Annotation 형태로 설정한다 (혼동되지 않도록 주의)
@Tag(name = "강좌API", description = "강좌 CRUD를 위한 API 입니다")


@CrossOrigin
@RestController
@RequestMapping("/api/lecture")
public class LectureRestController {
	@Autowired
	private LectureDao lectureDao;
	
	//어떤 작업인지에 설명한다
	@Operation(
			//deprecated = true, //안쓰길 원할때 (배경 회색처리) 
			summary = "신규 강좌 생성",
			description = "새로운 강좌를 생성하고자 하는 Ajax 요청에 대응합니다",
			responses = {
				@ApiResponse(
					responseCode = "200", 
					description = "등록 성공",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = LectureDto.class)
					)
				),
				@ApiResponse(
					responseCode = "500",
					description = "서버 내부 오류",
					content = @Content(
						mediaType = "text/plain",  //그냥 택스트 : text/plain  그냥 html : text/html
						schema = @Schema(
							implementation = String.class,
							example = "Server error"
						)
					)
				)
			}
			
	)
	
	
	@PostMapping("/")
	public LectureDto insert(@RequestBody LectureInsertVO lectureInsertVO) {
		int lectureNo = lectureDao.sequence();
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(lectureNo);
		lectureDto.setLectureCategory(lectureInsertVO.getLectureCategory());
		lectureDto.setLectureTitle(lectureInsertVO.getLectureTitle());
		lectureDto.setLectureDuration(lectureInsertVO.getLectureDuration());
		lectureDto.setLecturePrice(lectureInsertVO.getLecturePrice());
		lectureDto.setLectureType(lectureInsertVO.getLectureType());		
		lectureDao.insert(lectureDto);
		return lectureDto;
	}
	
	//전체조회
	@GetMapping("/")
	public List<LectureDto> list() {
		return lectureDao.selectList(1, Integer.MAX_VALUE);
	}
	
	//상세조회
	@GetMapping("/{lectureNo}")
	public LectureDto find(@PathVariable int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		return lectureDto;
	}
	
	//삭제
	@DeleteMapping("/{lectureNo}")
	public LectureDto delete(@PathVariable int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		lectureDao.delete(lectureNo);
		return lectureDto;
	}
	
	//전체수정
	@PutMapping("/{lectureNo}")
	public LectureDto updateAll(@RequestBody LectureDto lectureDto, 
								@PathVariable int lectureNo) {
		LectureDto findLectureDto = lectureDao.selectOne(lectureNo);
		if(findLectureDto == null) throw new TargetNotfoundException();
		
		lectureDto.setLectureNo(lectureNo);
		lectureDao.update(lectureDto);
		
		return lectureDto;
	}
	
	//부분 수정
	@PatchMapping("/{lectureNo}")
	public LectureDto updateUnit(@RequestBody LectureDto lectureDto, 
								@PathVariable int lectureNo) {
		LectureDto findLectureDto = lectureDao.selectOne(lectureNo);
		if(findLectureDto == null) throw new TargetNotfoundException();
		
		if(lectureDto.getLectureTitle() != null) {
			findLectureDto.setLectureTitle(lectureDto.getLectureTitle());
		}
		if(lectureDto.getLectureCategory() != null) {
			findLectureDto.setLectureCategory(lectureDto.getLectureCategory());
		}
		if(lectureDto.getLectureDuration() > 0 && lectureDto.getLectureDuration() % 30 == 0) {
			findLectureDto.setLectureDuration(lectureDto.getLectureDuration());
		}
		if(lectureDto.getLectureType() != null) {
			findLectureDto.setLectureType(lectureDto.getLectureType());
		}
		if(lectureDto.getLecturePrice() >= 0) {
			findLectureDto.setLecturePrice(lectureDto.getLecturePrice());
		}
		return findLectureDto;
	}
}
