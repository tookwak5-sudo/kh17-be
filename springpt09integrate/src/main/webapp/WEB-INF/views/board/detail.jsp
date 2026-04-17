	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	
	<p><a href="./writer">글쓰기</a>
	<p><a href="./edit?boardNo=${boardDto.boardNo}">수정</a></p>
	<p><a href="./delete?boardNo=${boardDto.boardNo}">삭제</a></p>
	<p><a href="./list">목록</a></p>
	<h1>[${boardDto.boardWriter}]게시글</h1>
	
	<ul>
		<li>구분: ${boardDto.boardHead}</li>
		<li>작성일: ${boardDto.boardWtime}</li>
		<li>조회수: ${boardDto.boardReadcount}</li>
		<li>좋아요: ${boardDto.boardLikecount}</li>
		<li>댓글수: ${boardDto.boardReplycount}</li>
		<li>제목: ${boardDto.boardTitle}</li>
		<li>본문: ${boardDto.boardContent}</li>
	</ul>
	
	
	<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
