<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/include/top.jsp" />
<section>
<table class="table">
  <tbody>
    <tr>
      <th scope="row">${board.b_no }</th>
      <td>${board.title }</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>${board.content }</td>
    </tr>
  </tbody>
</table>
</section>
<jsp:include page="/jsp/include/bottom.jsp" />