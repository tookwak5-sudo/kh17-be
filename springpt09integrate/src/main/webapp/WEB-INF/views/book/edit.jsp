<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<h1>도서 정보 수정</h1>

<form action="./edit" method="post">
	<input type="hidden" name="bookId" value="${bookDto.bookId}">
	도서이름 <input type = "text" name="bookTitle" 
				value="${bookDto.bookTitle}" placeholder="나의 라임 오렌지나무" required> <br><br>
	출판사 <input type = "text" name="bookPublisher" 
				value="${bookDto.bookPublisher}" placeholder="출판사이름 : ex. 한빛출판사"> <br><br>
	저자 <input type = "text" name="bookAuthor" 
				value="${bookDto.bookAuthor}" placeholder="조지"> <br><br>
	출간일 <input type = "date" name="bookPublicationDate"
				value="${bookDto.bookPublicationDate}"> <br><br>
	가격 <input type = "number" name="bookPrice" 
				value="${bookDto.bookPrice}" step="1000" required> <br><br>
	페이지 수 <input type = "text" name="bookPageCount" 
				value="${bookDto.bookPageCount}" placeholder="페이지 수 : ex.300" required> <br><br>
	장르 
	<select name="bookGenre" required>
		<option ${bookDto.bookGenre == '판타지' ? 'selected' : ''}>판타지</option>
		<option ${bookDto.bookGenre == '교양' ? 'selected' : ''}>교양</option>
		<option ${bookDto.bookGenre == '소설' ? 'selected' : ''}>소설</option>
		<option ${bookDto.bookGenre == '역사' ? 'selected' : ''}>역사</option>
		<option ${bookDto.bookGenre == '과학' ? 'selected' : ''}>과학</option>
		<option>추리소설</option>
		<option>자기계발</option>
		<option>수험서</option>
	</select>
	<br><br>
	<button>도서정보 등록</button>
</form>