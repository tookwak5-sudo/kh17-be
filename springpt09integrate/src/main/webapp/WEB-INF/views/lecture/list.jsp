<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 제목 -->
<h1>강좌 목록 조회</h1>

<!-- 검색창 -->
<form action="./list" method="post">
	<select name="column">
		<option value="lecture_title" ${param.column == "lecture_title" ? "selected" : ""}>강좌명</option>
		<option value="lecture_category" ${param.column == 'lecture_category' ? 'selected' : ''}>카테고리</option>
		<option value="lecture_type" ${param.column == "lecture_type" ? "selected" : ""}>강좌유형</option>
	</select>
	<input type = "text" name="keyword" placeholder="검색어 입력"
		   value="${param.keyword}" required>
	<button>검색</button>
</form>

<!-- 등록링크 -->
<a href="./insert">신규 등록하기</a>

<!-- 결과출력 -->

<h2>강좌 수: ${list.size()}</h2>
<c:forEach var="lectureDto" items="${list}">
<div>
	<h3>[${lectureDto.lectureNo}] 
		${lectureDto.lectureTitle}
	</h3>
	카테고리 : ${lectureDto.lectureCategory} <br>
	강의 시간 : ${lectureDto.lectureDuration} <br>
	수강료 : <fmt:formatNumber value="${lectureDto.lecturePrice}" pattern="#,##0"/>원<br>
	수업유형 : ${lectureDto.lectureType}
</div>
<!-- <table border=1 > <thead> -->
<!-- 	<tr> -->
<!-- 		<th>강의명</th> -->
<!-- 		<th>카테고리</th>	 -->
<!-- 		<th>강의시간	</th> -->
<!-- 		<th>수강료</th> -->
<!-- 		<th>강의유형</th> -->
<!-- 	</tr> -->
<!-- 	</thead> -->
<!-- 	<tbody></tbody> -->
<%-- 		<td>${lectureDto.lectureTitle}</td> --%>
<%-- 		<td>${lectureDto.lectureCategory}</td> --%>
<%-- 		<td>${lectureDto.lectureDuration}</td> --%>
<%-- 		<td>${lectureDto.lecturePrice}원</td> --%>
<%-- 		<td>${lectureDto.lectureType}</td> --%>
<!-- 	</table> -->
</c:forEach>