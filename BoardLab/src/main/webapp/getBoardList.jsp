<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 목록</h1>
<hr>
<h3>${user.name }님 환영합니다. <a href="logout.do">로그아웃</a></h3>
<table border="1">
    <tr>
        <th>No.</th>
        <th>TITLE</th>
        <th>WRITER</th>
        <th>DATE</th>
        <th>hit</th>
    </tr>
    <c:forEach var="board" items="${boardList }">
        <tr>
            <td>${board.seq }</td>
            <td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
            <td>${board.writer }</td>
            <td>${board.regdate }</td>
            <td>${board.hit }</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="insertBoard.html">글쓰기</a></td>
    </tr>
</table>
<form action="searchBoard.do" method="post">
    <select name="search">
        <option value="title">제목</option>
        <option value="writer">글쓴이</option>
    </select>
    <input type="text" name="content">
    <input type="submit" value="검색">
</form>
</body>
</html>