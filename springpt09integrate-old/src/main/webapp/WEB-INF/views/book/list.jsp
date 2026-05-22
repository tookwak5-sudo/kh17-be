<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-900 mt-50 mb-50">
	<div class="cell center mt-50">
		<!-- 제목 -->
		<h1>도서 목록 조회</h1>
	</div>
	
	<div class="cell right">
	<!-- 결과출력 -->
	<h2>결과 수 : ${pageVo.beginRownum} ~ ${pageVo.endRownum}  / 총 ${pageVo.count}개</h2>
	</div>
		
	<div class="cell right">
		<div class="flex-area">
			<div>
			<!-- 검색창 -->
			<form action="./list">
				<select name="column" class="field">
					<option value="book_title" ${param.column == "book_title" ? "selected" : ""}>도서명</option>
					<option value="book_author" ${param.column == "book_author" ? "selected" : ""}>저자</option>
					<option value="book_publication_date" ${param.column == "book_publication_date" ? "selected" : ""}>출간일</option>
				</select>
				<input type="text" name="keyword" placeholder="검색어 입력"
					value="${param.keyword}" class="field" required>
				<button class="btn btn-positive">검색</button>
			</form>
			</div>
		
		<div class="flex-fill right">
			<!-- 등록링크 -->
			<a href="./insert" class="btn btn-netural">
				<i class="fa-solid fa-plus"></i>
				<span>신규 도서등록</span>
			</a>
		</div>
	</div>
	<!-- 테이블 -->
	<div class="cell center">
		<table class="table">
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
				<tbody class="center">
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
						<td class="right w-10">
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
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/template/pagenation.jsp"></jsp:include>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>