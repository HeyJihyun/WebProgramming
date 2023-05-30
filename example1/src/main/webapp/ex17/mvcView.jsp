<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="login" class="ex17.ModelBeans" scope="session"/>
<center>
<jsp:getProperty property="id" name="login"/>님 환영합니다.
</center>
</body>
</html>