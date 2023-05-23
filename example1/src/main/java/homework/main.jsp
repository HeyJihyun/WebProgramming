<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Service Page</title>
</head>
<body>
    <h1>Main Service</h1>
    <p>환영! <%= session.getAttribute("id") %>!</p>
    <a href="logout.jsp">Logout</a>
</body>
</html>
