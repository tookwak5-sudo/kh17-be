		<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  여러 가지 정보들을 출력 -->
세션ID : ${pageContext.session.id}
loginId : ${sessionScope.loginId}
loginLevel : ${sessionScope.loginLevel}

<!-- 템플릿 페이지에서 상대경로로 작성할 경우 작동하지 않을 수 있다 -->
<h1>[KH정보교육원 웹개발 수업과정]</h1>
<a href="/">HOME</a>
<a href="/country/list">국가정보</a>
<a href="/lecture/list">강좌정보</a>
<a href="/book/list">도서정보</a>
<a href="/member/join">회원가입</a>
<a href="/member/login">로그인</a>
<a href="/member/logout">로그아웃</a>
<hr>

<div style="min-height: 300px">