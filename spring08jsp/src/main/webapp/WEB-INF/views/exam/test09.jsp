<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1> 파리 올림픽 참여 국가 순위</h1>

<table border="1" width="300">
	<thead>
		<tr>
			<th>순위</th>
			<th>국가</th>
			<th>금메달</th>
			<th>은메달</th>
			<th>동메달</th>
			<th>총 메달</th>
		</tr>
	</thead>
	<tbody  align="center">
		<tr>
			<td>1</td>
			<td>미국</td>
			<td>40</td>
            <td>44</td>
            <td>43</td>
			<td><%= 40 + 44 + 43 %></td>
		</tr>
		<tr>
			<td>2</td>
			<td>중국</td>
			<td>40</td>
			<td>27</td>
			<td>24</td>
			<td>91</td>
		</tr>
		<tr>
			<td>3</td>
			<td>일본</td>
			<td>20</td>
			<td>12</td>
			<td>13</td>
			<td>45</td>
		</tr>
	</tbody>
</table>

<hr>
	<h1> 파리 올림픽 참여 국가 순위</h1>

<table border="1" width="300px">
	<thead>
		<tr>
			<!--2줄에 걸쳐 위치하도록 설정 -->
			<th rowspan="2">순위</th>
			<th rowspan="2">국가</th>
			<th colspan="4">메달현황</th>
		</tr>
		<tr>
			<th>금</th>
			<th>은</th>
			<th>동</th>
			<th>계</th>
		</tr>
	</thead>
	<tbody  align="center">
		<tr>
			<td>1</td>
			<td>미국</td>
			<td>${gold}</td>
            <td>${silver}</td>
            <td>${bronze}</td>
			<td><strong>${gold + silver + bronze}</strong></td>
		</tr>
		<tr>
			<td>2</td>
			<td>중국</td>
			<td>40</td>
			<td>27</td>
			<td>24</td>
			<td>91</td>
		</tr>
		<tr>
			<td>3</td>
			<td>일본</td>
			<td>20</td>
			<td>12</td>
			<td>13</td>
			<td>45</td>
		</tr>
	</tbody>
</table>
<hr>

<h1> 메뉴판</h1>

<table border="1" width="70%">
	<thead>
		<tr>
			<th>카테고리</th>
			<th>메뉴명</th>
			<th>판매가</th>
			<th>행사여부</th>
		</tr>
	</thead>
	<tbody  align="center">
		<tr>
			<td>음료</td>
			<td>아메리카노</td>
			<td>2,500</td>
			<td>행사중</td>
		</tr>
		<tr>
			<td>음료</td>
			<td>고구마라떼</td>
			<td>3000</td>
			<td>-</td>
		</tr>
		<tr>
			<td>디저트</td>
			<td>티라미수</td>
			<td>4000</td>
			<td>행사중</td>
		</tr>
		<tr>
			<td>디저트</td>
			<td>마카롱</td>
			<td>2000</td>
			<td>-</td>
		</tr>
	</tbody>
</table>

<hr>

<h1> 배송물품</h1>

<table border="1" width="500px">
	<thead>
		<tr>
			<th>상품명</th>
			<th>분류</th>
			<th>가격</th>
			<th>재고</th>
			<th>할인율</th>
			<th>새벽배송여부</th>
		</tr>
	</thead>
	<tbody  align="center">
		<tr>
			<td>비김면</td>
			<td>라면	</td>
			<td>16,800</td>
			<td>2</td>
			<td>0</td>
			<td>Y</td>
		</tr>
		<tr>
			<td>크림대빵</td>
			<td>제과</td>
			<td>6,500</td>
			<td>2</td>
			<td>0</td>
			<td>N</td>
		</tr>
		<tr>
			<td>점보도시락</td>
			<td>라면</td>
			<td>8,500</td>
			<td>2</td>
			<td>5</td>
			<td>Y</td>
		</tr>
		<tr>
			<td>공간춘</td>
			<td>라면</td>
			<td>12,300</td>
			<td>3</td>
			<td>20</td>
			<td>N</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td align="right" colspan="6">
<!-- 			  총 4개 중 1-4번 상품 -->
				1-4 of 4
			</td>
		</tr>
	</tfoot>
</table>