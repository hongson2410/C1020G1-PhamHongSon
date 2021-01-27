<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/productServlet?actionUser=create">Create New Product</a>
</p>
<form>
    <input type="hidden" name="actionUser" value="search"/>
    <input type="text" name="name" placeholder="Search"/>
    <input type="submit" value="Search"/>
</form>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${productListFromServlet}" var="product">
        <tr>
            <td><a href="/productServlet?actionUser=view&id=${product.id}">${product.getName()}</a></td>
            <td><c:out value="${product.getDescription()}"/></td>
            <td><a href="/productServlet?actionUser=edit&id=${product.id}">Edit</a></td>
            <td><a href="/productServlet?actionUser=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
