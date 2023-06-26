<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/include/top.jsp" />
<section id="deposit">
    <div class="row">
    <c:forEach var = "deposit" items= "${depositList }">
    <div class="card col-md-4 mb-3 ms-3" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">${deposit.d_nm }</h5>
    <h6 class="card-subtitle mb-2 text-muted">이자율 : ${deposit.d_interest }%</h6>
    <p class="card-text">${deposit.d_detail }</p>
    <a href="${pageContext.request.contextPath }/createAccount.do?deposit_cd=${deposit.deposit_cd}" class="card-link btn btn-primary">개설하기</a>
  </div>
</div>
    </c:forEach>
    </div>
</section>
<jsp:include page="/jsp/include/bottom.jsp" />