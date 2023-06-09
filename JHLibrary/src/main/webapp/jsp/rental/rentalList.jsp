<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test = "${empty user}">
    <script>alert("로그인 해주세요."); location.href = "login.do";</script>
    </c:if>
        <jsp:include page="/jsp/include/top.jsp" />
        <section class= "lentalList">
        <h3>대여현황</h3>
        <c:if test = "${rentalList.size() == 0}">
        <hr>
        <h5>대여한 도서가 없습니다.</h5>
        </c:if>
            <div class="row">
            <c:forEach var="rental" items="${rentalList}">
            <div class="col-3 ">
                <div class="card">
                    <img src="${rental.cover}" alt="...">
                    <div class="card-body">
                        <h5 class="card-title text-truncate">${rental.title}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${rental.author}</h6>
                        <hr>
                        <h6 class="card-subtitle mb-2 text-muted">대여일 : ${rental.rentalDate}</h6>
                        <h6 class="card-subtitle mb-2 text-muted">반납일 : ${rental.returnDate}</h6>
                        <hr>
                            <a href="${ pageContext.request.contextPath }/returnRental.do?b_no=${rental.b_no}" class="card-link">
                            <button type="button" class="btn btn-primary">반납하기</button>
                            </a>
                        <c:if test="${rental.extension == 1 }">
                            <a href="${ pageContext.request.contextPath }/extension.do?r_no=${rental.r_no}" class="card-link">
                            <button type="button" class="btn btn-primary">연장하기</button>
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>
            </c:forEach>
            </div>
        </section>
        <jsp:include page="/jsp/include/bottom.jsp" />