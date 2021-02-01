<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Info</title>
</head>
<body>
<h2>Customer Info</h2>
<p>
    <a href="/furamaServlet?actionUser=listCustomer">Back to customer list</a>
</p>
<p style="color: red"><c:out value="${message}"/></p>
<table border="1">
    <tr>
        <td>Customer Id</td>
        <td>Customer Type ID</td>
        <td>Customer Name</td>
        <td>Customer Birthday</td>
        <td>Customer gender</td>
        <td>Customer IdCard</td>
        <td>Customer Phone</td>
        <td>Customer Email</td>
        <td>Customer Address</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>
    <tr>
        <td><c:out value="${customerInfo.customer_id}"/></td>
        <td><c:out value="${customerInfo.customer_type_id}"/></td>
        <td><c:out value="${customerInfo.getCustomer_name()}"/></td>
        <td><c:out value="${customerInfo.getCustomer_birthday()}"/></td>
        <td><c:out value="${customerInfo.isCustomer_gender()}"/></td>
        <td><c:out value="${customerInfo.getCustomer_id_card()}"/></td>
        <td><c:out value="${customerInfo.getCustomer_phone()}"/></td>
        <td><c:out value="${customerInfo.getCustomer_email()}"/></td>
        <td><c:out value="${customerInfo.getCustomer_address()}"/></td>
        <td><a href="/furamaServlet?actionUser=update&id=${customerInfo.customer_id}">Update</a></td>
        <td><a href="/furamaServlet?actionUser=delete&id=${customerInfo.customer_id}">Delete</a></td>
    </tr>
</table>
</body>
</html>
