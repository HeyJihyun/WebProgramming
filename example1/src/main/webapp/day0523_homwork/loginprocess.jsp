<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    if (id.equals("admin") && password.equals("admin")) {
        session.setAttribute("id", id);
        response.sendRedirect("main.jsp");
    } else
        response.sendRedirect("error.jsp");
%>
