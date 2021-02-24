<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 2/23/2021
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${message}</h1>
<form action="/student/create" method="post">
    <input type="text" name="id">
    <input type="text" name="name">
    <input type="submit" value="Create">
</form>
</body>
</html>
