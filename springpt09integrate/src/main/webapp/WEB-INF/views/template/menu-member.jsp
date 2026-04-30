<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- (관리자 아닌)회원일 경우 -->
<!-- 회원메뉴 -->
<!--
	<a href="/">HOME</a>
	<a href="/board/list">게시글목록</a>
	<a href="/country/list">국가정보</a>
	<a href="/lecture/list">강좌정보</a>
	<a href="/book/list">도서정보</a>
	<a href="/member/mypage">마이페이지</a>
	<a href="/member/logout">로그아웃</a> 
-->

<ul class="menu">
    <li>
        <a href="#">
            <i class="fa-solid fa-house"></i>
            <span>홈</span>
        </a>
    </li>
    <li>
        <a href="#">
            <i class="fa-solid fa-database"></i>
            <span>데이터</span>
        </a>
            <!-- 하위 메뉴 -->
            <ul>
                <li>
                    <a href="/board/list">
                        <i class="fa-solid fa-flag"></i>
                        <span>국가정보</span>
                    </a>
                </li>
                <li>
                    <a href="/lecture/list">
                        <i class="fa-solid fa-chalkboard-user"></i>
                        <span>강좌정보</span>
                    </a>
                </li>
                <li>
                    <a href="/book/list">
                        <i class="fa-solid fa-book"></i>
                        <span>도서정보</span>
                    </a>
                </li>
            </ul>
        </a>
    </li>
    <li>
        <a href="#">
            <i class="fa-solid fa-comments"></i>
            <span>게시판</span>
        </a>
    </li>
    
    <li class="divider"></li>

    <li>
        <a href="#">
            <i class="fa-solid fa-right-to-bracket"></i>
            <span>로그인</span>
        </a>
        <!-- 하위메뉴 -->
        <ul>
            <li>
                <a href="#">
                    <i class="fa-solid fa-user-plus"></i>
                    <span>회원가입</span>
                </a>
            </li>
        </ul>
    </li>
</ul>