<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>상세 글보기</h1>
    <hr>
    <form action="updateBoard.do" method="post">
        <table border="1">
            <tr>
                <th>번호</th>
                <td><input type="text" name="seq" readonly="readonly" value="${board.seq }"></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value=" ${board.title }"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${board.writer }</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td>${board.regdate }</td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
            </tr>
            <c:if test="${user.name eq board.writer }">
                <tr>
                    <td><input type="hidden" name="hit" value="${board.hit }"> 
                    <input type="submit" value="수정"> 
                    <input type="button" onclick="location.href='deleteBoard.do?seq=${board.seq}'" value="삭제">
                    </td>
                </tr>
            </c:if>
        </table>
    </form>
    <c:if test="${user.role ==  'Admin'}">
        <a href="deleteBoard.do?seq=${board.seq}">삭제하기</a>
    </c:if>
    <a href="getBoardList.do">글목록으로 가기</a>

</body>
</html>