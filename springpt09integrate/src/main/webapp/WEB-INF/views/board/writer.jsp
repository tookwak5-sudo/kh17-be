<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>신규 글 작성</h1>
타인에 대한 무분별한 비방글은 경고 없이 삭제될 수 있습니다

<form action="./writer" method="post">
작성자: ${boardDto.boardWriter}
<input type="hidden" name="boardWriter" value="${boardDto.boardWriter}">
	제목: <input type="text" name="boardTitle" required> <br><br>
	구분: <select name="boardHead" required>
			<option value="">샘플</option>
			<option value="공지">공지</option>
			<option value="유머">유머</option>
			<option value="자유">자유</option>
			<option value="정보">정보</option>
		</select>
		<br><br>
	내용 <br>
	<textarea name="boardContent" rows="30" cols="50" required></textarea>
	<button>등록</button> <br><br>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
   
	