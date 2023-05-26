<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
String requestid = (String)request.getAttribute("id");
String sessionid = (String)session.getAttribute("id");
String applicationid = (String)application.getAttribute("id");
%>
	request :
	<%= requestid %>
	<br> session :
	<%= sessionid %>
	<br> application :
	<%= applicationid %>
	<br>
</body>
</html>