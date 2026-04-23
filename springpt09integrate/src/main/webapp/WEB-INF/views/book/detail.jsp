	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>도서 상세정보</h1>

<!-- 이곳에 표지를 출력하고 싶다 -->
<img src="./cover?bookId=${bookDto.bookId}" height="250">

<!-- <ul> -->
<%-- 	<li>도서번호: ${bookDto.bookId}</li> --%>
<%-- 	<li>도서명: [${bookDto.bookTitle}]</li> --%>
<%-- 	<li>작가: ${bookDto.bookAuthor}</li> --%>
<%-- 	<li>출간일: ${bookDto.bookPublicationDate}</li> --%>
<%-- 	<li>가격: ${bookDto.bookPrice}원</li> --%>
<%-- 	<li>출판사: ${bookDto.bookPublisher}</li> --%>
<%-- 	<li>페이지: ${bookDto.bookPageCount}P</li> --%>
<%-- 	<li>장르: ${bookDto.bookGenre}</li> --%>
<!-- </ul> -->

<table border=1 width=1000>
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
	<tbody>
		<tr>
			<td align="right">${bookDto.bookId}</td>
			<td>${bookDto.bookTitle}</td>
			<td>${bookDto.bookAuthor}</td>
			<td>${bookDto.bookPublicationDate}</td>
			<td>${bookDto.bookPrice}</td>
			<td>${bookDto.bookPublisher}</td>
			<td>${bookDto.bookPageCount}</td>
			<td>${bookDto.bookGenre}</td>
		</tr>
	</tbody>
</table>

<!-- 이동 창 -->
<ul style="color: purple">
	<li ><a href="./list">목록으로 이동</a></li>
	<li><a href="./insert">신규등록</a></li>
	<li><a href="./edit?bookId=${bookDto.bookId}">수정</a></li>
	<li><a href="./delete?bookId=${bookDto.bookId}">삭제</a></li>
</ul>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>