<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22/02/2021
  Time: 4:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${msg.equals(' ')}">
<h3>Search: ${search}</h3>
<h3>Result: ${result}</h3>
</c:if>
<c:if test="${msg.equals('Not Found!!')}">
<h3>${msg}</h3>
</c:if>
</body>
</html>
