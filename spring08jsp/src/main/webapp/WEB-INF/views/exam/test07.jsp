<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <h2>유튜브 검색창</h2>
 
 <form action="https://www.youtube.com/results">
 	<input name="search_query">
	<button>move</button> 
 </form>
 
 <h2>네이버쇼핑 상품 검색창</h2>
<form action="https://search.shopping.naver.com/ns/search">
	<input name="query" placeholder="상품 이름 입력">
	<button>검색</button>
</form>

<hr>

<h2>Github 저장소 검색창</h2>

<!-- type은 입력창의 형태를 결정, value는 초기값을 결정 -->
<form action="https://github.com/search">
	<input type= "search" name="q" placeholder="저장소 이름 입력">
	<input type= "hidden" name="type" value="repositories">
	<button>검색</button>
</form>

<h2>다나와 상품 검색창</h2>
<form action="https://search.danawa.com/dsearch.php">
	<input name="k1" type="text">
	<input name= "module" value="goods" type="hidden">
	<input name="act" value="dispMain" type= "hidden" >
	<button>검색</button>
</form>

<h2>다음 검색엔진 검색창</h2>
<form action="https://search.daum.net/search">
	<input type ="text" name="q" placeholder="검색어 입력" required="required">
	<input type ="hidden" name="w" value="tot">
	<input type ="hidden" name="DA" value="YZR">
	<input type ="hidden" name="t__nil_searchbox" value="btn">
	<button>검색</button>
</form>