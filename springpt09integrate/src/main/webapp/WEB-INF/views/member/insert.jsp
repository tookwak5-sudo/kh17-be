<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원정보 등록</h1>

<form action="./insert" method="post">
	<input type="hidden" name="memberLevel" value="브론즈">
	<input type="hidden" name="memberPoint" value="0">
	아이디 <input type="text" name="memberId"> <br><br>
	이메일 <input type="text" name="memberEmail"> <br><br>
	비번 <input type="text" name="memberPassword"> <br><br>
	별명 <input type="text" name="memberNickname"> <br><br>
	생일 <input type="text" name="memberBirth"> <br><br>
	연락처 <input type="text" name="memberContact"> <br><br>
	우편번호 <input type="text" name="memberPost"> <br><br>
	기본주소 <input type="text" name="memberAddress1"> <br><br>
	상세주소 <input type="text" name="memberAddress2"> <br><br>
	상태메세지 <input type="text" name="memberMessage"> <br><br>
	<button>회원가입</button>
</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>