<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>강좌 상세조회</h1>

<ul>
	<li>강의번호 ${lectureDto.lectureNo}</li>
	<li>강의명 ${lectureDto.lectureTitle}</li>
	<li>카테고리 ${lectureDto.lectureCategory}</li>
	<li>강의시간 ${lectureDto.lectureDuration}</li>
	<li>수강료 ${lectureDto.lecturePrice}</li>
	<li>강의유형 ${lectureDto.lectureType}</li>
</ul>


<!-- 이동 창 -->
<ul style="color: red">
	<li ><p><a href="./list">목록으로 이동</a></p></li>
	<li><p><a href="./insert">신규등록</a></p></li>
	<li><p><a href="./edit?lectureNo=${lectureDto.lectureNo}">수정</a></p></li>
	<li><p><a href="./delete?lectureNo=${lectureDto.lectureNo}">삭제</a></p></li>
</ul>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>