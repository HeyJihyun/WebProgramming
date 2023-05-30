<%@ tag body-content="scriptless" pageEncoding="euc-kr" %>
<%@ attribute name="count" type="java.lang.Integer" required="ture" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach begin="1" end="${count}">
<jsp:doBody/>
</c:forEach>
