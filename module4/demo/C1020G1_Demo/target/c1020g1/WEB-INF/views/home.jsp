<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 2/23/2021
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student/create">Add new student</a>
<h3>List Student</h3>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach var="student" items="${listStudent}">
        <tr>
            <td>
                <c:out value="${student.id}"/>
            </td>
            <td>
                <c:out value="${student.name}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
