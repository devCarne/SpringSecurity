<%@ page contentType="text/html;charset=UTF-8" language="java" %>\
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>welcome : admin</h1>
<hr>
<%--<c:if test="${not empty pageContext.request.userPrincipal}">--%>
<%--    <p> is Log-In</p>--%>
<%--</c:if>--%>

<%--<c:if test="${empty pageContext.request.userPrincipal}">--%>
<%--    <p> is log-Out</p>--%>
<%--</c:if>--%>

<sec:authorize access="isAuthenticated()">
    <p>Log-In</p>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <p>Log-Out</p>
</sec:authorize>

<%--USER ID : ${pageContext.request.userPrincipal.name} <br>--%>
USER ID : <sec:authentication property="name"/><br>

<c:url value="/logout" var="logoutUrl"/>
<a href="${logoutUrl}">Log Out</a><br>

</body>
</html>
