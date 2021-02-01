<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<h2>List Employee</h2>
<p>
    <a href="/furamaServlet?actionUser=createEmployee">Create new Employee</a>
</p>
<p>
    <a href="/furamaServlet">Back to Menu</a>
</p>

<form>
    <input type="hidden" name="actionUser" value="searchEmployeeByName"/>
    <input type="text" name="name" placeholder="Search By Name"/>
    <input type="submit" value="Search"/>
</form>
<form>
    <input type="hidden" name="actionUser" value="searchEmployeeById">
    <input type="text" name="id" placeholder="Search By Id"/>
    <input type="submit" value="Search"/>
</form>
<table border="1">
    <tr>
        <td>Employee Id</td>
        <td>Employee Name</td>
        <td>Employee Birthday</td>
        <td>Employee IdCard</td>
        <td>Employee Salary</td>
        <td>Employee Phone</td>
        <td>Employee Email</td>
        <td>Employee Address</td>
        <td>Employee Position Id</td>
        <td>Employee Education Degree Id</td>
        <td>Employee Division Id</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="employee" items="${employeeListFromServlet}">
        <tr>
            <td><c:out value="${employee.employee_id}"/></td>
            <td><c:out value="${employee.getEmployee_name()}"/></td>
            <td><c:out value="${employee.getEmployee_birthday()}"/></td>
            <td><c:out value="${employee.getEmployee_id_card()}"/></td>
            <td><c:out value="${employee.getEmployee_salary()}"/></td>
            <td><c:out value="${employee.getEmployee_phone()}"/></td>
            <td><c:out value="${employee.getEmployee_email()}"/></td>
            <td><c:out value="${employee.getEmployee_address()}"/></td>
            <td><c:out value="${employee.getPosition_id()}"/></td>
            <td><c:out value="${employee.getEducation_degree_id()}"/></td>
            <td><c:out value="${employee.getDivision_id()}"/></td>
            <td><a href="/furamaServlet?actionUser=updateEmployee&id=${employee.employee_id}">Update</a></td>
            <td><a href="/furamaServlet?actionUser=deleteEmployee&id=${employee.employee_id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
