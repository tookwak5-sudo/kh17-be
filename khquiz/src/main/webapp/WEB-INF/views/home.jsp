<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
    /* 메인 타이틀 영역 */
.main-title-cell {
    text-align: center;
    margin-bottom: 40px;
}
.main-title-cell h1 {
    font-size: 28px;
    color: #2c3e50;
    margin-bottom: 8px;
    font-weight: 700;
}
.main-title-cell p {
    color: #7f8c8d;
    font-size: 15px;
}

/* 메뉴를 나란히 배치할 그리드 */
.menu-grid {
    display: flex;
    justify-content: center;
    gap: 30px; /* 카드 사이의 간격 */
    max-width: 800px; /* 2개일 때는 너무 퍼지지 않게 너비 제한 */
    margin: 0 auto;
}

/* 개별 카드 스타일 */
.menu-card {
    flex: 1;
    background-color: #ffffff;
    border: 1px solid #e2e8f0;
    border-radius: 12px;
    padding: 30px 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    text-decoration: none; /* 링크 밑줄 제거 */
    color: #333333;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.02);
    transition: all 0.3s ease; /* 부드러운 애니메이션 효과 */
}

/* 카드 마우스 호버(Hover) 효과 */
.menu-card:hover {
    transform: translateY(-8px); /* 카드가 위로 슥 올라감 */
    border-color: #3498db; /* 강조 색상 브랜딩 */
    box-shadow: 0 12px 20px rgba(52, 152, 219, 0.1); /* 푸른빛 은은한 그림자 */
}

/* 아이콘 주변 상자 */
.icon-box {
    width: 60px;
    height: 60px;
    background-color: #ebf5fb;
    color: #3498db;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 24px;
    margin-bottom: 20px;
    transition: all 0.3s ease;
}

.menu-card:hover .icon-box {
    background-color: #3498db;
    color: #ffffff; /* 호버 시 아이콘 색상 반전 */
}

/* 텍스트 영역 */
.text-box h3 {
    font-size: 18px;
    margin-bottom: 10px;
    color: #2c3e50;
    font-weight: 600;
}
.text-box p {
    font-size: 13px;
    color: #94a3b8;
    line-height: 1.5;
    margin: 0;
}
    </style>

 <div class="container w-1200 mt-50 mb-50">  
    <div class="main-title-cell">
        <h1>사내 관리 시스템</h1>
        <p>원하는 업무 메뉴를 선택하세요.</p>
    </div>
    
    <div class="menu-grid">
        <!-- 부서 등록 카드 -->
        <a href="/dept/add" class="menu-card">
            <div class="icon-box">
                <i class="fa-solid fa-sitemap"></i> <!-- 부서에 더 어울리는 조직도 아이콘으로 변경 -->
            </div>
            <div class="text-box">
                <h3>부서 등록</h3>
                <p>새로운 부서를 시스템에 등록하고 조직을 구성합니다.</p>
            </div>
        </a>

        <!-- 사원 등록 카드 -->
        <a href="/emp/create" class="menu-card">
            <div class="icon-box">
                <i class="fa-solid fa-user-plus"></i>
            </div>
            <div class="text-box">
                <h3>사원 등록</h3>
                <p>신규 입사자의 인적 사항과 부서를 등록합니다.</p>
            </div>
        </a>
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>