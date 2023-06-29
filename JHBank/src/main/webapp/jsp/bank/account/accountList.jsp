<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/jsp/include/top.jsp" />
<section id="accountList" class="container text-center">
    <div class="row" style="max-width: 600px;">
        <h4>계좌 조회</h4>
        <h5>총 : <fmt:formatNumber value="${sumBalance }" pattern="#,###" /> 원</h5>
        <c:forEach var="account" items="${accountList}">
            <div class="card col-12 mb-3 border-warning">
                <div class="card-header text-bg-warning ">
                    <div class="dropdown">
                        <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false"></button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">계좌이체</a></li>
                            <li><a class="dropdown-item" href="#">계좌상세보기</a></li>
                            <li><a class="dropdown-item" href="#">해지하기</a></li>
                        </ul>
                    </div>
                    <h5 class="card-title">${account.account_nm }</h5>
                </div>
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-muted">${account.account_no }
                        <a tabindex="0" onclick="paste('${account.account_no }')" role="button" data-bs-toggle="popover" data-bs-trigger="focus" data-bs-content="복사가 완료되었습니다."> <small class="text-muted"><i class="bi bi-files"></i></small>
                        </a>
                    </h6>
                    <h3>
                        \
                        <fmt:formatNumber value="${account.balance }" pattern="#,###" />
                    </h3>
                    <form method="post">
                    <input type="hidden" name="account_id" value="${account.account_id }">
                        <div class="row">
                            <input type="submit" class="col btn btn btn-primary" value="거래내역" formaction="${ pageContext.request.contextPath }/transaction.do">
                            <c:if test="${account.deposit_cd == 1 }">
                                <input type="submit" class="col ms-3 btn btn-warning" value="이체하기" formaction="${ pageContext.request.contextPath }/transferPage.do">
                            </c:if>
                        </div>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<jsp:include page="/jsp/include/bottom.jsp" />