<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<h1>회원 탈퇴</h1>

<form action="./goodbye" method="post">
	<h2>회원탈퇴를 위한 비밀번호 검사</h2>
	<input type="text" name="memberPassword" required> <br><br>
	
	<button>회원탈퇴</button>
</form>

	<c:if test="${param.error != null}">
 	<p style="color:red;">비밀번호가 일치하지 않습니다</p> 
 	</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>