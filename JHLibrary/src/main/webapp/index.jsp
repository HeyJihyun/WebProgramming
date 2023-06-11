<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="biz.book.*" %>
<%@ page import="java.util.List" %>
<%
String sort = request.getParameter("sort");

BookDAO dao = new BookDAO();
List<BookVO> bookList = null;
bookList = dao.getBookList("pubdate desc");
request.setAttribute("bookList", bookList); /*  */
%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/include/top.jsp"/>
    <section class="banner">
        <img src="/JHLibrary/assets/banner.png" alt="도서관 배너">
        <div class="notice"></div>
    </section>
    <section class="contents">
        <article class="searchArticle">
            <form class="searchForm" action="${pageContext.request.contextPath}/searchBook.do" method="post">
                <select name="search_item" id="">
                    <option value="title" selected="">제목</option>
                    <option value="author">저자</option>
                    <option value="publisher">출판사</option>
                </select>
                <input type="text" name="search_txt" placeholder="찾으시는 검색어를 입력하세요.">
                <button type="submit">
                    <i class="bi bi-search-heart-fill"></i>
                </button>
            </form>
        </article>
        <article class="noticeArticle">
            <div class="notice1">
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">공지사항</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">자주하는 질문</a>
                    </li>
                </ul>
                <table class="table">
                    <a href="">
                        <tr>
                            <td>과제가 너무 힘들어요ㅠㅠㅠㅠㅠ</td>
                            <td>2023.06.01</td>
                        </tr>
                    </a>
                    <tr>
                        <a href="">
                            <td>공지사항 못했어여ㅠㅠㅠㅠㅠㅠ</td>
                            <td>2023.06.11</td>
                        </a>
                    </tr>
                </table>
            </div>
        </article>
        <article class="booksBanner row">
            <ul class="booksBannerNav">
                <li class="active">신간도서</li>
                <li>인기도서</li>
            </ul>
            <a href="${pageContext.request.contextPath }/getBookList.do?sort=pubdate desc">더 보기</a>
            <div class="row content1">
            <c:forEach var = "i" begin = "0" end = "3">
                <div class="col-xl-3 col-md-6 col-sm-12">
                    <div class="card">
                        <img src="${bookList.get(i).getCover()}" class="card-img-top"
                            alt="...">
                        <div class="card-body">
                            <b class="d-inline-block text-truncate">${bookList.get(i).getTitle()}</b><br>
                            <i class="d-inline-block text-truncate">${bookList.get(i).getAuthor()}</i>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </div>
        </article>
    </section>
    <jsp:include page="/jsp/include/bottom.jsp"/>