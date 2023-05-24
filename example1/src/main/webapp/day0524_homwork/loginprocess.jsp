<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="day0524_homework.LoginBeen" />
<jsp:setProperty name="login" property="id" />
<jsp:setProperty name="login" property="password" />
<%
if (login.dbCheck()) {
	session.setAttribute("id", login.getId());
	response.sendRedirect("main.jsp");
} else {
	response.sendRedirect("error.jsp");
}
%>