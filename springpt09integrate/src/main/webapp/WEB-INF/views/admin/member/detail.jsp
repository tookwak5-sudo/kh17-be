<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>[${memberDto.memberId}] 회원님의 상세내용</h1>

<ul>
	<li>아이디: ${memberDto.memberId}</li>
	<li>이메일: ${memberDto.memberEmail}</li>
	<li>별명: ${memberDto.memberNickname}</li>
	<li>생일: ${memberDto.memberBirth}</li>
	<li>연락처: ${memberDto.memberContact}</li>
	<li>우편번호: ${memberDto.memberPost}</li>
	<li>기본주소: ${memberDto.memberAddress1}</li>
	<li>상세주소: ${memberDto.memberAddress2}</li>
	<li>회원등급: ${memberDto.memberLevel}</li>
	<li>상태메세지: ${memberDto.memberMessage}</li>
	<li>회원포인트: ${memberDto.memberPoint}</li>
	<li>최초가입일:${memberDto.memberJoin} </li>
	<li>최종로그인: ${memberDto.memberLogin}</li>
	<li>최종비밀번호변경일: ${memberDto.memberChange}</li>
	<li>차단여부: ${memberDto.memberBlock}</li>
	<c:if test="${memberDto.isWaitForDelete()}">
	<li>탈퇴신청일 : <fmt:formatDate value="${memberDto.memberExitTime}"/> </li>
	</c:if>
</ul>

<h1>최근 로그인 이력</h1>
<table border = "1" width = "1400">
	<thead>
		<tr>
			<th>일시</th>
			<th>접속주소</th>
			<th>에이전트</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="memberHistoryDto" items="${loginHistory}">
		<tr>
			<td>${memberHistoryDto.memberHistoryTime}</td>
			<td>${memberHistoryDto.memberHistoryAddress}</td>
			<td>${memberHistoryDto.memberHistoryAgent}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<div>
	<a href="./list">목록으로 이동</a> <br>
	<a href="./block?memberId=${memberDto.memberId}">
		${memberDto.memberBlock == 'Y' ? '해제' : '차단' }
	</a> <br>
	<a href="./edit?memberId=${memberDto.memberId}">회원정보변경</a> <br>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>