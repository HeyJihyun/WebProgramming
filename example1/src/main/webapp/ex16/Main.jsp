<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="http://myTag.com" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>tag 예제 시작</h1>
<my:simple></my:simple>
<tf:Attr count="3">
world
</tf:Attr>
<h1>tag 예제 끝</h1>
</body>
</html>