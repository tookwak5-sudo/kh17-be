package com.kh.spring11.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "도서 등록 정보")
@Data
public class BookInsertVO {
	@Schema(description = "도서 제목", example="어린왕자")
	private String bookTitle;
	@Schema(description = "저자", example="생텍쥐페리")
	private String bookAuthor;
	@Schema(description = "출간일", example="20260501")
	private String bookPublicationDate;
	@Schema(description = "가격", example="15000")
	private int bookPrice;
	@Schema(description = "출판사", example="비상")
	private String bookPublisher;
	@Schema(description = "페이지 수", example="350")
	private int bookPageCount;
	@Schema(description = "장르", examples= { "판타지", "교양", "소설", "역사", "과학", "추리소설", "자기계발", "수험서"})
	private String bookGenre;
}
