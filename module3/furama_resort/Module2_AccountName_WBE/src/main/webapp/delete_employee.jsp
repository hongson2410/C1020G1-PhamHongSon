<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting employee</title>
</head>
<body>
<p>
    <a href="/furamaServlet?actionUser=listEmployee">Back to employee list</a>
</p>
<form method="post">
    <input type="hidden" name="actionUser" value="deleteEmployee"/>
    <h3 style="color: red">Are you sure?</h3>
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td>Employee Name : </td>
                <td><c:out value="${employeeInfo.getEmployee_name()}"/></td>
            </tr>
            <tr>
                <td>Employee Birthday </td>
                <td><c:out value="${employeeInfo.getEmployee_birthday()}"/></td>
            </tr>
            <tr>
                <td>Employee Id Card: </td>
                <td><c:out value="${employeeInfo.getEmployee_id_card()}"/></td>
            </tr>
            <tr>
                <td>Employee Salary: </td>
                <td><c:out value="${employeeInfo.getEmployee_salary()}"/></td>
            </tr>
            <tr>
                <td>Employee Phone: </td>
                <td><c:out value="${employeeInfo.getEmployee_phone()}"/></td>
            </tr>
            <tr>
                <td>Employee Email: </td>
                <td><c:out value="${employeeInfo.getEmployee_email()}"/></td>
            </tr>
            <tr>
                <td>Employee Address: </td>
                <td><c:out value="${employeeInfo.getEmployee_address()}"/></td>
            </tr>
            <tr>
                <td>Employee Position Id: </td>
                <td><c:out value="${employeeInfo.getPosition_id()}"/></td>
            </tr>
            <tr>
                <td>Employee Education Degree Id: </td>
                <td><c:out value="${employeeInfo.getEducation_degree_id()}"/></td>
            </tr>
            <tr>
                <td>Employee Division Id: </td>
                <td><c:out value="${employeeInfo.getDivision_id()}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>