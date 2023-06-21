<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/jsp/include/top.jsp" />
    <c:if test="${not empty user}">
      <script>alert("이미 로그인 되었습니다."); location.href = "main.do";</script>
    </c:if>
    <section class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">답글</h4>
        <form class="validation-form" novalidate="" onsubmit="return submitForm()"
          action="${ pageContext.request.contextPath }/insertReBoard.do" method="post">
          <div class="row">
            <div class="mb-3">
              <label for="title">제목</label>
              <input type="text" class="form-control " id="title" name="title" required="" value="Re: ${board.title }">
              <input type="hidden" name="b_no" required="" value="${board.b_no }">
            </div>

            <div class="mb-5">
              <label for="content">내용</label>
              <textArea  class="form-control" id="content" name="content" rows="10"></textArea>
            </div>
          </div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">문의하기</button>
        </form>
      </div>
    </section>
    <jsp:include page="/jsp/include/bottom.jsp" />