<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/jsp/include/top.jsp" />
<section>
<form method = "post">
    출금계좌 : 
    <select name = "account_id">
        <c:forEach var="a" items="${accountList }">
            <c:if test="${a.deposit_cd == 1 }">
                <option value = "${a.account_id }" <c:if test="${a.account_no == account.account_no }">selected</c:if>>${a.account_no }</option>
            </c:if>
        </c:forEach>
    </select>
    <input type="submit" value = "선택" formaction="${ pageContext.request.contextPath }/transferPage.do">
    <br>
    출금 가능 금액 : <h4><fmt:formatNumber value="${account.balance }" pattern="#,###" />원 </h4>
    입금계좌 : 
    <select name = "bank_cd">
        <option value = "JH">JH은행</option>
        <option value = "SB">숲은행</option>
        <option value = "GH">건희은행</option>
        <option value = "HJ">현종은행</option>
    </select>
    <input type="hidden" name = "from_account_no" value = ${account.account_no }>
    <input type="text" name = "to_account_no">
    <input type="button" value = "조회" >
    <br>
    입금액 : 
    <input type="number" min = "1" max="${account.balance }" name = "balance">원<br>
    보내는 이 : <input type="text" name="from_nm" value = " ${user.user_name }">
    받는 이 : <input type= "text" name="to_nm">
    <input type="submit" value="이체" formaction="${ pageContext.request.contextPath }/transfer.do">
</form>
</section>
<jsp:include page="/jsp/include/bottom.jsp" />