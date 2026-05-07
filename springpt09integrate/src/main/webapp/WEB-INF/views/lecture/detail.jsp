<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<div class="container w-800 mt-50 mb-50">
	
	<div class="flex-area">
			<ul>
			<li>강의번호 ${lectureDto.lectureNo}</li>
			<li>강의명 ${lectureDto.lectureTitle}</li>
			<li>카테고리 ${lectureDto.lectureCategory}</li>
			<li>강의시간 ${lectureDto.lectureDuration}</li>
			<li>수강료 ${lectureDto.lecturePrice}</li>
			<li>강의유형 ${lectureDto.lectureType}</li>
		</ul>
		
		<h2>이미지 미리보기</h2>
		
		<%-- <img src="./image?lectureNo=${lectureDto.lectureNo}" width="100"> --%>
		<c:if test="${images.isEmpty()}">
			<img src="./image?lectureNo=${lectureDto.lectureNo}" width="100">
		</c:if>
		<c:forEach var="attachNo" items="${images}">
			<img src="/download/legacy?attachNo=${attachNo}" width="100" height="100">
		</c:forEach>
	</div>
<!-- 이동 창 -->
<ul style="color: red">
	<li ><p><a href="./list">목록으로 이동</a></p></li>
	<li><p><a href="./insert">신규등록</a></p></li>
	<li><p><a href="./edit?lectureNo=${lectureDto.lectureNo}">수정</a></p></li>
	<li><p><a href="./delete?lectureNo=${lectureDto.lectureNo}">삭제</a></p></li>
</ul>

</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>