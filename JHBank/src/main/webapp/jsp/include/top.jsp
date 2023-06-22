<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<title>JH Bank</title>
<link rel="icon" href="/JHBank/assets/favicon.png">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/JHBank/css/main.css">

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="/JHBank/js/main.js" defer></script>
</head>

<body>
    <header>
        <div class="menu_wrap">
            <div class="first-nav">
                <h1 class="logo">
                    <a href="/JHBank"><img src="/JHBank/assets/logo.png" alt="JH도서관"></a>
                </h1>
                <i class="bi bi-list"></i>
                <nav>
                    <c:if test="${empty user}">
                        <li><a href="/JHBank/loginPage.do">로그인</a></li>
                        <li><a href="/JHBank/joinPage.do">회원가입</a></li>
                    </c:if>
                    <c:if test="${not empty user}">
                        <li><a href="#">${ user.user_name }님</a></li>
                        <li><a href="${pageContext.request.contextPath }/logout.do">로그아웃</a></li>
                    </c:if>
                </nav>
            </div>
            <hr>
            <div class="second-nav">
                <nav>
                    <li><a href="#">JH Bank</a>
                        <nav class="sub-menu">
                            <li><a href="#">JH 은행</a></li>
                            <li><a href="#">오시는길</a></li>
                        </nav></li>
                    <li><a href="#">Product</a>
                        <nav class="sub-menu">
                            <li><a href="/JHBank/getBookList.do">상품보기</a></li>
                            <li><a href="/JHBank/getBookList.do?sort=pubdate desc">인기상품</a></li>
                        </nav></li>
                    <li><a href="#">My Account</a>
                        <nav class="sub-menu">
                            <li><a href="#">계좌개설</a></li>
                            <li><a href="#">내역조회</a></li>
                            <li><a href="#">계좌이체</a></li>
                            <li><a href="#">계좌해지</a></li>
                        </nav></li>
                    <li><a href="#">Open Banking</a>
                        <nav class="sub-menu">
                            <li><a href="#">약관동의</a></li>
                            <li><a href="#">계좌조회</a></li>
                        </nav></li>
                    <li><a href="#">My Page</a>
                        <nav class="sub-menu">
                            <li><a href="/JHBank/updateUserPage.do">회원정보수정</a></li>
                            <li><a href="/JHBank/rentalList.do">회원탈퇴</a></li>
                            <li><a href="#">내 문의</a></li>
                        </nav></li>
                </nav>
            </div>
            <hr>
            <div class="sub_bg"></div>
        </div>
        <!-- 모바일 버전 메뉴 -->
        <div class="mobileMenu">
            <nav class="m-top">

                <a href="/JHBank/loginPage.do">
                    <li><i class="bi bi-lock-fill"></i> 로그인</li>
                </a> <a href="/JHBank/joinPage.do">
                    <li><i class="bi bi-person-fill"></i> 회원가입</li>
                </a>
                <li><i class="bi bi-x-lg"></i></li>
            </nav>
            <nav class="m-bottom">
                <h3>JH Bank</h3>
                <a href="#">
                    <li>Jh 은행</li>
                </a> <a href="#">
                    <li>오시는길</li>
                </a>

                <h3>Product</h3>
                <a href="/JHBank/getBookList.do">
                    <li>상품보기</li>
                </a> <a href="#">
                    <li>인기상품</li>
                </a>

                <h3>My Account</h3>
                <a href="#">
                    <li>계좌개설</li>
                </a> <a href="/JHBank/insertUserPage.do">
                    <li>내역조회</li>
                </a> <a href="#">
                    <li>계좌이체</li>
                </a> <a href="#">
                    <li>계좌해지</li>
                </a>

                <h3>Open Banking</h3>
                <a href="#">
                    <li>약관동의</li>
                </a> <a href="#">
                    <li>계좌조회</li>
                </a>

                <h3>My Page</h3>
                <a href="/JHBank/updateUserPage.do">
                    <li>회원정보수정</li>
                </a> <a href="/JHBank/rentalList.do">
                    <li>회원탈퇴</li>
                </a> <a href="#">
                    <li>내 문의</li>
                </a>
            </nav>
    </header>