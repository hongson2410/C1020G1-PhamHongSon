<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="calculator">
    <input type="text" name="input_1" value="${input_1}">
    <input type="text" name="input_2" value="${input_2}">
    <br>
    <br>
    <input type="submit" name="operator" value="Addition(+)">
    <input type="submit" name="operator" value="Subtraction(-)">
    <input type="submit" name="operator" value="Multiplication(X)">
    <input type="submit" name="operator" value="Division(/)">
</form>
<c:if test="${result == 'Infinity'}">
    <span style="color: red;font-size: 30px">Không được chia cho 0</span>
</c:if>
<c:if test="${result != 'Infinity'}">
    Result:<span style="font-size: 30px"><c:out value="${result}"/></span>
</c:if>
</body>
</html>
