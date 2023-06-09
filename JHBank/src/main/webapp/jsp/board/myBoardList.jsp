<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/include/top.jsp" />
<section id="board">
<!-- Modal -->
<div class="modal fade" id="insertBoard" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">문의하기</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form class="validation-form" novalidate="" onsubmit="return submitForm()"
        action="${ pageContext.request.contextPath }/insertBoard.do" method="post">
        <div class="modal-body">
          <div class="row">
            <div class="mb-3">
              <label for="title">제목</label>
              <input type="id" class="form-control " id="title" name="title" required="">
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
            </div>
          
            <div class="mb-5">
              <label for="content">내용</label>
              <textArea class="form-control" id="content" name="content" rows="10"></textArea>
            </div>
          </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button class="btn btn-primary" type="submit">문의하기</button>
          </div>
          </form>
    </div>
  </div>
</div>
<!-- /Modal -->
    <h3>문의 게시판</h3>
    <table class="table table-hover">
        <thead class="table-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col" class="title">Title</th>
                <th scope="col">Writer</th>
                <th scope="col" class="date">Date</th>
                <th scope="col" class="hit">Hit</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${boardList}">
                    <tr onclick="location.href='${pageContext.request.contextPath }/getBoard.do?b_no=${board.b_no }'">
                        <th scope="row">${board.b_no }</th>
                        <td class="title text-truncate">
                        <c:if test = "${board.level > 1 }">
                            <c:forEach var="i" begin="1" end="${board.level-1}">
                            &nbsp;&nbsp;
                            </c:forEach>
                            <i class="bi bi-arrow-return-right"></i>
                        </c:if>
                        ${board.title }
                        </td>
                        <td>${board.name }</td>
                        <td>${board.reg_date }</td>
                        <td>${board.hits }</td>
                    </tr>
            </c:forEach>

        </tbody>
    </table>
    <nav id = "paging" aria-label="Page navigation example">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#insertBoard">
          문의하기
        </button>
        <ul class="pagination">
            <li class="page-item <c:if test="${vpage == 1 }"> disabled </c:if>">
                <a class="page-link" href="${pageContext.request.contextPath }/myBoard.do?vpage=${vpage - 1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" begin="1" end="${lastPage }">
                <li class="page-item  <c:if test = "${vpage == i }" >active</c:if>"><a class="page-link" href="${pageContext.request.contextPath }/myBoard.do?vpage=${i}"> ${i} </a></li>
            </c:forEach>
            <li class="page-item <c:if test="${vpage == lastPage}"> disabled </c:if>">
                <a class="page-link" href="${pageContext.request.contextPath }/myBoard.do?vpage=${vpage + 1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>

    </nav>
</section>
<jsp:include page="/jsp/include/bottom.jsp" />