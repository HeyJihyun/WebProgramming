<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="/jsp/include/top.jsp" />
        <section id="bookCards">
            <article class="serchArticle">
                <form class="serchForm" action="${pageContext.request.contextPath}/serch.do" method="post">
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
            <button type="button" class="btn btn-primary mb-3"
                onclick="location.href='${pageContext.request.contextPath}/inputBook.do'">책 등록</button>
            <div class="row">
                <c:forEach var="book" items="${bookList}">
                    <div class="col-12 card mb-3">
                        <div class="card-body">
                            <img src="${book.cover}" class="card-img-left" alt="...">
                            <h5 class="card-title">${book.title}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${book.categoryName}</h6>
                            <h6 class="card-subtitle mb-2 text-muted">${book.author} / ${book.pubDate} /
                                ${book.publisher} / ${book.itemPage}p</h6>
                            <p class="card-text">${book.description}</p>
                            <c:if test="${book.count - book.ableRantalCnt == book.count}">
                                <div class="unable">대여불가
                            </c:if>
                            <c:if test="${book.count - book.ableRantalCnt < book.count }">
                                <div class="able">대여가능
                            </c:if>
                            ${book.ableRantalCnt } / ${book.count }
                            </div>
                            총 대여회수 : ${book.r_count}<br>
                            <c:if test="${user.grade == 'admin'}">
                                <a href="#" class="card-link">도서수정</a>
                            </c:if>
                        </div>
                    </div>
                    </c:forEach>
            </div>
        </section>
        <jsp:include page="/jsp/include/bottom.jsp" />