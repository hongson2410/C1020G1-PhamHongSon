<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
</head>
<body>
<h2>List Customer</h2>
<p>
    <a href="/furamaServlet?actionUser=create">Create new customer</a>
</p>
<form>
    <input type="hidden" name="actionUser" value="searchByName"/>
    <input type="text" name="name" placeholder="Search By Name"/>
    <input type="submit" value="Search"/>
</form>
<form>
    <input type="hidden" name="actionUser" value="searchById">
    <input type="text" name="id" placeholder="Search By Id"/>
    <input type="submit" value="Search"/>
</form>
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
    <c:forEach var="customer" items="${customerListFromServlet}">
        <tr>
            <td><c:out value="${customer.customer_id}"/></td>
            <td><c:out value="${customer.customer_type_id}"/></td>
            <td><c:out value="${customer.getCustomer_name()}"/></td>
            <td><c:out value="${customer.getCustomer_birthday()}"/></td>
            <td><c:out value="${customer.isCustomer_gender()}"/></td>
            <td><c:out value="${customer.getCustomer_id_card()}"/></td>
            <td><c:out value="${customer.getCustomer_phone()}"/></td>
            <td><c:out value="${customer.getCustomer_email()}"/></td>
            <td><c:out value="${customer.getCustomer_address()}"/></td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
