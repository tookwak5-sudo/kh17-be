<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h1>회원정보 등록</h1>

<form action="./join" method="post">
	아이디 <input type="text" name="memberId" required> <br><br>
	이메일 <input type="text" name="memberEmail" required> <br><br>
	비번 <input type="text" name="memberPassword" required> <br><br>
	별명 <input type="text" name="memberNickname" required> <br><br>
	생일 <input type="text" name="memberBirth"> <br><br>
	연락처 <input type="text" name="memberContact"> <br><br>
	우편번호 <input type="text" name="memberPost"> <br><br>
	기본주소 <input type="text" name="memberAddress1"> <br><br>
	상세주소 <input type="text" name="memberAddress2"> <br><br>
	상태메세지 <input type="text" name="memberMessage"> <br><br>
	<button>회원가입</button>
</form>