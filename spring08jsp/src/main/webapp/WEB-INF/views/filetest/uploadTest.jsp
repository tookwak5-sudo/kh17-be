<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>파일 업로드 테스트</h1>

<!--  
	파일처럼 정보가 많은 항목을 전송할 때는 기존방식이 아닌 multipart 방식으로 전송해야한다
	이 중에서 form에 담긴 데이터 형태로 전송하는 방식을 multipart/form-data라고 부른다
	고유한 칸막이가 생기고 그 안에 여러 가지의 데이터가 합쳐저서 하나의 데이터 섹터를 이룬다
	→ 기존 방식으로는 해석이 불가능하며 새로운 방식이 필요하다 // java EE에서는 직접 설정해야하고
	 
-->
<form action="./uploadTest" method="post" enctype="multipart/form-data">
	<input type="text" name="uploader"> <br><br>
	<input type="file" name="attach"> <br><br>
	<br><br>
	<button>전송</button>
</form>