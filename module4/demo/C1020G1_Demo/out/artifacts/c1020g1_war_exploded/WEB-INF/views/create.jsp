<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form action="/student/create" method="post" modelAttribute="student">
    <form:input path="id"/>
    <form:input path="name"/>
    <form:select path="city">
        <form:options items="${cities}"/>
    </form:select>
    <input type="submit" value="Create">
</form:form>
</body>
</html>
