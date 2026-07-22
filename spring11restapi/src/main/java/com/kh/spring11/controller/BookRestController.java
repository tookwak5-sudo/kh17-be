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
import com.kh.spring11.dao.BookDaoSpringJDBC;
import com.kh.spring11.dto.BookDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.BookInsertVO;
import com.kh.spring11.vo.BookUpdateAllVO;
import com.kh.spring11.vo.BookUpdateUnitVO;
import com.kh.spring11.vo.ListRequestVO;
import com.kh.spring11.vo.ListVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "도서 처리 시스템", description = "도서 정보에 대해 DB처리를 수행하는 컨트롤러 입니다")
@CommonsApiResponse

//@CrossOrigin // CORS 교차출처 허용(지금은 전체지만, 향후 특정대상만 허용하는 옵션 추가 필요)
@RestController // @Controller는 화면(View)을 반환하는 컨트롤러 //@RestController는 데이터(JSON, XML 등)를 반환하는 컨트롤러							
@RequestMapping("/api/book")
public class BookRestController {
	@Autowired
	private BookDaoSpringJDBC bookDao;
	
	//CRUD 처리 매핑(통상적인 방법론)
	//1. 기본적으로 자원관련된 CRUD는 주소를 최소화하고 전송방식으로 구분
	//2. 쿼리스트림은 선택적 데이터에 사용 (옵션)
	//3. 경로변수는 반드시 필요한 데이터에 사용 (필수)
	//4. 전송 데이터가 많으면 조회라도 POST 등을 사용할 수 있다
	
	@Operation(
			summary = "신규 도서 등록",
			description = "새로운 도서를 등록하고자 하는 Ajax 요청에 대응합니다",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "등록 성공",
					content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = BookDto.class)
					)
				)
			}
	)
	
	//등록
	@PostMapping("/")
	public BookDto insert(@RequestBody BookInsertVO bookInsertVO) {
		int bookId = bookDao.sequence();
		BookDto bookDto = new BookDto();
		bookDto.setBookId(bookId);
		bookDto.setBookTitle(bookInsertVO.getBookTitle());
		bookDto.setBookAuthor(bookInsertVO.getBookAuthor());
		bookDto.setBookGenre(bookInsertVO.getBookGenre());
		bookDto.setBookPrice(bookInsertVO.getBookPrice());
		bookDto.setBookPublicationDate(bookInsertVO.getBookPublicationDate());
		bookDto.setBookPageCount(bookInsertVO.getBookPageCount());
		bookDto.setBookPublisher(bookInsertVO.getBookPublisher());
		bookDao.insert(bookDto);
		return bookDto;
	}
	
	@Operation(
			summary = "도서 목록 조회",
			description = "도서를 최근 등록된 순서대로 조회하여 출력합니다",
			responses = {
				@ApiResponse(
						responseCode = "200",
						description = "전체 조회 성공",
						content = @Content(
							mediaType = "application/json",
							array = @ArraySchema(
								schema = @Schema(implementation = BookDto.class)
							)	
						)
				)
			}
	)
	
	//조회
	@GetMapping("/")
	public List<BookDto> list(){
		return bookDao.selectList(1, Integer.MAX_VALUE);
	}
	
	//리액트를 위한 더보기 방식의 조회
	// - 조회는 GetMapping으로 구현 (정보가 너무 많으면 Post로도 가능)
	// - 정보가 많다의 기준은 2개
	// - 주소를 분리가능하지만 분리할 경우 "/" 경로가 겹치는 문제가 발생
	@GetMapping("/lastBookId/{lastbookId}/size/{size}")
	public ListVO listForReact1(
			@PathVariable int lastBookId, //PathVariable은 기본값을 줄 수 없음
			@PathVariable int size
	) {
		List list = bookDao.selectList(lastBookId, size);
		int count = bookDao.count(lastBookId);
		return ListVO.builder()
						.list(list)
						.last(count <= size) //보기로 한 개수보다 데이터가 같거나 적으면 마지막
					.build();
	}
	
	//전체 조회
	@PostMapping("/list-more")
	public ListVO listForReact2(@RequestBody ListRequestVO vo) {
			List list = bookDao.selectList(vo.getLastNo(), vo.getSize());
			int count = bookDao.count(vo.getLastNo());
			return ListVO.builder()
					.list(list)
					.last(count <= vo.getSize())
				.build();
	}
	
	@Operation(
		summary = "도서 상세 조회",
		description = "특정 도서에 대한 모든 정보를 조회합니다",
		responses = {
				@ApiResponse(
						responseCode = "200",
						description = "대상 조회 성공",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = BookDto.class)
						)
				)
		}
	)
	
	//상세 조회
	@GetMapping("/{bookId}")
	public BookDto find(
			@Parameter(description = "삭제할 도서 번호", example = "1")
			@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException();
		return bookDto;
	}
	
	@Operation(
		summary = "도서 삭제",
		description = "대상 도서에 대한 모든 정보를 삭제합니다",
		responses = {
				@ApiResponse(
						responseCode = "200",
						description = "대상 삭제 성공",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = BookDto.class)
						)
				)
		}
	)
	
	//삭제
	@DeleteMapping("/{bookId}")
	public BookDto delete(
			@Parameter(description = "삭제할 도서 번호", example="1")
			@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException();
		bookDao.delete(bookId);
		return bookDto;
	}
	
	@Operation(
//			deprecated : true,
			summary = "도서 정보 전체 수정",
			description = "대상 도서의 모든 정보를 변경합니다",
			responses = {
					@ApiResponse(
						responseCode = "200",
						description = "도서 정보 변경 성공",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = BookDto.class)
						)
					)
			}
	)
	
	
	//전체 수정
	@PutMapping("/{bookId}")
	public BookDto updateAll(
			@RequestBody BookUpdateAllVO bookUpdateAllVO,
			@Parameter(description = "수정할 도서 고유 번호", example="1")
			@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException();
		
		bookDto.setBookTitle(bookUpdateAllVO.getBookTitle());
		bookDto.setBookAuthor(bookUpdateAllVO.getBookAuthor());
		bookDto.setBookGenre(bookUpdateAllVO.getBookGenre());
		bookDto.setBookPrice(bookUpdateAllVO.getBookPrice());
		bookDto.setBookPublisher(bookUpdateAllVO.getBookPublisher());
		bookDto.setBookPageCount(bookUpdateAllVO.getBookPageCount());
		bookDto.setBookPublisher(bookUpdateAllVO.getBookPublisher());
		
		bookDao.update(bookDto);
		
		return bookDto;
	}
	
	@Operation(
		//deprecated : true,
		summary = "도서 정보 부분 수정",
		description = "대상 도서의 정보 중 원하는 일부 정보를 변경합니다",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "도서 정보 변경 성공",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = BookDto.class)
				)
			)
		}
	)
	
	//부분 수정
	@PatchMapping("/{bookId}")
	public BookDto updateUnit(
			@RequestBody BookUpdateUnitVO bookUpdateUnitVO,
			@Parameter(description = "수정할 도서 고유 번호", example="1")
			@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotfoundException();
		
		if(bookUpdateUnitVO.getBookTitle() != null) {
			bookDto.setBookTitle(bookUpdateUnitVO.getBookTitle());
		}
		if(bookUpdateUnitVO.getBookAuthor() != null) {
			bookDto.setBookAuthor(bookUpdateUnitVO.getBookAuthor());
		}
		if(bookUpdateUnitVO.getBookGenre() != null) {
			bookDto.setBookGenre(bookUpdateUnitVO.getBookGenre());
		}
		if(bookUpdateUnitVO.getBookPrice() != null) {
			bookDto.setBookPrice(bookUpdateUnitVO.getBookPrice());
		}
		if(bookUpdateUnitVO.getBookPublisher() != null) {
			bookDto.setBookPublisher(bookUpdateUnitVO.getBookPublisher());
		}
		if(bookUpdateUnitVO.getBookPageCount() != null) {
			bookDto.setBookPageCount(bookUpdateUnitVO.getBookPageCount());
		}
		if(bookUpdateUnitVO.getBookPublisher() != null) {
			bookDto.setBookPublisher(bookUpdateUnitVO.getBookPublisher());
		}
		
		bookDao.update(bookDto);
		
		return bookDto;
	}
}
