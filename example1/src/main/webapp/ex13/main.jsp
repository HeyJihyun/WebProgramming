<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:out value="hello Wrold!!" />
	<c:set var="price" scope="page" value="1000" />
	${price}
	<c:if test="${price > 500}">
		<c:out value="biggest!!!" />
	</c:if>

	<c:choose>
		<c:when test="${price < 1000}">
			<c:out value="Low" />
		</c:when>
		<c:when test="${price > 1000}">
			<c:out value="bic" />
		</c:when>
		<c:otherwise>
			<c:out value="other" />
		</c:otherwise>
	</c:choose>
	<c:remove var="price" />
</body>
</html>