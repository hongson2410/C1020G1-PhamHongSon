<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23/02/2021
  Time: 2:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich</title>
  </head>
  <style>
    h3 {
      color: red;
    }
  </style>
  <body>
  <h2>Sandwich Condiments</h2>

  <h3>${message}</h3>
  <form action="my_sandwich" >
    <input type="checkbox" name="condiments" value="Lettuce">Lettuce
    <input type="checkbox" name="condiments" value="Tomato">Tomato
    <input type="checkbox" name="condiments" value="Mustard">Mustard
    <input type="checkbox" name="condiments" value="Sprouts">Sprouts
    <br>
    <input type="submit" name="Save">
  </form>
  </body>
</html>
