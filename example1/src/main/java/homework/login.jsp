<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <%
        // 1. 현재 로그인 상태인지 확인
        boolean isLoggedIn = (session.getAttribute("id") != null);

        if (isLoggedIn) {
            response.sendRedirect("main.jsp"); // 이미 로그인된 상태이면 메인 페이지로 이동
        } else {
    %>
            <h1>Login</h1>
            <form action="loginprocess.jsp" method="post">
                <label for="id">ID:</label>
                <input type="text" name="id" id="id">
                <br>
                <label for="password">Password:</label>
                <input type="password" name="password" id="password">
                <br>
                <input type="submit" value="Login">
            </form>
    <%
        }
    %>
</body>
</html>
