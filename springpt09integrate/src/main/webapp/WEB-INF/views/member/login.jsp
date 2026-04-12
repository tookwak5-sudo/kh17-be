<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="./login" method="post">
    <h1>로그인</h1>
    <p>아이디: <input type="text" name="memberId" required></p>
    <p>비밀번호: <input type="password" name="memberPassword" required></p>
    
    <c:if test="${param.error != null}">
        <p style="color:red;">아이디 또는 비밀번호가 일치하지 않습니다.</p>
    </c:if>
    
    <button type="submit">로그인</button>
</form>