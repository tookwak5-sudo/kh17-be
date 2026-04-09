<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>강좌 상세조회</h1>

<ul>
	<li>강의번호 ${lectureDto.lectureNo}</li>
	<li>강의명 ${lectureDto.lectureTitle}</li>
	<li>카테고리 ${lectureDto.lectureCategory}</li>
	<li>강의시간 ${lectureDto.lectureDuration}</li>
	<li>수강료 ${lectureDto.lecturePrice}</li>
	<li>강의유형 ${lectureDto.lectureType}</li>
</ul>
	<a href="./list">목록으로 이동</a> <br>
	<a href="./insert">강좌등록</a>

<c:if test="">
	<%@ page isErrorPage="true" %>
<html>
<body>
    <h2>서비스 이용에 불편을 드려 죄송합니다.</h2>
    <p>오류 내용: <%= exception.getMessage() %></p>
</body>
</html>
</c:if>
