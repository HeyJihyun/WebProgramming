<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.ac.kopo.book.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 자바빈즈 + 배열
	BookVO[] book = {new BookVO()};
	book[0].setTitle("성공");
	
	pageContext.setAttribute("book1", book);
	
	//자바빈즈 + 리스트
	List<BookVO> bookList1= new ArrayList<BookVO>();
	bookList1.add(book[0]);
	
	pageContext.setAttribute("book2", bookList1);
	
	//맵 + 리스트
	Map<String, String> map = new HashMap<String, String>();
	map.put("title", "성공");
	
	List<Map<String, String>> bookList2 = new ArrayList<>();
	bookList2.add(map);
	pageContext.setAttribute("book3", bookList2);
	
	//맵 + 배열
	Map[] maps = {map};
	pageContext.setAttribute("book4", maps);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 성공 출력 --%>
	성공/실패?? ${ book1[0].title }
	<br> 성공/실패?? ${ book2[0].title }
	<br> 성공/실패?? ${ book3[0].title }
	<br> 성공/실패?? ${ book4[0].title }
	<br>
</body>
</html>