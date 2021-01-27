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
<table border="1">
    <tr>
        <td>Enter name you want find: </td>
        <td><input type="text" name="name" id="name"/></td>
        <td><a href="/productServlet?actionUser=find"><input type="submit" value="Find product"/></a></td>
    </tr>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${productListFromServlet}" var="product">
        <tr>
            <td><a href="/productServlet?actionUser=view&id=${product.id}">${product.getName()}</a></td>
            <td>${product.getDescription()}</td>
            <td><a href="/productServlet?actionUser=edit&id=${product.id}">Edit</a></td>
            <td><a href="/productServlet?actionUser=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
