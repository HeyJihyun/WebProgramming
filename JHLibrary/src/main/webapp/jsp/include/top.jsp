<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="UTF-8">
<title>JH도서관</title>
    <link rel="icon" href="${pageContext.request.contextPath }/assets/favicon.png">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/main.js"></script>
</head>
<body>
<header>
        <div class="menu_wrap">
            <div class="first-nav">
                <h1 class="logo"><a href="${pageContext.request.contextPath }"><img src="${pageContext.request.contextPath }/assets/logo.png" alt="JH도서관"></a></h1>
                <i class="bi bi-list"></i>
                <nav>
                    <c:if test = "${empty user}">
                    <li><a href="${ pageContext.request.contextPath }/login.do">로그인</a></li>
                    <li><a href="${ pageContext.request.contextPath }/insertUserPage.do">회원가입</a></li>
                    </c:if>
                    <c:if test = "${not empty user}">
                    <li><a href="${pageContext.request.contextPath }/logout.do">로그아웃</a></li>
                    </c:if>
                </nav>
            </div>
            <hr>
            <div class="second-nav">
                <nav>
                    <li>
                        <a href="#">JH도서관</a>
                        <nav class="sub-menu">
                    <li><a href="#">인사말</a></li>
                    <li><a href="#">도서관 소개</a></li>
                </nav>
                </li>
                <li>
                    <a href="#">도서정보</a>
                    <nav class="sub-menu">
                <li><a href="${pageContext.request.contextPath }/getBookList.do">도서검색</a></li>
                <li><a href="${pageContext.request.contextPath }/getBookList.do?sort=pubdate desc">신간도서</a></li>
                <li><a href="${pageContext.request.contextPath }/getBookList.do?sort=r_total desc">인기도서</a></li>
                </nav>
                </li>
                <li>
                    <a href="#">도서관이용</a>
                    <nav class="sub-menu">
                    <c:if test = "${empty user}">
                    <li><a href="${pageContext.request.contextPath }/login.do">로그인</a></li>
                    <li><a href="${ pageContext.request.contextPath }/insertUserPage.do">회원가입</a></li>
                    </c:if>
                    <li><a href="#">도서대출</a></li>
                </nav>
                </li>
                <li>
                    <a href="#">신청 및 예약</a>
                    <nav class="sub-menu">
                <li><a href="#">희망도서신청</a></li>
                </nav>
                </li>
                <li>
                    <c:if test = "${user.grade == 'user'  or empty user}">
                    <a href="#">내서재</a>
                    <nav class="sub-menu">
                        <li><a href="${ pageContext.request.contextPath }/updateUserPage.do">회원정보수정</a></li>
                        <li><a href="${ pageContext.request.contextPath }/rentalList.do">대출현황</a></li>
                        <li><a href="#">도서예약</a></li>
                        <li><a href="#">내 문의</a></li>
                    </nav>
                    </c:if>
                    <c:if test = "${user.grade == 'admin'}">
                    <a href="#">도서관관리</a>
                    <nav class="sub-menu">
                        <li><a href="${ pageContext.request.contextPath }/updateUserPage.do">회원정보수정</a></li>
                        <li><a href="${ pageContext.request.contextPath }/getUserList.do">회원관리</a></li>
                        <li><a href="${pageContext.request.contextPath }/getBookList.do">도서관리</a></li>
                        <li><a href="#">공지관리</a></li>
                    </nav>
                    </c:if>
                </li>
                </nav>
            </div>
            <hr>
            <div class="sub_bg"></div>
        </div>
        <!-- 모바일 버전 메뉴 -->
        <div class="mobileMenu">
            <nav class="m-top">
                 <c:if test = "${empty user}">
                    <a href="${pageContext.request.contextPath }/login.do"><li><i class="bi bi-lock-fill"></i> 로그인</li></a>
                    <a href="${ pageContext.request.contextPath }/insertUserPage.do"><li><i class="bi bi-person-fill"></i> 회원가입</li></a>
                 </c:if>
                 <c:if test = "${not empty user}">
                    <li><a href="#">${ user.name }님의 서재</a></li>
                    <li><a href="${pageContext.request.contextPath }/logout.do">로그아웃</a></li>
                 </c:if>
                <li><i class="bi bi-x-lg"></i></li>
            </nav>
            <nav class="m-bottom">
                <h3>JH도서관</h3>
                <a href="#">
                    <li>인사말</li>
                </a>
                <a href="#">
                    <li>도서관 소개</li>
                </a>
                <h3>도서정보</h3>
                <a href="${pageContext.request.contextPath }/getBookList.do">
                    <li>도서검색</li>
                </a>
                <a href="#">
                    <li>신간도서</li>
                </a>
                <a href="#">
                    <li>인기도서</li>
                </a>
                <h3>도서관이용</h3>
                <c:if test = "${empty user}">
                <a href="#">
                    <li>로그인</li>
                </a>
                <a href="${ pageContext.request.contextPath }/insertUserPage.do">
                    <li>회원가입</li>
                </a>
                </c:if>
                <a href="#">
                    <li>도서대출</li>
                </a>
                <h3>신청 및 예약</h3>
                <a href="#">
                    <li>희망도서신청</li>
                </a>
                <c:if test = "${user.grade == 'user' or empty user}">
                <h3>내서재</h3>
                <a href="${ pageContext.request.contextPath }/updateUserPage.do">
                    <li>회원정보수정</li>
                </a>
                <a href="${ pageContext.request.contextPath }/rentalList.do">
                    <li>대출현황</li>
                </a>
                <a href="#">
                    <li>관심도서</li>
                </a>
                <a href="#">
                    <li>내 문의</li>
                </a>
                </c:if>
                <c:if test = "${user.grade == 'admin'}">
                <h3>도서관관리</h3>
                <a href="${ pageContext.request.contextPath }/updateUserPage.do">
                    <li>회원정보수정</li>
                </a>
                <a href="${ pageContext.request.contextPath }/getUserList.do">
                    <li>회원관리</li>
                </a>
                <a href="${pageContext.request.contextPath }/getBookList.do">
                    <li>도서관리</li>
                </a>
                <a href="#">
                    <li>공지관리</li>
                </a>
                </c:if>
            </nav>
    </header>