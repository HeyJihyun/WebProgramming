<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/jsp/include/top.jsp" />
<section id = "transaction">
<table class="table">
  <thead>
    <tr>
      <th scope="col">거래일</th>
      <th scope="col">은행</th>
      <th scope="col">계좌번호</th>
      <th scope="col">거래처명</th>
      <th scope="col">입금액</th>
      <th scope="col">출금액</th>
      <th scope="col">잔액</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="history" items="${historyList}">
    <tr>
      <td><fmt:formatDate value="${history.h_datetime}" pattern="MM-dd" /></td>
      <td>${history.from_bank_cd }</td>
      <td>${history.from_account_no }</td>
      <td>${history.to_nm }</td>
      <td style="color: blue;"><c:if test = "${history.h_class eq '2' }">
      <fmt:formatNumber value="${history.h_mount}" pattern="#,###" />
      </c:if></td>
      <td style="color: red;"><c:if test = "${history.h_class == '1' }">
      -<fmt:formatNumber value="${history.h_mount}" pattern="#,###" />
      </c:if></td>
      <td><fmt:formatNumber value="${history.h_balance }" pattern="#,###" /></td>
    </tr>
  </c:forEach>

  </tbody>
</table>
</section>
<jsp:include page="/jsp/include/bottom.jsp" />