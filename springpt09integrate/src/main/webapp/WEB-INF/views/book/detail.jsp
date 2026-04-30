	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
	.book-info {
		list-style: none;
		padding: 0;
		margin: 0;
	}
	.book-info li {
		border-bottom: 1px solid #bdc3c7;
		padding: 10px 5px;
		line-height: 1.5;
		color: #16a085;
		font-size: 1.1em;
	}
	
</style>

<div class="container w-800 mt-50 mb-50">
	<div class="flex-area">
			<div>
				<div class="w-120 cell center mt-50" >
					<h1>${bookDto.bookTitle}</h1>
				</div>
				<div class="flex-fill flex-area flex-center">
					<img src="./cover?bookId=${bookDto.bookId}" height="400">
				</div>
			</div>
		<div class="flex-fill mt-50 green" style="padding:2em;">
			<ul class="book-info">
				<li class="field field-underline">No: ${bookDto.bookId}</li>
				<li class="field field-underline">도서명: [${bookDto.bookTitle}]</li>
				<li class="field field-underline">작가: ${bookDto.bookAuthor}</li>
				<li class="field field-underline">출간일: ${bookDto.bookPublicationDate}</li>
				<li class="field field-underline">가격: ${bookDto.bookPrice}원</li>
				<li class="field field-underline">출판사: ${bookDto.bookPublisher}</li>
				<li class="field field-underline">페이지: ${bookDto.bookPageCount}P</li>
				<li class="field field-underline">장르: ${bookDto.bookGenre}</li>
			</ul>
		</div>
	</div>
	
	<div class="cell right">
		<!-- 이동 창 -->
			<a class="btn btn-positive" href="./insert">신규등록</a>
			<a class="btn btn-netural" href="./list">목록으로 이동</a>
			<a class="btn btn-netural"  href="./edit?bookId=${bookDto.bookId}">수정</a>
			<a class="btn btn-negative"  href="./delete?bookId=${bookDto.bookId}">삭제</a>
	</div>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>