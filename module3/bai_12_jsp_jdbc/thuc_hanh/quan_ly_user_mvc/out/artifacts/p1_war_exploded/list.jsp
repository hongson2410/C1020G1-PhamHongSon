<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>List user</title>

</head>
<body>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>email</th>
            <th>country</th>
            <th>Action</th>
        </tr>
<%--        <%--%>
<%--            List<Student> studentListAbc =--%>
<%--                    (List<Student>) request.getAttribute("studentListFromServlet");--%>
<%--            for (Student user : studentListAbc) {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td><%=user.getId()%></td>--%>
<%--            <td><%=user.getName()%></td>--%>
<%--            <td><%=user.getDateOfBirth()%></td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
        <c:forEach var="user" items="${userListFromServlet}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/UserServlet?actionUser=update&id=${user.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<%--    ${tmp}--%>
<%--    <c:out value="${tmp}" />--%>
<%--    <c:set scope=""--%>
</body>
</html>
