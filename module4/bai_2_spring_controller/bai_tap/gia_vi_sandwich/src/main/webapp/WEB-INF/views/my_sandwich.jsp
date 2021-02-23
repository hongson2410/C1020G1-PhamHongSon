<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23/02/2021
  Time: 2:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Sandwich</title>
</head>
<style>
    span {
        color: blue;
    }
</style>
<body>
<h3>The seasoning you have chosen:
<span><c:forEach var="condiments" items="${listCondiment}" >
    ${condiments }
</c:forEach></span> </h3>
</body>
</html>
