<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>





<!-- 
<form href="/book/insert">
action없으면 지금 현재주소라 actiond을 빼도 무방 
-->
<form action="./insert" method= "post" enctype="multipart/form-data">
	<div class="container w-400 mt-50">
		<div class="cell center">	
			<h1>도서정보 등록</h1>
		</div>	
			<!-- <form action="./insert" method= "post"> -->
			<div class="cell">
				<label>도서명</label> 
				<input type = "text" name="bookTitle" class="field w-100" placeholder="나의 라임 오렌지나무" required>
			</div>	
			<div class="cell">
				<label>출판사</label> 
				<input type = "text" name="bookPublisher" class="field w-100" placeholder="출판사이름 : ex. 한빛출판사">
			</div>
			<div class="cell">
			<label>저자</label> 
			<input type = "text" name="bookAuthor" class="field w-100" placeholder="조지">
			</div>
			<div class="cell">
			<label>출간일</label> 
			<input type = "date" name="bookPublicationDate" class="field w-100">
			</div>
			<div class="cell">
			<label>가격</label> 
			<input type = "number" name="bookPrice"  class="field w-100" step="1000" required>
			</div>
			<div class="cell">
			<label>페이지 수</label>
			<input type = "text" name="bookPageCount"  class="field w-100" placeholder="페이지 수 : ex.300" class="field" required class="field">
			</div>
			
		<div class="cell">
			<label>장르</label> 
			<select class="field w-100" name="bookGenre" required>
				<option value="">선택하세요</option>
				<option ${bookDto.bookGenre == '판타지' ? 'selected' : ''}>판타지</option>
				<option ${bookDto.bookGenre == '교양' ? 'selected' : ''}>교양</option>
				<option ${bookDto.bookGenre == '소설' ? 'selected' : ''}>소설</option>
				<option ${bookDto.bookGenre == '역사' ? 'selected' : ''}>역사</option>
				<option ${bookDto.bookGenre == '과학' ? 'selected' : ''}>과학</option>
				<option ${bookDto.bookGenre == '추리소설' ? 'selected' : ''}>추리소설</option>
				<option ${bookDto.bookGenre == '자기계발' ? 'selected' : ''}>자기계발</option>
				<option ${bookDto.bookGenre == '수험서' ? 'selected' : ''}>수험서</option>
			</select>
		</div>	
		<div class="cell">
		<label>표지</label>
		<input type="file" name="attach" class="field w-100" accept=".png, .jpg"> <br><br>
		</div>
		<div class="cell mt-10 right">
		<button class="btn btn-positive w-100">도서정보 등록</button>
		</div>
	</div>	
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>