<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="/jsp/include/top.jsp" />
        <section id="bookCards">
            <c:forEach var="book" items="${bookList}">
                <div class="row">
                    <div class="col card mb-3" style="width: 18rem;">
                        <div class="card-body">
                            <img src="${book.cover}" class="card-img-left" alt="...">
                            <h5 class="card-title">Card title</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of
                                the
                                card's content.</p>
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </section>
        <jsp:include page="/jsp/include/bottom.jsp" />