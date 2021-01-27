<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create New Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/productServlet">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id" id="id"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" id="price"/></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" id="description"/></td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td><input type="text" name="producer" id="producer"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Product"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
