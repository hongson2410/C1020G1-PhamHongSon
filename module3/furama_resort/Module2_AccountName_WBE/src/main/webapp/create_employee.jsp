<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new employee</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/furamaServlet?actionUser=listEmployee">Back to customer list Employee</a>
</p>
<form method="post">
    <input type="hidden" name="actionUser" value="createEmployee"/>
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td>Employee Name: </td>
                <td><input type="text" name="employee_name" id="employee_name"></td>
            </tr>
            <tr>
                <td>Employee Birthday: </td>
                <td><input type="text" name="employee_birthday" id="employee_birthday"></td>
            </tr>
            <tr>
                <td>Employee Id Card: </td>
                <td><input type="text" name="employee_id_card" id="employee_id_card"></td>
            </tr>
            <tr>
                <td>Employee Salary: </td>
                <td><input type="text" name="employee_salary" id="employee_salary"></td>
            </tr>
            <tr>
                <td>Employee Phone: </td>
                <td><input type="text" name="employee_phone" id="employee_phone"></td>
            </tr>
            <tr>
                <td>Employee Email: </td>
                <td><input type="text" name="employee_email" id="employee_email"></td>
            </tr>
            <tr>
                <td>Employee Address: </td>
                <td><input type="text" name="employee_address" id="employee_address"></td>
            </tr>
            <tr>
                <td>Employee Position Id: </td>
                <td><input type="text" name="position_id" id="position_id"></td>
            </tr>
            <tr>
                <td>Employee Education Degree Id: </td>
                <td><input type="text" name="education_degree_id" id="education_degree_id"></td>
            </tr>
            <tr>
                <td>Employee Division Id: </td>
                <td><input type="text" name="division_id" id="division_id"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>