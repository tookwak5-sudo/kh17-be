<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- 
	이미지(img)
	- 원하는 이미지를 화면에 원하는 크기로 출력해주는 태그  
	- 내가 가지고 있는 이미지 또는 외부에 업로드되어있는 이미지 모두 가능
	- 종료 태그가 없음
	- src(source) 속성으로 이미지의 주소를 제공해야 한다
	- widdth, hegiht로 크기 설정 가능(단위 : px), 비율(%)도 가능
-->
 
<h1>예제 4번 - 이미지</h1>

<img src="https://i.pinimg.com/originals/37/59/0f/37590f3eb78594a9afb6a28a9f294060.gif"
	width="50%">
<img src="https://i.pinimg.com/originals/51/89/e5/5189e56b9b05f2d1ec7e50a9d80967bc.gif"
	width="200px">
	
<hr>

<!-- 
	내가 가진 이미지를 출력
	- 보안상의 이슈로 하드디스크에 있는 이미지는 표시할 수 없다 (물리적 위치는 표시 불가능)
	- 프로젝트에 포함된 주소를 가지는 이미지만 가능 (static 폴더)
-->

<!-- <imge src="C:\Users\user\Downloads\lion.gif" width="200"> -->
<img src="/lion.gif" width="200">
