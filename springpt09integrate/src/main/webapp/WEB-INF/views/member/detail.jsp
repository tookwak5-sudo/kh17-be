<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>회원 상세조회</h1>

<ul>
	<li>아이디: ${memberDto.memberId}</li>
	<li>이메일: ${memberDto.memberEmail}</li>
	<li>비밀번호: ${memberDto.memberPassword}</li>
	<li>별명: ${memberDto.memberNickname}</li>
	<li>생일: ${memberDto.memberBirth}</li>
	<li>연락처: ${memberDto.memberContact}</li>
	<li>우편번호: ${memberDto.memberPost}</li>
	<li>기본주소: ${memberDto.memberAddress1}</li>
	<li>상세주소: ${memberDto.memberAddress2}</li>
	<li>회원등급: ${memberDto.memberLevel}</li>
	<li>상태메세지: ${memberDto.memberMessage}</li>
	<li>최초가입일:
		${memberDto.memberJoin} 
	</li>
	<li>최종로그인: ${memberDto.memberLogin}</li>
	<li>최종비밀번호변경: ${memberDto.memberChange}</li>
	<li>차단: ${memberDto.memberBlock}</li>
	<li>회원포인트: ${memberDto.memberPoint}</li>
</ul>

<div>
	<a href="./list">목록으로 이동</a> <br>
	<a href="./insert">신규 등록</a>	<br>
	<a href="./edit?memberNo=${memberDto.memberNo}">정보 수정</a> <br>
	<a href="./delete?memberNo=${memberDto.memberNo}">회원정보 삭제</a> <br>
</div>