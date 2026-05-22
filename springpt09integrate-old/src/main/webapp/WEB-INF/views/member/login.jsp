<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- c코어 태그 불러오기 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="./login" method="post">
    <h1>로그인</h1>
    <p>아이디: <input type="text" name="memberId" required></p>
    <p>비밀번호: <input type="password" name="memberPassword" required></p>
     <button>로그인</button>
</form>
    
    <c:if test="${param.error != null}">
        <p style="color:red;">아이디 또는 비밀번호가 일치하지 않습니다.</p>
    </c:if>
    


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>