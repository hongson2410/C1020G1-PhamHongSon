<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/abc" method="post">
    <label>Calculator</label>
    <label>First Operand</label>
    <input type="text" name="first">
    <label>Second Operand</label>
    <input type="text" name="second">
    <select name="operator">
      <option>
        Addition
      </option>
      <option>
        Subtraction
      </option>
      <option>
        Division
      </option>
      <option>
        Multiplication
      </option>
    </select>
    <input type="submit">
  </form>
  </body>
</html>
