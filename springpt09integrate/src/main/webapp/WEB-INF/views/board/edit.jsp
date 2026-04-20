<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시글 수정</h1>

<form action="./edit" method="post">
<!-- hidden이 없으면 대상이 없다고 나오기 때문에 주의해야함 -->
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	제목: <input type="text" name="boardTitle" value="${boardDto.boardTitle}" required> <br><br>
	구분: 
	<select name="boardHead" required>
	<!-- 나머지가 다 선택이 안되면 선택 안함이 자동으로 selected되기 때문에 굳이 할 필요가 없다 -->
		<option value="">선택 안함</option>
		<option ${boardDto.boardHead == '공지' ? 'selected' : ''}>공지</option>
		<option ${boardDto.boardHead == '유머' ? 'selected' : ''}>유머</option>
		<option ${boardDto.boardHead == '자유' ? 'selected' : ''}>자유</option>
		<option ${boardDto.boardHead == '정보' ? 'selected' : ''}>정보</option>
	</select>
	본문 <br>
	<!-- <pre>와 <textarea>는 space와 enter모두 입력값으로 들어감으로 공백에 매우 유의해야한다 -->
	<textarea name="boardContent" rows="30" cols="50" required>${boardDto.boardContent}</textarea> <br><br>
	<button>수정하기</button> 
</form>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>