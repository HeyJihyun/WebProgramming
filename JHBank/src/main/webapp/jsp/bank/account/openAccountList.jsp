<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:forEach var="accountList" items="${openbankAccount}" varStatus="s">
<section id="accountList" class="container text-center">
    <div class="row" style="max-width: 700px;">
        <h4>${accountList[0].bank_cd}은행</h4>
        <div id="carouse${s.count +1}" class="carousel carousel-dark slide p-3" data-bs-ride="carouse${s.count +1}">
            <div class="carousel-indicators">
                <c:forEach var="i" begin="1" end="${fn:length(accountList)}">
                    <button type="button" data-bs-target="#carouse${s.count +1}" data-bs-slide-to="${i-1}"
                        class="<c:if test='${i == 1}'> active" aria-current="true</c:if>" aria-label="Slide ${i}"></button>
                </c:forEach>
            </div>
            <div class="carousel-inner">
                <c:forEach var="account" items="${accountList}" varStatus="status">
                    <div class="carousel-item pb-3 px-5  <c:if test='${status.count == 1}'> active</c:if>" data-bs-interval="${status.count}0000">
                        <div class="card col-12 mb-3 border-primary ">
                            <div class=" card-header text-bg-primary ">
                                <div class=" dropdown">
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
                                <form method="post">
                                    <h6 class="card-subtitle mb-2 text-muted">${account.account_no }
                                        <a tabindex="0" onclick="paste('${account.account_no }')" role="button" data-bs-toggle="popover" data-bs-trigger="focus" data-bs-content="복사가 완료되었습니다."> <small class="text-muted"><i class="bi bi-files"></i></small>
                                        </a>
                                    </h6>
                                    <h3>
                                        \
                                        <fmt:formatNumber value="${account.balance }" pattern="#,###" />
                                    </h3>
                                    <input type="hidden" name="account_no" value="${account.account_no }">
                                    <input type="hidden" name="bank_cd" value="${account.bank_cd }">
                                    <input type="hidden" name="balance" value="${account.balance }">
                                    <div class="row">
                                        <input type="submit" class="col btn btn btn-primary" value="거래내역"
                                            formaction="${ pageContext.request.contextPath }/transaction.do">
                                        <input type="submit" class="col ms-3 btn btn-warning" value="이체하기"
                                            formaction="${ pageContext.request.contextPath }/openTransferPage.do">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouse${s.count +1}" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouse${s.count +1}" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
</section>
</c:forEach>