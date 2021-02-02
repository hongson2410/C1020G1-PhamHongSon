<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
<p>
    <a href="/furamaServlet?actionUser=listCustomer">Back to customer list</a>
</p>
<form method="post">
    <input type="hidden" name="actionUser" value="delete"/>
    <h3 style="color: red">Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Customer Code: </td>
                <td><c:out value="${customerInfo.customer_code}"/></td>
            </tr>
            <tr>
                <td>Customer Type Id: </td>
                <td><c:out value="${customerInfo.customer_type_id}"/></td>
            </tr>
            <tr>
                <td>Customer Name: </td>
                <td><c:out value="${customerInfo.customer_name}"/></td>
            </tr>
            <tr>
                <td>Customer Birthday: </td>
                <td><c:out value="${customerInfo.customer_birthday}"/></td>
            </tr>
            <tr>
                <td>Customer Gender: </td>
                <td><c:out value="${customerInfo.isCustomer_gender()}"/></td>
            </tr>
            <tr>
                <td>Customer Id Card: </td>
                <td><c:out value="${customerInfo.getCustomer_id_card()}"/></td>
            </tr>
            <tr>
                <td>Customer Phone: </td>
                <td><c:out value="${customerInfo.customer_phone}"/></td>
            </tr>
            <tr>
                <td>Customer Email: </td>
                <td><c:out value="${customerInfo.customer_email}"/></td>
            </tr>
            <tr>
                <td>Customer Address: </td>
                <td><c:out value="${customerInfo.customer_address}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>