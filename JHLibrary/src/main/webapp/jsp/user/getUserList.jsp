<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="/jsp/include/top.jsp" />
        <c:if test="${user.grade != 'admin'}">
            <script>alert("잘못된 접근입니다."); location.href = "main.do";</script>
        </c:if>
        <section id="userTable">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Grade</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <th scope="row">${user.id}</th>
                            <td>${user.name}</td>
                            <td>${user.phone}</td>
                            <td>${user.grade}</td>
                            <td>
                            <c:if test = "${user.grade == 'user' }">
                            <a href = "${pageContext.request.contextPath }/updateGrade.do?id=${user.id}"><input type="button" value="관리자로 임명"> </a>
                            </c:if>
                            <a href = "${pageContext.request.contextPath }/deleteUser.do?id=${user.id}"><input type="button" value="탈퇴"> </a>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
        <jsp:include page="/jsp/include/bottom.jsp" />