<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	Map<String, String> map = new HashMap<>();
	map.put("1", "a");
	map.put("2", "b");
	map.put("3", "c");
	pageContext.setAttribute("map", map);
	String a = map.get("1");
	%>
	���ڿ� : ${"test"}
	<br> ���ڿ� : ${'test'}
	<br> ���� : ${20}
	<br> �ε��Ҽ��� : ${3.14}
	<br> Boolean : ${true}
	<br> null : ${null}
	<br> ${map["1"]}
	<br> map[1] :
	<%= a %>
	<br> ${10 + 20 }
	<br> ${100/20 }
	<br> ${5%2 }
	<br> ${3/5 }
</body>
</html>