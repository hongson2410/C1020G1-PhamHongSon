<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h3 {
            color: green;
        }
    </style>
</head>
<body>
<h1>List Config</h1>
<h3>${message}</h3>
<table border="1px">
    <tr>
        <th>STT</th>
        <th>Config</th>
        <th>Action</th>
    </tr>
    <c:forEach var="config" items="${listConfig}">
        <tr>
            <td><c:out value="${config.idConfig}"/></td>
            <td><c:out value="${config.configName}"/></td>
            <td><a href="/detail/${config.idConfig}">Detail</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
