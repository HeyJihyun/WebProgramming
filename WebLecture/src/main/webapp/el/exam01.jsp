<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- http://localhost:808/WebLecture/el/exam01.jsp?name=hong 입력시 hong 출력 --%>

	이름 :
	<%= request.getParameter("name") %><br> 이름 : ${ param.name}
	<br> ID : ${ param.id }
	<br>
</body>
</html>