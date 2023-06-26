<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/include/top.jsp" />
<div class="main">
    <div>
        <h3>모두가 부자되는 JH 은행</h3>
        <p>
            모두가 부자되는 JH 은행입니다. <br> 반가워요
        </p>
        <div>
            <div class="img img1"></div>
            <b>계좌조회</b>
        </div>
        <div>
            <div class="img img2"></div>
            <b>오픈뱅킹</b>
        </div>
        <div>
            <a href="${pageContext.request.contextPath }/getBoardList.do">
                <div class="img img3"></div>
            </a>
             <b>문의게시판</b>
        </div>
        <div>
        <a href="${pageContext.request.contextPath }/productList.do">
            <div class="img img4"></div>
        </a>
            <b>적금개설</b>
        </div>
    </div>
</div>
<jsp:include page="/jsp/include/bottom.jsp" />