<%@ page contentType="text/html;charset=UTF-8" language="java" %>\
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>welcome : admin</h1>
<hr>

<c:if test="${not empty pageContext.request.userPrincipal}">
    <p> is Log-In</p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal}">
    <p> is log-Out</p>
</c:if>

USER ID : ${pageContext.request.userPrincipal.name} <br>
<a href="/logout">Log Out</a><br>

</body>
</html>
