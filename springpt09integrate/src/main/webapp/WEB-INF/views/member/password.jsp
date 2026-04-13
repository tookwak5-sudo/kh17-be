<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 코어 태그가 필요 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<h1>비밀번호 입력</h1>
	
	비밀번호 변경을 위해 기존 비밀번호를 한번 더 입력하고 신규 비밀번호를 입력해주세요

<form action="./password" method="post">
		<p>기존 비밀번호: <input type="text" name="originPw" required></p>
		<p>신규 비밀번호: <input type="text" name="changePw" required></p>
	<button>변경</button>
</form>
  	<c:if test="${param.error != null}">
        <p style="color:red;">비밀번호가 일치하지 않거나 동일한 값을 입력하셨습니다</p>
    </c:if>
    

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>