<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/jsp/include/top.jsp" />
    <c:if test="${not empty user}">
      <script>alert("이미 로그인 되었습니다."); location.href = "main.do";</script>
    </c:if>

    <section class="loginSection">
      <form action="${ pageContext.request.contextPath }/loginProcess.do" method="post">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" name="id" value="${cookie.id.value }"
            placeholder="name@example.com">
          <label for="floatingInput">Id</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
            <label for="floatingPassword">Password</label>
          </div>

        <div class="checkbox mb-3">
          <label> <input type="checkbox" name="saveID" value="check"> Remember me
          </label>
          </div>
          <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <a href="javascript:kakaoLogin();"><img src="${ pageContext.request.contextPath }/assets/kakao_login.png" class="kakaoLogin"></a>
      </form>

    </section>
    <jsp:include page="/jsp/include/bottom.jsp" />
    </body>

    </html>