<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View user</title>
</head>
<body>
<h1>User details</h1>
<p>
    <a href="/UserServlet">Back to user list</a>
</p>
<c:set var = "messenger" scope="session" value = "${requestScope.messenger}"/>
<c:if test="${messenger.equals('')}">
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>

        <c:forEach var="user" items="${userListFromServlet}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${messenger.equals('not found')}">
    <c:out value="${'User not found'}"/>
</c:if>

</body>
</html>