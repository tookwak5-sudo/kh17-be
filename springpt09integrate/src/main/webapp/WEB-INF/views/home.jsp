<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>메인페이지</h1>
	<c:if test="${param.error != null}">
 	<p style="color:red;">비밀번호 변경이 필요합니다</p> 
 	</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
	
<!-- 
	header: 로고 검색창 메뉴 등 가장 중요
	메인페이지	
	footer: 회사정보나 이용약관등등 
-->