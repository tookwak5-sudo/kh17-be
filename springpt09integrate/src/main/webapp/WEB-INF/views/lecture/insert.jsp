<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>신규 강좌 등록</h1>

<!-- <form action="/lecture/insert2"> 
  	 메소드 안적으면 get, 
  	 나중에 파일같은거를 추가할 수 있음, 주소로 파일을 보내기엔 크기가 부담스러워서 post로 보냄에 따라 제약조건들이 추가됨
 -->
<form action="./insert" method="post" enctype="multipart/form-data">
	강좌명 <input type="text" name="lectureTitle"
	 placeholder="정보처리 산업기사 필기" required> <br><br>
<!-- 	카테고리 <input type="text" name="lectureCategory" placeholder="시험" required> <br><br> -->
	카테고리 
	<select name="lectureCategory" required>
		<option value="">선택하세요</option>
		<option ${lectureDto.lectureCategory == '이론' ? 'selected' : ''}>이론</option>
		<option ${lectureDto.lectureCategory == '실습' ? 'selected' : ''}>실습</option>
		<option ${lectureDto.lectureCategory == '시험' ? 'selected' : ''}>시험</option>
	</select>
	<br><br>
	강의시간 <input type="number" name="lectureDuration" min="30" step="30" value="30" required> <br><br>
	수강료 <input type="number" name="lecturePrice" min="1000" step="1000" value="1000" required> <br><br>
<!-- 	강의형태 <input type="text" name="lectureType" placeholder="온라인/오프라인/혼합" required> <br><br> -->
	강의형태
	<select name="lectureType" required>
		<option value="">선택하세요</option>
		<option ${lectureDto.lectureType == '온라인' ? 'selected' : ''}>온라인</option>
		<option ${lectureDto.lectureType == '오프라인' ? 'selected' : ''}>오프라인</option>
		<option ${lectureDto.lectureType == '혼합' ? 'selected' : ''}>혼합</option>
	</select>
	<br><br>
	미리보기 <input type="file" name="attach" accept=".png , .jpg" multiple>
	<br><br>
	
	<button>강좌생성</button>
	 <h4><a href="./list">목록으로 이동하기</a></h4>	
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>