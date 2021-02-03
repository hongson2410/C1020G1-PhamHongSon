<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
    <title>List employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        td {
            width: 24%;
        }
    </style>
</head>
<body>
<ul class="nav nav-pills mb-3 bg-secondary" role="tablist">
    <li class="nav-item">
        <a class="nav-link" href="#pills-home" role="tab">Main Page</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#pills-profile" role="tab">Service</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#pills-contact" role="tab">Customer</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="/EmployeeServlet" role="tab">Employee</a>
    </li>
</ul>

<div>
    <div class="d-flex align-items-center float-left">
        <a class="btn btn-primary" href="/EmployeeServlet" role="button">
            Back to Employee list
        </a>
    </div>
    <div class="d-flex align-items-center float-right">
        <h2>
            Delete employee
        </h2>
    </div>
</div>

<div style="clear:both">
    <c:if test='${requestScope["messenger"] == "OK"}'>
        <div class="alert alert-success" role="alert">
            Employee deleted successfully
        </div>
    </c:if>
</div>

<c:if test='${requestScope["messenger"] == "NG"}'>
    <div class="container" style="clear:both">
        <form method="post">
            <table class="table-bordered">
                <tr>
                    <td>ID:</td>
                    <td>${employeeInfo.employee_id}</td>
                    <td>Email:</td>
                    <td>${employeeInfo.employee_email}</td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td>${employeeInfo.employee_name}</td>
                    <td>Address:</td>
                    <td>${employeeInfo.employee_address}</td>
                </tr>
                <tr>
                    <td>Birthday:</td>
                    <td>${employeeInfo.employee_birthday}</td>
                    <td>Username:</td>
                    <td>${employeeInfo.user_username}</td>
                </tr>
                <tr>
                    <td>ID Card:</td>
                    <td>${employeeInfo.employee_id_card}</td>
                    <td>Position:</td>
                    <td>
                        <c:if test="${employeeInfo.position_id == 1}">
                            <c:out value="${'Receptionist'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.position_id == 2}">
                            <c:out value="${'Server'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.position_id == 3}">
                            <c:out value="${'Expert'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.position_id == 4}">
                            <c:out value="${'Supervisor'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.position_id == 5}">
                            <c:out value="${'Manager'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.position_id == 6}">
                            <c:out value="${'President'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.position_id == 7}">
                            <c:out value="${'Other'}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>Salary:</td>
                    <td>${employeeInfo.employee_salary}</td>
                    <td>Education Degree:</td>
                    <td>
                        <c:if test="${employeeInfo.education_degree_id == 1}">
                            <c:out value="${'Intermediate'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.education_degree_id == 2}">
                            <c:out value="${'Colleges'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.education_degree_id == 3}">
                            <c:out value="${'University'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.education_degree_id == 4}">
                            <c:out value="${'After University'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.education_degree_id == 5}">
                            <c:out value="${'Other'}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td>${employeeInfo.employee_phone}</td>
                    <td>Division:</td>
                    <td>
                        <c:if test="${employeeInfo.division_id == 1}">
                            <c:out value="${'Sale Marketing'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.division_id == 2}">
                            <c:out value="${'Server'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.division_id == 3}">
                            <c:out value="${'Manager'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.division_id == 4}">
                            <c:out value="${'Administration'}"/>
                        </c:if>
                        <c:if test="${employeeInfo.division_id == 5}">
                            <c:out value="${'Other'}"/>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>Are you sure?</td>
                    <td><input type="submit" value="Delete user"></td>
                </tr>
            </table>
        </form>
    </div>
</c:if>
</body>
</html>