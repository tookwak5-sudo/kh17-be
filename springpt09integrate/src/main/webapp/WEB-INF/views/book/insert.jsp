<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>도서정보 등록</h1>

<!-- 
<form href="/book/insert">
action없으면 지금 현재주소라 actiond을 빼도 무방 
-->
	<form method= "post">
<!-- <form action="./insert" method= "post"> -->
	도서이름 <input type = "text" name="bookTitle" placeholder="나의 라임 오렌지나무" required> <br><br>
	출판사 <input type = "text" name="bookPublisher" placeholder="출판사이름 : ex. 한빛출판사"> <br><br>
	저자 <input type = "text" name="bookAuthor" placeholder="조지"> <br><br>
	출간일 <input type = "date" name="bookPublicationDate"> <br><br>
	가격 <input type = "number" name="bookPrice" step="1000" required> <br><br>
	페이지 수 <input type = "text" name="bookPageCount" placeholder="페이지 수 : ex.300" required> <br><br>
	장르 
	<select name="bookGenre" required>
		<option value="">선택하세요</option>
		<option ${bookDto.bookGenre == '판타지' ? 'selected' : ''}>판타지</option>
		<option ${bookDto.bookGenre == '교양' ? 'selected' : ''}>교양</option>
		<option ${bookDto.bookGenre == '소설' ? 'selected' : ''}>소설</option>
		<option ${bookDto.bookGenre == '역사' ? 'selected' : ''}>역사</option>
		<option ${bookDto.bookGenre == '과학' ? 'selected' : ''}>과학</option>
		<option ${bookDto.bookGenre == '추리소설' ? 'selected' : ''}>추리소설</option>
		<option ${bookDto.bookGenre == '자기계발' ? 'selected' : ''}>자기계발</option>
		<option ${bookDto.bookGenre == '숳' ? 'selected' : ''}>수험서</option>
	</select>
	<br><br>
	<button>도서정보 등록</button>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
</form>