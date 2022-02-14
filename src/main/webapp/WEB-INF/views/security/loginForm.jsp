<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login Form</h1>
<hr>

<c:url value="j_spring_security_check" var="loginUrl"/>
<form action="${loginUrl}" method="post">
    <c:if test="${param.error != null}">
        <p>
            login Error! <br>
            ${error_message}
        </p>
    </c:if>
    ID : <input type="text" name="j_username" value="${username}"><br>
    PW : <input type="text" name="j_password"><br>
    <input type="submit" value="LOGIN">
</form>
</body>
</html>
