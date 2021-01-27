<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>Products</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${productListFromServlet}" var="product">
        <tr>
            <td><a href="/productServlet?actionUser=view&id=${product.id}">${product.getName()}</a></td>
            <td>${product.getDescription()}</td>
            <td><c:out value="${product.price}"/></td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="/productServlet">Back to product list</a>
</p>
</body>
</html>
