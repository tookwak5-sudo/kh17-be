<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원정보 등록</h1>

<form action="./join" method="post" enctype="multipart/form-data">
	아이디* <input type="text" name="memberId" required> <br><br>
	이메일* <input type="text" inputmode="email" name="memberEmail" required> <br><br>
	비밀번호* <input type="password" name="memberPassword" required> <br><br>
	별명* <input type="text" name="memberNickname" required> <br><br>
	생일 <input type="date" name="memberBirth"> <br><br>
	연락처 <input type="text" inputmode="tel" name="memberContact"> <br><br>
	우편번호 <input type="text" inputmode="numeric" name="memberPost"> <br><br>
	기본주소 <input type="text" name="memberAddress1"> <br><br>
	상세주소 <input type="text" name="memberAddress2"> <br><br>
	상태메세지  
<!-- 	<input type="text" name="memberMessage"> <br><br> -->
	<textarea name="memberMesssage"></textarea> <br><br>
	프로필이미지 <input type="file" name="attach" accept=".png, .jpg">
	<button>회원가입</button>
</form>

<a href="/member/login">로그인</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>