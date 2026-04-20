<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <h1>상세정보</h1>
<%--  <fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>  --%>
 <ul>
 	<li>아이디: ${memberDto.memberId}</li>
 	<li>등급: ${memberDto.memberLevel}</li>
 	<li>닉네임: ${memberDto.memberNickname}</li>
 	<li><fmt:formatDate value="${memberDto.memberJoin}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></li>
 	
 </ul>