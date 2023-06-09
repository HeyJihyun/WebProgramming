<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="/jsp/include/top.jsp" />
        <c:if test="${user.grade != 'admin'}">
            <script>alert("잘못된 경로입니다."); location.href = "main.do";</script>
        </c:if>
        <section id="bookCards">
            <div class="row">
                <c:forEach var="book" items="${bookList}">
                    <div class="col-12 card mb-3">
                        <div class="card-body">
                            <h6 class="card-title">${book.b_no}</h6>
                            <h5 class="card-title">${book.title}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${book.categoryName}</h6>
                            <h6 class="card-subtitle mb-2 text-muted">${book.author} / ${book.pubDate} /
                                ${book.publisher} / ${book.itemPage}p</h6>
                            <p class="card-text">${book.description}</p>
                            <form action="${ pageContext.request.contextPath }/updateBook.do" method="post">
                                <input type="hidden" name="b_no" value="${book.b_no}">
                                총 대여수 : ${book.r_count}<br>
                                도서상태:
                                <select class="b_status" name="b_status" id="">
                                    <option value="가능" <c:if test="${book.b_status eq '가능'}">selected</c:if>>가능</option>
                                    <option value="대여중" <c:if test="${book.b_status eq '대여중'}">selected</c:if> disabled>대여중
                                    </option>
                                    <option value="훼손" <c:if test="${book.b_status eq '훼손'}">selected</c:if>>훼손</option>
                                    <option value="분실" <c:if test="${book.b_status eq '분실'}">selected</c:if>>분실</option>
                                </select>

                                <button type="submit" class="card-link">도서상태변경</button>
                                <button type="button"
                                    onclick="location.href='${ pageContext.request.contextPath }/deleteBook.do?b_no=${book.b_no}'"
                                    class="card-link">도서삭제</button>
                            </form>
                        </div>
                    </div>
            </div>
            </c:forEach>
            </div>
        </section>
        <jsp:include page="/jsp/include/bottom.jsp" />