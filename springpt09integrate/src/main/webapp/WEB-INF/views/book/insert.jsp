<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		<option>판타지</option>
		<option>교양</option>
		<option>소설</option>
		<option>역사</option>
		<option>과학</option>
		<option>추리소설</option>
		<option>자기계발</option>
		<option>수험서</option>
	</select>
	<br><br>
	<button>도서정보 등록</button>
</form>