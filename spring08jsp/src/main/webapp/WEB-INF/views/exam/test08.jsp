<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	테이블(table)
	- 줄과 칸으로 이루어진 다량의 데이터를 간격을 맞춰 출력하는 도구
	- 다양한 태그들을 조합해서 구현
	-<table> : 표(테이블) 전체 영역
		-<thead> : 테이블 헤더, 제목을 표시할 때 사용
		-<tbody> : 테이블 바디, 데이터를 표시할 때 사용
		-<tfoot> : 테이블 푸터, 기타 정보들을 표시할 때 사용
		
		-<tr> : table row, 줄
		-<th> : table header, 칸 (제목용), 굵은 글씨에 가운데 정렬
		-<td> : table date, 칸 (데이터용), 일반 글씨에 왼쪽 정렬(align 속성으로 변경 가능)
-->

<h1 align="center">표(table) 만들기</h1>

<table border="1" width="300" align="center">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>지역</th>
		</tr>
	</thead>
	<tbody  align="center">
		<tr>
			<td>1</td>
			<td>피츄</td>
			<td>남</td>
			<td>서울 강남구</td>
		</tr>
		<tr>
			<td>2</td>
			<td>라이카</td>
			<td>남</td>
			<td>미국 워싱턴</td>
		</tr>
	</tbody>
</table>