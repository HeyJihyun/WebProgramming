<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/include/top.jsp"/>
    <section class="banner">
        <img src="/JHLibrary/assets/banner.png" alt="도서관 배너">
        <div class="notice"></div>
    </section>
    <section class="contents">
        <article class="serchArticle">
            <form class="serchForm" action="" method="post">
                <select name="search_item" id="">
                    <option value="" selected>제목</option>
                    <option value="">저자</option>
                    <option value="">출판사</option>
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
                            <td>공지사항 제목 1</td>
                            <td>2023.06.01</td>
                        </tr>
                    </a>
                    <tr>
                        <a href="">
                            <td>공지사항 제목 2</td>
                            <td>2023.06.01</td>
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
            <a href="">더 보기</a>
            <div class="row content1">
                <div class="col-xl-3 col-md-6 col-sm-12">
                    <div class="card">
                        <img src="https://las.sejong.go.kr/khub/resources/images/2023-05-03/9788950910921" class="card-img-top"
                            alt="...">
                        <div class="card-body">
                            <b>책 제목</b><br>
                            저자
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-sm-12">
                    <div class="card">
                        <img src="https://las.sejong.go.kr/khub/resources/images/2023-05-03/9788950910921" class="card-img-top"
                            alt="...">
                        <div class="card-body">
                            <b>책 제목</b><br>
                            저자
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-sm-12">
                    <div class="card">
                        <img src="https://las.sejong.go.kr/khub/resources/images/2023-05-03/9788950910921" class="card-img-top"
                            alt="...">
                        <div class="card-body">
                            <b>책 제목</b><br>
                            저자
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-sm-12">
                    <div class="card">
                        <img src="https://las.sejong.go.kr/khub/resources/images/2023-05-03/9788950910921" class="card-img-top"
                            alt="...">
                        <div class="card-body">
                            <b>책 제목</b><br>
                            저자
                        </div>
                    </div>
                </div>
            </div>
        </article>
    </section>
    <jsp:include page="/jsp/include/bottom.jsp"/>