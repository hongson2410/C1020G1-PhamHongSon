<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
</head>
<body>
<p>
    <a href="/furamaServlet?actionUser=listEmployee">Back to employee list</a>
</p>
<h3 style="color: red"><c:out value="${message}"/></h3>
<form method="post">
    <input type="hidden" name="actionUser" value="updateEmployee"/>
    <input type="hidden" name="id" value="${employeeInfo.employee_id}"/>
    <fieldset>
        <legend>Employee information</legend>
        <p>
            Employee Name :
            <input type="text" value="<c:out value="${employeeInfo.getEmployee_name()}"/>" name="employee_name">
        </p>
        <p>
            Employee Birthday :
            <input type="text" value="<c:out value="${employeeInfo.getEmployee_birthday()}"/>" name="employee_birthday">
        </p>
        <p>
            Employee Id Card:
            <input type="text" value="<c:out value="${employeeInfo.getEmployee_id_card()}"/>" name="employee_id_card">
        </p>
        <p>
            Employee Salary:
            <input type="text" value="<c:out value="${employeeInfo.getEmployee_salary()}"/>" name="employee_salary">
        </p>
        <p>
            Employee Phone:
            <input type="text" value="<c:out value="${employeeInfo.getEmployee_phone()}"/>" name="employee_phone">
        </p>
        <p>
            Employee Email:
            <input type="text" value="<c:out value="${employeeInfo.getEmployee_email()}"/>" name="employee_email">
        </p>
        <p>
            Employee Address:
            <input type="text" value="<c:out value="${employeeInfo.getEmployee_address()}"/>" name="employee_address">
        </p>
        <p>
            Employee Position Id:
            <input type="text" value="<c:out value="${employeeInfo.getPosition_id()}"/>" name="position_id">
        </p>
        <p>
            Employee Education Degree Id:
            <input type="text" value="<c:out value="${employeeInfo.getEducation_degree_id()}"/>" name="education_degree_id">
        </p>
        <p>
            Employee Division Id:
            <input type="text" value="<c:out value="${employeeInfo.getDivision_id()}"/>" name="division_id">
        </p>
        <p>
            <input type="submit" value="Update"/>
        </p>
    </fieldset>
</form>
</body>
</html>
