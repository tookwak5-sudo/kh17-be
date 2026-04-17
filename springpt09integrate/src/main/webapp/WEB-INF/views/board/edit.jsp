<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시글 수정</h1>

<form action="./edit" method="post">
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	<button>등록</button> <br><br>
	구분: <select name="boardHead" required>
			<option ${boardDto.boardHead == '샘플' ? 'selected' : ''}>샘플</option>
			<option ${boardDto.boardHead == '공지' ? 'selected' : ''}>공지</option>
			<option ${boardDto.boardHead == '유머' ? 'selected' : ''}>유머</option>
			<option ${boardDto.boardHead == '자유' ? 'selected' : ''}>자유</option>
			<option ${boardDto.boardHead == '정보' ? 'selected' : ''}>정보</option>
		</select>
	제목: <input type="text" name="boardTitle" value="${boardDto.boardTitle}" required> <br><br>
	본문 <br>
	<textarea name="boardContent" rows="30" cols="50" required>${boardDto.boardContent}</textarea>
</form>
	
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>