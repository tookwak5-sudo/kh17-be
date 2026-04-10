<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- 제목 -->
<h1>도서 목록 조회</h1>

<!-- 검색창 -->
<form action="./list">
	<select name="column">
		<option value="book_title" ${param.column == "book_title" ? "selected" : ""}>도서명</option>
		<option value="book_author" ${param.column == "book_author" ? "selected" : ""}>저자</option>
		<option value="book_publication_date" ${param.column == "book_publication_date" ? "selected" : ""}>출간일</option>
	</select>
	<input type="text" name="keyword" placeholder="검색어 입력"
		value="${param.keyword}" required>
	<button>검색</button>
</form>

<!-- 등록링크 -->
<a href="./insert">신규 도서등록</a>


<%-- <c:if test="${listByBookTitle.size() > 0}"> --%>
<!-- 	<h2>도서 제목 검색 결과</h2> -->
	
<%-- 	<c:forEach var="bookDto" items="${listByBookTitle}"> --%>
<!-- 	<div> -->
<!-- 		<img src="https://www.dummyimage.com/100x150?text=Book"> -->
<!-- 		<h2> -->
<%-- 			<a href="./detail?bookId=${bookDto.bookId}"> --%>
<%-- 				${bookDto.bookId} --%>
<!-- 			</a>	 -->
<!-- 		</h2> -->
<%-- 		지은이 : ${bookDto.bookAuthor}<br> --%>
<%-- 		출판사 : ${bookDto.bookPublisher}<br> --%>
<%-- 		장르 : ${bookDto.bookGenre}<br> --%>
<%-- 		출간일 : ${bookDto.bookPublicationDate}<br> --%>
<!-- 	</div> -->
<%-- 	</c:forEach> --%>
<!-- 		<hr> -->
	
<%-- </c:if> --%>

<%-- <c:if test="${listByBookAuthor.size() > 0}"> --%>
<!-- 	<h2>도서 지은이 검색 결과</h2> -->
<!-- 	<div> -->
<!-- 		<img src="https://www.dummyimage.com/100x150?text=Book"> -->
<%-- 		<h2>${bookDto.bookTitle}</h2> --%>
<%-- 		지은이 : ${bookDto.bookAuthor}<br> --%>
<%-- 		출판사 : ${bookDto.bookPublisher}<br> --%>
<%-- 		장르 : ${bookDto.bookGenre}<br> --%>
<%-- 		출간일 : ${bookDto.bookPublicationDate}<br> --%>
<!-- 	</div> -->
<%-- </c:if> --%>
<!-- 		<hr> -->

<%-- <c:if test="${listByBookPublicationDate.size() > 0}"> --%>
<!-- 	<h2>도서 출간일 검색 결과</h2> -->
<!-- 	<div> -->
<!-- 		<img src="https://www.dummyimage.com/100x150?text=Book"> -->
<%-- 		<h2>${bookDto.bookTitle}</h2> --%>
<%-- 		지은이 : ${bookDto.bookAuthor}<br> --%>
<%-- 		출판사 : ${bookDto.bookPublisher}<br> --%>
<%-- 		장르 : ${bookDto.bookGenre}<br> --%>
<%-- 		출간일 : ${bookDto.bookPublicationDate}<br> --%>
<!-- 	</div> -->
<%-- </c:if> --%>
<!-- 		<hr> -->



 <!-- 결과출력 -->
<h2>도서 수: ${list.size()}</h2>

<table border=1 width=1000px>
	<thead>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>작가</th>
			<th>출간일</th>
			<th>가격</th>
			<th>출판사</th>
			<th>페이지</th>
			<th>장르</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="bookDto" items="${list}">		
		<tr>
			<td>${bookDto.bookId}</td>
			<td>
				<a href="./detail?bookId=${bookDto.bookId}">
					${bookDto.bookTitle}
				</a>
			</td>
			<td>
<!-- 		작가를 누르면 해당 작가의 도서만 -->
				<a href="./list?column=book_author&keyword=${bookDto.bookAuthor}">
					${bookDto.bookAuthor}
				</a>			
			</td>
			<td>${bookDto.bookPublicationDate}</td>
			<td align="right" width= "100">
				<fmt:formatNumber
				value ="${bookDto.bookPrice}" 
				pattern="#,##0"></fmt:formatNumber>원
			</td>
			<td>${bookDto.bookPublisher}</td>
			<td>${bookDto.bookPageCount}</td>
			<td>${bookDto.bookGenre}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>