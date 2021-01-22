<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 22/01/2021
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int numberOne = Integer.parseInt(request.getParameter("number1"));
        int numberTwo = Integer.parseInt(request.getParameter("number2"));
        int total = numberOne + numberTwo;
    %>
    <h2 style="color: blue"><%=total%></h2>

</body>
</html>
