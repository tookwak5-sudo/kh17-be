package com.kh.spring09.vo;

import java.util.Optional;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

//VO(Value Object) :
//- 테이블과 무관하게 필요에 의해서 데이터를 묶어두기 위한 클래스
//- 자바에서 배웠던 클래스와 가장 유사한 형태

@Data
public class PageVo2 {
	private String column; // 파라미터에 있는 검색항목
	private String keyword; // 파라미터에 있는 검색키워드
	private int page = 1; // 파라미터에 있는 페이지번호(없으면 1페이지)
	private int size = 10; // 파라미터에 있는 페이지규격(없으면 10개)
	private int count; //총 데이터 개수 (DB에서 조회해서 채워줘야함)
	private String beginDate;
	private String endDate; 
	
	//목록인지 검색인지 판정하는 메소드
	//- 목록 : 컬럼과 키워드 중 하나라도 없는 경우
	//- 검색 : 컬럼과 키워드 모두 있는 경우
	public boolean isList() {
		return column == null || keyword == null;
	}
	public boolean isSearch() {
//		return column != null && keyword != null;
		return !isList();
	}
	
	//날짜가 빈 경우
	public boolean isNoDate() {
		return beginDate == null || endDate == null;
	}
	public boolean isDate() {
		return !isNoDate();
	}
	
	//시작 Rownum 과 종료 Rownum을 계산
	public int getBeginRownum() {
		return page * size - (size-1);
		
	}
	public int getEndRownum() {
		return page * size;
	}
	
	public String getParameter() {
		String path = UriComponentsBuilder.fromPath("")
				.queryParam("size", size)
				.queryParamIfPresent("column", Optional.ofNullable(column))
				.queryParamIfPresent("keyword", Optional.ofNullable(keyword))
				.queryParamIfPresent("beginDate", Optional.ofNullable(beginDate))
				.queryParamIfPresent("endDate", Optional.ofNullable(endDate))
				.encode()
				.toUriString();
		return path;
	}
	
	//목록 및 검색 유지용 파라미터 생성
	public String getSearchParams() {
//		if(isList())
//			return "size="+size;
//		else
//			return "size="+size+"&column="+column+"&keyword="+keyword;
		
		// 1. 기본적으로 size는 항상 포함
	    StringBuilder sb = new StringBuilder();
	    sb.append("size=").append(size);

	    // 2. 검색어(column, keyword)가 있는 경우 추가
	    if (column != null && keyword != null) {
	        sb.append("&column=").append(column);
	        sb.append("&keyword=").append(keyword);
	    }

	    // 3. ★ 핵심: 날짜 정보가 있다면 파라미터에 추가
	    // 이 부분이 있어야 페이지 번호를 눌러도 날짜가 유지됩니다.
	    if (beginDate != null && !beginDate.isEmpty()) {
	        sb.append("&beginDate=").append(beginDate);
	    }
	    if (endDate != null && !endDate.isEmpty()) {
	        sb.append("&endDate=").append(endDate);
	    }

	    return sb.toString();
	}

	//history?beginDate=2026-04-14&endDate=2026-04-23
	//현재 페이지에 맞는 첫 블록 번호를 반환하는 메소드
	public int getBeginBlock() {
		return (page-1) / 10 * 10 + 1;
	}
	
	//이전 블록이 존재하는지 판정하는 메소드
	public boolean hasPrevious() {
		return getBeginBlock() > 1;
	}
	
	//이전을 누르면 이동할 블록 번호를 반환하는 메소드
	public int getPreviousBlock() {
		return getBeginBlock() - 1;
	}
	
	//총 페이지 수 (pageCount)
	public int getPageCount() {
		return (count-1) / 10 + 1;
	}
	//현재 페이지 기준 마지막 페이지 블록을 계산하여 반환하는 메소드(endBlock)
	public int getEndBlock() {
		int endBlock = getBeginBlock() + 9;
		return Math.min(getPageCount(), endBlock);
	}
	
	//다음이 존재하는지 판정하여 반환하는 메소드
	public boolean hasNext() {
		return getEndBlock() < getPageCount();
	}
	
	//다음을 누르면 나올 블록번호를 계산하는 메소드 (endBlock + 1)
	public int getNextBlock() {
		return getEndBlock() + 1;
	}
	
	
	
	
}
