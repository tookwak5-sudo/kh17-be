<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
 <h1>강좌 정보 수정</h1>
 
 <form action="./edit" method="post">
 	<input type="hidden" name="memberNo" value="${memberDto.memberNo}">
 	아이디 <input type="text" name="memberId" value="${memberDto.memberId}"> <br><br>
	이메일 <input type="text" name="memberEmail" value="${memberDto.memberEmail}"> <br><br>
	비번 <input type="text" name="memberPassword" value="${memberDto.memberPassword}"> <br><br>
	별명 <input type="text" name="memberNickname" value="${memberDto.memberNickname}"> <br><br>
	생일 <input type="text" name="memberBirth" value="${memberDto.memberBirth}"> <br><br>
	연락처 <input type="text" name="memberContact" value="${memberDto.memberContact}"> <br><br>
	우편번호 <input type="text" name="memberPost" value="${memberDto.memberPost}"> <br><br>
	기본주소 <input type="text" name="memberAddress1" value="${memberDto.memberAddress1}"> <br><br>
	상세주소 <input type="text" name="memberAddress2" value="${memberDto.memberAddress2}"> <br><br>
	회원등급 <input type="text" name="memberLevel" value="${memberDto.memberLevel}"> <br><br>
	상태메세지 <input type="text" name="memberMessage" value="${memberDto.memberMessage}"> <br><br>
	포인트 <input type="text" name="memberPoint" value="${memberDto.memberPoint}"> <br><br>
	<button>수정</button>
 </form>