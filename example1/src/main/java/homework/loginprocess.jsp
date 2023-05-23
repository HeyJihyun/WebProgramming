<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // 1. 넘겨받은 id, pw로 로그인 가능 여부 확인
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    // 2. 고정된 id, pw 1개만 확인 (예시로 "admin"이라는 값으로 설정)
    if (id.equals("admin") && password.equals("admin")) {
        // 3. 등록된 사용자면 메인 서비스 페이지로 이동
        session.setAttribute("id", id);
        response.sendRedirect("main.jsp");
    } else {
        // 3. 등록되지 않은 사용자면 error 페이지로 이동
        response.sendRedirect("error.jsp");
    }
%>
