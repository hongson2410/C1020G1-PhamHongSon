<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
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
            Create Employee
        </h2>
    </div>
</div>

<div style="clear:both">
    <c:if test='${requestScope["messenger"] == "OK"}'>
        <div class="alert alert-success" role="alert">
            Employee created successfully
        </div>
    </c:if>
    <c:if test='${(requestScope["messenger"] != "OK") && (requestScope["messenger"] != null)}'>
        <div class="alert alert-danger" role="alert">
                ${requestScope["messenger"]}
        </div>
    </c:if>
</div>

<c:if test='${requestScope["messenger"] != "OK"}'>
    <div class="container" style="clear:both">
        <form method="post" action="/EmployeeServlet">
            <input type="hidden" name="actionUser" value="create">
            <table>
                <tr>
                    <td>*Name:</td>
                    <td><input type="text" value="${employeeInfo.employee_name}" name="employee_name"></td>
                    <td>Address:</td>
                    <td><input type="text" value="${employeeInfo.employee_address}" name="employee_address"></td>
                </tr>
                <tr>
                    <td>*Birthday:</td>
                    <td><input type="text" value="${employeeInfo.employee_birthday}" name="employee_birthday"></td>
                    <td>Username:</td>
                    <td><input type="text" value="${employeeInfo.user_username}" name="user_username"></td>
                </tr>
                <tr>
                    <td>*ID Card:</td>
                    <td>
                        <input type="text" value="${employeeInfo.employee_id_card}" name="employee_id_card">
                    </td>
                    <td>Position:</td>
                    <td>
                        <div class="input-group mb-3">
                            <select class="custom-select" name="position_id">
                                <c:set var="num" value="${employeeInfo.position_id}"></c:set>
                                <c:if test="${(num == null) || (num == 7)}">
                                    <option selected value="7">Other</option>
                                    <option value="1">Receptionist</option>
                                    <option value="2">Server</option>
                                    <option value="3">Expert</option>
                                    <option value="4">Supervisor</option>
                                    <option value="5">Manager</option>
                                    <option value="6">President</option>
                                </c:if>
                                <c:if test="${num == 1}">
                                    <option value="7">Other</option>
                                    <option selected value="1">Receptionist</option>
                                    <option value="2">Server</option>
                                    <option value="3">Expert</option>
                                    <option value="4">Supervisor</option>
                                    <option value="5">Manager</option>
                                    <option value="6">President</option>
                                </c:if>
                                <c:if test="${num == 2}">
                                    <option value="7">Other</option>
                                    <option value="1">Receptionist</option>
                                    <option selected value="2">Server</option>
                                    <option value="3">Expert</option>
                                    <option value="4">Supervisor</option>
                                    <option value="5">Manager</option>
                                    <option value="6">President</option>
                                </c:if>
                                <c:if test="${num == 3}">
                                    <option value="7">Other</option>
                                    <option value="1">Receptionist</option>
                                    <option value="2">Server</option>
                                    <option selected value="3">Expert</option>
                                    <option value="4">Supervisor</option>
                                    <option value="5">Manager</option>
                                    <option value="6">President</option>
                                </c:if>
                                <c:if test="${num == 4}">
                                    <option value="7">Other</option>
                                    <option value="1">Receptionist</option>
                                    <option value="2">Server</option>
                                    <option value="3">Expert</option>
                                    <option selected value="4">Supervisor</option>
                                    <option value="5">Manager</option>
                                    <option value="6">President</option>
                                </c:if>
                                <c:if test="${num == 5}">
                                    <option value="7">Other</option>
                                    <option value="1">Receptionist</option>
                                    <option value="2">Server</option>
                                    <option value="3">Expert</option>
                                    <option value="4">Supervisor</option>
                                    <option selected value="5">Manager</option>
                                    <option value="6">President</option>
                                </c:if>
                                <c:if test="${num == 6}">
                                    <option value="7">Other</option>
                                    <option value="1">Receptionist</option>
                                    <option value="2">Server</option>
                                    <option value="3">Expert</option>
                                    <option value="4">Supervisor</option>
                                    <option value="5">Manager</option>
                                    <option selected value="6">President</option>
                                </c:if>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*Salary:</td>
                    <td>
                        <input type="text" value="${employeeInfo.employee_salary}" name="employee_salary">
                    </td>
                    <td>Education Degree:</td>
                    <td>
                        <div class="input-group mb-3">
                            <select class="custom-select" name="education_degree_id">
                                <c:set var="num" value="${employeeInfo.education_degree_id}"></c:set>
                                <c:if test="${(num == null) || (num == 5)}">
                                    <option selected value="5">Other</option>
                                    <option value="1">Intermediate</option>
                                    <option value="2">Colleges</option>
                                    <option value="3">University</option>
                                    <option value="4">After University</option>
                                </c:if>
                                <c:if test="${num == 1}">
                                    <option value="5">Other</option>
                                    <option selected value="1">Intermediate</option>
                                    <option value="2">Colleges</option>
                                    <option value="3">University</option>
                                    <option value="4">After University</option>
                                </c:if>
                                <c:if test="${num == 2}">
                                    <option value="5">Other</option>
                                    <option value="1">Intermediate</option>
                                    <option selected value="2">Colleges</option>
                                    <option value="3">University</option>
                                    <option value="4">After University</option>
                                </c:if>
                                <c:if test="${num == 3}">
                                    <option value="5">Other</option>
                                    <option value="1">Intermediate</option>
                                    <option value="2">Colleges</option>
                                    <option selected value="3">University</option>
                                    <option value="4">After University</option>
                                </c:if>
                                <c:if test="${num == 4}">
                                    <option value="5">Other</option>
                                    <option value="1">Intermediate</option>
                                    <option value="2">Colleges</option>
                                    <option value="3">University</option>
                                    <option selected value="4">After University</option>
                                </c:if>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*Phone:</td>
                    <td><input type="text" value="${employeeInfo.employee_phone}" name="employee_phone"></td>
                    <td>
                        Division:
                    </td>
                    <td>
                        <div class="input-group mb-3">
                            <select class="custom-select" name="division_id">
                                <c:set var="num" value="${employeeInfo.division_id}"></c:set>
                                <c:if test="${(num == null) || (num == 5)}">
                                    <option selected value="5">Other</option>
                                    <option value="1">Sale Marketing</option>
                                    <option value="2">Server</option>
                                    <option value="3">Manager</option>
                                    <option value="4">Administration</option>
                                </c:if>
                                <c:if test="${num == 1}">
                                    <option value="5">Other</option>
                                    <option selected value="1">Sale Marketing</option>
                                    <option value="2">Server</option>
                                    <option value="3">Manager</option>
                                    <option value="4">Administration</option>
                                </c:if>
                                <c:if test="${num == 2}">
                                    <option value="5">Other</option>
                                    <option value="1">Sale Marketing</option>
                                    <option selected value="2">Server</option>
                                    <option value="3">Manager</option>
                                    <option value="4">Administration</option>
                                </c:if>
                                <c:if test="${num == 3}">
                                    <option value="5">Other</option>
                                    <option value="1">Sale Marketing</option>
                                    <option value="2">Server</option>
                                    <option selected value="3">Manager</option>
                                    <option value="4">Administration</option>
                                </c:if>
                                <c:if test="${num == 4}">
                                    <option value="5">Other</option>
                                    <option value="1">Sale Marketing</option>
                                    <option value="2">Server</option>
                                    <option value="3">Manager</option>
                                    <option selected value="4">Administration</option>
                                </c:if>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" value="${employeeInfo.employee_email}" name="employee_email"></td>
                    <td></td>
                    <td>
                        <input type="submit" value="Create employee">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>
</body>
</html>