<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="calculator.jsp" method="post">
    <fieldset>
      <legend>Calculator</legend>
  <label>First operand:  </label>
    <input type="text" name="operand" placeholder="Number-1"/><br/>
  <label>Operator:  </label>
    <select name="operator">
      <option value="Addition">Addition</option>
      <option value="subtraction">subtraction</option>
      <option value="multiplication">multiplication</option>
      <option value="division">division</option>
    </select><br/>
  <label>Second operand</label>
    <input type="text" name="second" placeholder="Number-2"/><br/>
  <input type="submit" id="submit" value="Calculate"/>
    </fieldset>
  </form>
  </body>
</html>
