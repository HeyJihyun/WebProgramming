<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/jsp/include/top.jsp" />
    <c:if test="${empty user}">
      <script>alert("로그인 해주세요."); location.href = "loginPage.do";</script>
    </c:if>
    <section class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">계좌 생성</h4>
        <form class="validation-form" id="createAccount" novalidate="" onsubmit="return submitForm()"
          action="${ pageContext.request.contextPath }/insertAccount.do" method="post">
          <div class="row">
            <div class="mb-3">
              <label for="text">계좌번호</label>
              <input type="hidden" class="form-control " name="deposit_cd" value = "${deposit.deposit_cd }">
              <input type="hidden" class="form-control " name="d_period" value = "${deposit.d_period }">
              <input type="text" class="form-control " name="account_no" value = "${account_no }" readonly="readonly">
            </div>
            <div class="mb-3">
              <label for="text">계좌이름</label>
              <input type="text" class="form-control " id="id" name="account_nm" required="" value="${deposit.d_nm}">
              <div class="invalid-feedback">
                계좌이름을 적어주세요.
              </div>
            </div>

            <div class="col-md-6 mb-3">
              <label for="name">비밀번호</label>
              <input type="password" class="form-control" id="password" name="account_pwd" required="" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" minlength="4" maxlength='4'>
              <div class="invalid-feedback">
                비밀번호(4자리 숫자)를 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-3 ">
              <label for="nickname">비밀번호 확인</label>
              <input type="password" class="form-control " id="checkPassword" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')" minlength="4" maxlength='4'>
              <div class="invalid-feedback ">
                비밀번호가 일치하지 않습니다.
              </div>
            </div>
          </div>

          <div class="mb-3">
            <label for="address">입금액</label>
            <input type="number" class="form-control" id="balance" name="balance" required="" min = "1000" value="1000">
            <div class="invalid-feedback">
              최소 입금액은 1,000원입니다.
            </div>
          </div>

          <hr class="mb-4">
          <div class="mb-4 col-md-12"></div>
          <label><input type="checkbox">계좌 약관 동의</label> <br>
          <button class="btn btn-primary btn-lg btn-block" type="submit">계좌생성</button>
        </form>
      </div>
    </section>
    <jsp:include page="/jsp/include/bottom.jsp" />