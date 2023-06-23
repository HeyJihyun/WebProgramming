<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/include/top.jsp" />
<section id = "getBoard" class="input-form-backgroud row">
    <div class="input-form col-md-12 mx-auto">
        <form class="validation-form" novalidate="" onsubmit="return submitForm()" action="${ pageContext.request.contextPath }/reBoard.do" method="post">
            <input type="text" class="form-control form-control-plaintext " id="title" name="title" required="" value="${board.title }" readonly>
            <input type="hidden" name="b_no" value="${board.b_no }" readonly>
            <div class="row">
                <div class="mb-3 col-md-6">
                    <input type="text" class="form-control form-control-plaintext " name="title" required="" value="작성자이름" readonly>
                </div>
                <div class="mb-3 col-md-6">
                    <input type="text" class="form-control form-control-plaintext " name="title" required="" value="${board.reg_date }" readonly>
                </div>

                <div class="mb-5">
                    <label for="content">문의내용</label>
                    <textArea class="form-control form-control-plaintext " id="content" name="content" rows="10" readonly>${board.content }</textArea>
                </div>
            </div>                   
            <button class="btn btn-primary btn-lg btn-block" type="submit">답글</button>
            <c:if test = "${user.user_id == board.user_id || user.role_cd == 'M1' }">
            <button class="btn btn-primary btn-lg btn-block" type="button">수정</button>
            <button class="btn btn-primary btn-lg btn-block" type="button">삭제</button>
            </c:if>
        </form>
    </div>
</section>
<jsp:include page="/jsp/include/bottom.jsp" />