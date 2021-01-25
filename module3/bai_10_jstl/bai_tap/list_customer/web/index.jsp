<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
</head>
<body>
<h3 style="text-align: center">List Customers</h3>
<table border="1" style="border: solid; margin-left: 450px; ">
    <tr>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="customer" items="${customerListFromServlet}">
        <tr>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.dateOfBirth}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><img src="${customer.image}" style="width: 200px;height: 200px"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
