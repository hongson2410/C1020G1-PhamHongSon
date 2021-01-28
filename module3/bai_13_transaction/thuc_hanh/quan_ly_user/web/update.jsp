<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<p>
    <a href="/UserServlet">Back to User list</a>
</p>
<form action="/UserServlet" method="post">
    <input type="hidden" name="actionUser" value="update"/>
    <input type="hidden" name="id" value="${userInfo.id}"/>
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
    <p>
        <input type="submit" value="Save"/>
    </p>
</form>
</body>
</html>
