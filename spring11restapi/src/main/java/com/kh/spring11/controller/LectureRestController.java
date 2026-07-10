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

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.dao.LectureDao;
import com.kh.spring11.dto.LectureDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.LectureInsertVO;
import com.kh.spring11.vo.LectureUpdateAllVO;
import com.kh.spring11.vo.LectureUpdateUnitVO;
import com.kh.spring11.vo.ListRequestVO;
import com.kh.spring11.vo.ListVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//문서에 표시되기 위한 정보들도 Annotation 형태로 설정한다 (혼동되지 않도록 주의)
@Tag(name = "강좌API", description = "강좌 CRUD를 위한 API 입니다")


@CrossOrigin
@RestController
@RequestMapping("/api/lecture")
@CommonsApiResponse  //커스텀 annotation
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
	
	@Operation(
			//deprecated = true,
			summary = "강좌 목록 조회",
			description = "강좌를 최근 등록된 순서대로 조회하여 출력합니다",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "전체 조회 성공",
					content = @Content(
						mediaType = "application/json",
						array = @ArraySchema(
							schema = @Schema(implementation = LectureDto.class)
						)
					)
				)
			} 
	)
	
	//조회
	@GetMapping("/")
	public List<LectureDto> list(){
		return lectureDao.selectList(null, 10);
	}
	
	//리액트를 위한 더보기 방식의 조회
	// - 조회는 GetMapping으로 구현 (정보가 너무 많으면 Post로도 가능)
	// - 정보가 많다의 기준은 2개
	@GetMapping("/lastLectureNo/{lastLectureNo}/size/{size}")
	public ListVO listForReact(
			@PathVariable int lastLectureNo, //PathVariable은 기본값을 줄 수 없음
			@PathVariable int size
	) {
		List list = lectureDao.selectList(lastLectureNo, size);
		int count = lectureDao.count(lastLectureNo);
		return ListVO.builder()
						.list(list)
						.last(count <= size) //보기로 한 개수보다 데이터가 같거나 적으면 마지막
					.build();
	}
	
	@PostMapping("/list-more")
	public ListVO listMore(@RequestBody ListRequestVO vo) {
		List list = lectureDao.selectList(vo.getLastNo(), vo.getSize());
		int count =lectureDao.count(vo.getLastNo());
		return ListVO.builder()
				.list(list)
				.last(count <= vo.getSize()) //보기로 한 개수보다 데이터가 같거나 적으면 마지막
			.build();
	}
	
	@Operation(
		//deprecated = true, //안쓰길 원할때 (배경 회색처리) 
		summary = "강좌 상세 조회",
		description = "특정 강좌에 대한 모든 정보를 조회합니다",
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "대상 조회 성공",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = LectureDto.class)
				)
			)
		}
	)	
	
	//상세조회
	@GetMapping("/{lectureNo}")
	public LectureDto find(
			@Parameter(description = "조회할 강좌 번호", example = "1")
			@PathVariable int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		return lectureDto;
	}
	
	@Operation(
		//deprecated : true,
		summary = "강좌 삭제",
		description = "대상 강좌에 대한 모든 정보를 데이터베이스에서 삭제합니다",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "삭제 성공",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = LectureDto.class)
				)
			)
		}
	)
	
	//삭제
	@DeleteMapping("/{lectureNo}")
	public LectureDto delete(
				@Parameter(description = "삭제할 강좌 번호", example = "1")
				@PathVariable int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		lectureDao.delete(lectureNo);
		return lectureDto;
	}
	
	@Operation(
		//deprecated : true,
		summary = "강좌 정보 전체 수정",
		description = "요청한 강좌번호에 대해 번호를 제외한 모든 정보를 수정합니다",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "강좌 정보 수정 성공",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = LectureDto.class)
				)
			)
		}
	)
	
	//전체수정
	@PutMapping("/{lectureNo}")
	public LectureDto updateAll(
			@RequestBody LectureUpdateAllVO lectureUpdateAllVO, 
			@Parameter(description = "수정할 강좌 고유 번호", example="1")
			@PathVariable int lectureNo
	) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		
		lectureDto.setLectureCategory(lectureUpdateAllVO.getLectureCategory());
		lectureDto.setLectureTitle(lectureUpdateAllVO.getLectureTitle());
		lectureDto.setLectureDuration(lectureUpdateAllVO.getLectureDuration());
		lectureDto.setLecturePrice(lectureUpdateAllVO.getLecturePrice());
		lectureDto.setLectureType(lectureUpdateAllVO.getLectureType());	
		
		lectureDao.update(lectureDto);
		
		return lectureDto;
	}
	
	@Operation(
		//deprecated : true,
		summary = "강좌 정보 부분 수정",
		description = "대상 강좌의 정보 중 원하는 일부 정보를 변경합니다",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "강좌 정보 변경 성공",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = LectureDto.class)
				)
			)
		}
	)
	
	//부분 수정
	@PatchMapping("/{lectureNo}")
	public LectureDto updateUnit(
			@RequestBody LectureUpdateUnitVO lectureUpdateUnitVO, 
			@Parameter(description = "수정할 강좌 고유 번호", example="1")
			@PathVariable int lectureNo
		) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		
		if(lectureUpdateUnitVO.getLectureTitle() != null) {
			lectureDto.setLectureTitle(lectureUpdateUnitVO.getLectureTitle());
		}
		if(lectureUpdateUnitVO.getLectureCategory() != null) {
			lectureDto.setLectureCategory(lectureUpdateUnitVO.getLectureCategory());
		}
		if(lectureUpdateUnitVO.getLectureDuration() != null) {
			lectureDto.setLectureDuration(lectureUpdateUnitVO.getLectureDuration());
		}
		if(lectureUpdateUnitVO.getLectureType() != null) {
			lectureDto.setLectureType(lectureUpdateUnitVO.getLectureType());
		}
		if(lectureUpdateUnitVO.getLecturePrice() != null) {
			lectureDto.setLecturePrice(lectureUpdateUnitVO.getLecturePrice());
		}
		
		lectureDao.update(lectureDto);		
		return lectureDto;
	}
}
