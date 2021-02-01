<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update customer</title>
</head>
<body>
<p>
    <a href="/furamaServlet?actionUser=listCustomer">Back to customer list</a>
</p>
<h3 style="color: red"><c:out value="${message}"/></h3>
<form method="post">
    <input type="hidden" name="actionUser" value="update"/>
    <input type="hidden" name="id" value="${customerInfo.customer_id}"/>
    <fieldset>
        <legend>Customer information</legend>
        <p>
            Customer Type ID :
            <input type="text" value="<c:out value="${customerInfo.customer_type_id}"/>" name="customer_type_id">
        </p>
        <p>
            Customer Name :
            <input type="text" value="<c:out value="${customerInfo.getCustomer_name()}"/>" name="customer_name">
        </p>
        <p>
            Customer Birthday:
            <input type="text" value="<c:out value="${customerInfo.getCustomer_birthday()}"/>" name="customer_birthday">
        </p>
        <p>
            Customer Gender:
            <input type="text" value="<c:out value="${customerInfo.isCustomer_gender()}"/>" name="customer_gender">
        </p>
        <p>
            Customer IdCard:
            <input type="text" value="<c:out value="${customerInfo.getCustomer_id_card()}"/>" name="customer_id_card">
        </p>
        <p>
            Customer Phone:
            <input type="text" value="<c:out value="${customerInfo.getCustomer_phone()}"/>" name="customer_phone">
        </p>
        <p>
            Customer Email:
            <input type="text" value="<c:out value="${customerInfo.getCustomer_email()}"/>" name="customer_email">
        </p>
        <p>
            Customer Address:
            <input type="text" value="<c:out value="${customerInfo.getCustomer_address()}"/>" name="customer_address">
        </p>
        <p>
            <input type="submit" value="Update"/>
        </p>
    </fieldset>
</form>
</body>
</html>
