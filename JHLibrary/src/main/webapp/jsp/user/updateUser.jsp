<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:include page="/jsp/include/top.jsp" />
  <c:if test = "${empty user}">
  <script>alert("로그인해주세요."); location.href = "${pageContext.request.contextPath}/login.do";</script>
  </c:if>
  <section class="input-form-backgroud row">
    <div class="input-form col-md-12 mx-auto">
      <h4 class="mb-3">회원정보수정</h4>
      <form class="validation-form" id="insertUser" novalidate="" onsubmit = "return submitForm()" action="${ pageContext.request.contextPath }/updateUser.do" method="post">
        <div class="row">
          <div class="mb-3">
            <label for="text">아이디</label>
            <input type="text" class="form-control form-control-plaintext " id="id" name="id" value="${user.id }" readonly="readonly">
          </div>

          <div class="col-md-6 mb-3 ">
            <input type="hidden" class="form-control" id="password" name="password" required="" value = "${user.pwd }">
            <label for="nickname">현재 비밀번호</label>
            <input type="password" class="form-control " id="checkPassword">
            <div class="invalid-feedback ">
              비밀번호가 일치하지 않습니다.
            </div>
          </div>
          
          <div class="col-md-6 mb-3 ">
            <label for="nickname">수정할 비밀번호</label>
            <input type="password" class="form-control " name="newPassword" id="newPassword" value = "${user.pwd }">
            <div class="invalid-feedback ">
              수정할 비밀번호를 입력해 주세요.
            </div>
          </div>
        </div>


        <div class="mb-3">
          <label for="address">이름</label>
          <input type="text" class="form-control form-control-plaintext " id="name" name="name" required=""  readonly="readonly" value = "${user.name }">
        </div>

        <div class="mb-3">
          <label for="code">핸드폰 번호</label>
          <input type="tel" class="form-control" id="phone" name="phone" required="" placeholder="010-1234-5678(하이폰(-)포함)"
            pattern="([0-9]{3})-([0-9]{3,4})-([0-9]{4})$" value = "${user.phone }">
          <div class="invalid-feedback">
            핸드폰 번호를 확인해 주세요.(하이픈(-)포함)
          </div>
        </div>
        <hr class="mb-4">
        <div class="mb-4"></div>
        <button class="btn btn-primary btn-lg btn-block" type="submit">수정</button>
      </form>
    </div>
  </section>
  <jsp:include page="/jsp/include/bottom.jsp" />