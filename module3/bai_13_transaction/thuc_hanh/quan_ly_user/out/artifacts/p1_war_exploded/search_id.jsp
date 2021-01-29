<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h2>User Info</h2>
<p>
    <a href="/UserServlet">Back to User list</a>
</p>
<p style="color: red"><c:out value="${message}"/></p>
<p>
    Name:
    <input type="text" value="${userInfo.name}" name="name">
</p>
<p>
    Email:
    <input type="text" value="${userInfo.email}" name="email">
</p>
<p>
    Country:
    <input type="text" value="${userInfo.country}" name="country">
</p>
</body>
</html>
