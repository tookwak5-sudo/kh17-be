<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리창</title>
    <link rel="stylesheet" href="../css/commons.css" type="text/css">

    <!-- 아이콘-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">

    <!-- 디자인을 작성하기 위한 영역-->
    <style>
    </style>

</head>
 <form action="./add" autocomplete="off" method="post" class="form-check">
	 <div class="container w-1200 mt-50 mb-50"> 
	 	<div class="cell center">
	 		<h1>신규 부서 등록</h1>
	 	</div>
	 	<div>
	 		<label>부서코드<i class="fa-solid fa-asterisk red"></i></label>
	 		<input type="number" inputmode="numeric" name="deptId" required> 
	 	</div>
	 	<div>부서명
	 		<input type="text" name="deptName" required> 
	 	</div>
	 	<div class="cell">
	 		<label>사용여부</label>
	    <input type="checkbox" name="deptUseYn" value="Y">
		</div>
		
		<button type="submit">등록</button>
	 </div>
</form>