<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/jsp/include/top.jsp" />
<section id = "transferPage">
<h4>계좌이체</h4>
<hr>
<form method = "post"  class="row g-3 needs-validation" novalidate>
    <label for="staticEmail" class="col-sm-3 col-form-label">출금계좌 </label>
    <div class = "col-sm-9">
    <select class="form-select" name = "account_id" onchange="this.form.submit()">
        <c:forEach var="a" items="${accountList }">
                <option value = "${a.account_id }" <c:if test="${a.account_no == account.account_no }">selected</c:if>>${a.account_no }</option>
        </c:forEach>
    </select>
    </div>
    
    <label for="staticEmail" class="col-sm-3 col-form-label">출금 가능 금액</label>
    <div class = "col-sm-9">
    <h4><fmt:formatNumber value="${account.balance }" pattern="#,###" />원 </h4>
    </div>
    
    <input type="hidden" name = "from_account_no" value = ${account.account_no }>
    <input type="hidden" name = "from_bank_cd" value = ${account.bank_cd }>
    
    <label for="staticEmail" class="col-sm-3 col-form-label">입금계좌</label>
    <div class = "col-sm-9">
    <div class="row">
    <div class = "col-sm-5">
    <select id="bank_cd" name = "to_bank_cd" class="form-select" onchange="checkAccount()">
        <option value = "JH">JH은행</option>
        <option value = "0758">숲은행</option>
        <option value = "BGH">건희은행</option>
        <option value = "H.J">현종은행</option>
    </select>
    </div>
    <div class = "col-sm-7">
    <input onkeyup="checkAccount()" class="form-control" id="account_no" type="text" name = "to_account_no" required>
    <div class="invalid-feedback">
      입금 계좌를 확인해 주세요.
    </div>
    </div>
    <div id="result"></div>
    </div>
    </div>
    
    <label for="staticEmail" class="col-sm-3 col-form-label">입금액</label>
    <div class="col-sm-9">
    <div class="input-group">
    <span class="input-group-text">\</span>
    <input class="form-control" type="number" min = "1" max="${account.balance }" name = "balance" required>
    <div class="invalid-feedback">
      입금액을 입력해주세요.
    </div>
    </div>
    </div>
    
    <label for="staticEmail" class="col-sm-3 col-form-label">보내는이</label>
    <div class = "col-sm-9">
    <input class="form-control" type="text" name="from_nm" value = "${user.user_name }" required>
    </div>
    
    <label for="" class="col-sm-3 col-form-label">받는이</label>
    <div class = "col-sm-9">
    <input id="to_nm" class="form-control" type= "text" name="to_nm" required>
    <div class="invalid-feedback">
      받는사람 이름을 확인해주세요.
    </div>
    </div>
    <input class="btn btn-primary" type="submit" value="이체" formaction="${ pageContext.request.contextPath }/transfer.do">
</form>
</section>
<jsp:include page="/jsp/include/bottom.jsp" />

<script>
//Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
</script>