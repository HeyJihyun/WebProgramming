<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Service Page</title>
</head>
<body>
	<%
// 1. 현재 로그인 상태인지 확인
boolean isLoggedIn = (session.getAttribute("id") != null);

if (!isLoggedIn) {
    response.sendRedirect("login.jsp"); // 로그인 상태가 아니면 login페이지로 이동
}
%>
	<h1>Main Service</h1>
	<p>
		환영!
		<%= session.getAttribute("id") %>!
	</p>
	<a href="logout.jsp">Logout</a>
</body>
</html>
