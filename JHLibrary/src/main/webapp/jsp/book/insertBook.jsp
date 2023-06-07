<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/jsp/include/top.jsp" />
    <c:if test = "${user.grade != 'admin'}">
    <script>alert("잘못된 접근입니다."); location.href = "main.do";</script>
    </c:if>
    <section class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">도서등록</h4>
        <form class="validation-form inserBook" id="insertUser" novalidate="" onsubmit="return bookSubmitCheck()"
          action="${ pageContext.request.contextPath }/insertBook.do" method="post">
          <div class="row">
            <div class="mb-3">
              <label for="text">ISBN13</label>
              <input type="id" class="form-control <c:if test='${not empty error }'>is-invalid</c:if>" id="isbn"
                name="isbn" required="" onchange="inputBook()" placeholder="ISBN(13자리)" value="${bookInfo.isbn13 }">
              <div class="invalid-feedback">
                <c:if test='${not empty error }'>
                  ISBN(13자리)이 올바른지 확인해주세요.
                </c:if>
                <c:if test='${empty error }'>
                  ISBN(13자리)을 입력해주세요
                </c:if>
              </div>
            </div>
            <div class="mb-3">
              <label for="text">제목</label>
              <input type="text" class="form-control " id="title" name="title" value="${bookInfo.title }" readonly>
            </div>

            <div class="col-md-6 mb-3 cover">
              <input type="hidden" id="cover" name="cover" value="${bookInfo.cover }" readonly>
              <img src="${bookInfo.cover }" alt="책 표지">
            </div>
            <div class="col-md-6 mb-3">
              <label for="nickname">저자</label>
              <input type="text" class="form-control " id="author" name="author" value="${bookInfo.author }" readonly>
              <label for="address">출간일</label>
              <input type="text" class="form-control" id="pubDate" name="pubDate" value="${bookInfo.pubDate }" readonly>
              <label for="code">출판사</label>
              <input type="text" class="form-control" id="publisher" name="publisher" value="${bookInfo.publisher }"
                readonly>
              <label for="code">카테고리</label>
              <input type="text" class="form-control" id="categoryName" name="categoryName"
                value="${bookInfo.categoryName }" readonly>
              <label for="code">페이지수</label>
              <input type="text" class="form-control" id="itemPage" name="itemPage" value="${bookInfo.itemPage }"
                readonly>
            </div>

            <div class="mb-3">
              <label for="description" class="form-label">책 설명</label>
              <textarea class="form-control" id="description" name="description" rows="3"
                readonly>${bookInfo.description }</textarea>
            </div>

          </div>
          <hr class="mb-4">
          <div class="mb-4 col-md-12"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">도서등록</button>
        </form>
      </div>
    </section>


    <jsp:include page="/jsp/include/bottom.jsp" />