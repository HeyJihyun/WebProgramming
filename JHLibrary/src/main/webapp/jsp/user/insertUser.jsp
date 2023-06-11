<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:include page="/jsp/include/top.jsp" />
  <c:if test = "${not empty user}">
  <script>alert("이미 로그인 되었습니다."); location.href = "main.do";</script>
  </c:if>
  <section class="input-form-backgroud row">
    <div class="input-form col-md-12 mx-auto">
      <h4 class="mb-3">회원가입</h4>
      <form class="validation-form" id="insertUser" novalidate="" onsubmit = "return submitForm()" action="${ pageContext.request.contextPath }/insertUser.do" method="post">
        <div class="row">
          <div class="mb-3">
            <label for="text">아이디</label>
            <input type="id" class="form-control " id="id" name="id" required=""  onchange = "checkId()">
            <div class="invalid-feedback">
              아이디를 입력해주세요.
            </div>
          </div>

          <div class="col-md-6 mb-3">
            <label for="name">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password" required="">
            <div class="invalid-feedback">
              비밀번호를 입력해주세요.
            </div>
          </div>
          <div class="col-md-6 mb-3 ">
            <label for="nickname">비밀번호 확인</label>
            <input type="password" class="form-control " id="checkPassword">
            <div class="invalid-feedback ">
              비밀번호가 일치하지 않습니다.
            </div>
          </div>
        </div>


        <div class="mb-3">
          <label for="address">이름</label>
          <input type="text" class="form-control" id="name" name="name" required="">
          <div class="invalid-feedback">
            이름을 입력해주세요.
          </div>
        </div>

        <div class="mb-3">
          <label for="code">핸드폰 번호</label>
          <input type="tel" class="form-control" id="phone" name="phone" required="" placeholder="010-1234-5678(하이폰(-)포함)"
            pattern="([0-9]{3})-([0-9]{3,4})-([0-9]{4})$">
          <div class="invalid-feedback">
            핸드폰 번호를 확인해 주세요.(하이픈(-)포함)
          </div>
        </div>
        <hr class="mb-4">
        <div class="mb-4"></div>
        <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
      </form>
    </div>
  </section>
  <jsp:include page="/jsp/include/bottom.jsp" />