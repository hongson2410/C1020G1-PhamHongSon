<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script>
    <style>
        td {
            white-space: nowrap;
        }

        .table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
            background-color: #ffc77e;
        }
    </style>
</head>
<body>
<div>
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
        <div class="d-flex align-items-center justify-content-begin float-left">
            <a class="btn btn-primary" href="/EmployeeServlet?actionUser=create" role="button">Create new Employee</a>
        </div>
        <div class="d-flex align-items-center justify-content-end float-right">
            <form class="form-inline" action="/EmployeeServlet">
                <input type="hidden" name="actionUser" value="search">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" name="name">
                <button class="btn btn-success" type="submit">Search</button>
            </form>
        </div>
    </div>
    <div class="table-fit justify-content-center">
        <table class="table table-striped table-bordered table-hover thead-dark table-responsive" id="tableEmployee">
            <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Id Card</th>
                <th>Salary</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Username</th>
                <th>Position</th>
                <th>Education Degree</th>
                <th>Division</th>
                <th>Action</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <c:forEach var="employee" items="${employeeListFromServlet}">
                <td><c:out value="${employee.employee_id}"/></td>
                <td><c:out value="${employee.employee_name}"/></td>
                <td><c:out value="${employee.employee_birthday}"/></td>
                <td><c:out value="${employee.employee_id_card}"/></td>
                <td><c:out value="${employee.employee_salary}"/></td>
                <td><c:out value="${employee.employee_phone}"/></td>
                <td><c:out value="${employee.employee_email}"/></td>
                <td><c:out value="${employee.employee_address}"/></td>
                <td><c:out value="${employee.user_username}"/></td>
                <td>
                    <c:if test="${employee.position_id == 1}">
                        <c:out value="${'Receptionist'}"/>
                    </c:if>
                    <c:if test="${employee.position_id == 2}">
                        <c:out value="${'Server'}"/>
                    </c:if>
                    <c:if test="${employee.position_id == 3}">
                        <c:out value="${'Expert'}"/>
                    </c:if>
                    <c:if test="${employee.position_id == 4}">
                        <c:out value="${'Supervisor'}"/>
                    </c:if>
                    <c:if test="${employee.position_id == 5}">
                        <c:out value="${'Manager'}"/>
                    </c:if>
                    <c:if test="${employee.position_id == 6}">
                        <c:out value="${'President'}"/>
                    </c:if>
                    <c:if test="${employee.position_id == 7}">
                        <c:out value="${'Other'}"/>
                    </c:if>
                </td>
                <td>
                    <c:if test="${employee.education_degree_id == 1}">
                        <c:out value="${'Intermediate'}"/>
                    </c:if>
                    <c:if test="${employee.education_degree_id == 2}">
                        <c:out value="${'Colleges'}"/>
                    </c:if>
                    <c:if test="${employee.education_degree_id == 3}">
                        <c:out value="${'University'}"/>
                    </c:if>
                    <c:if test="${employee.education_degree_id == 4}">
                        <c:out value="${'After University'}"/>
                    </c:if>
                    <c:if test="${employee.education_degree_id == 5}">
                        <c:out value="${'Other'}"/>
                    </c:if>
                </td>
                <td>
                    <c:if test="${employee.division_id == 1}">
                        <c:out value="${'Sale Marketing'}"/>
                    </c:if>
                    <c:if test="${employee.division_id == 2}">
                        <c:out value="${'Server'}"/>
                    </c:if>
                    <c:if test="${employee.division_id == 3}">
                        <c:out value="${'Manager'}"/>
                    </c:if>
                    <c:if test="${employee.division_id == 4}">
                        <c:out value="${'Administration'}"/>
                    </c:if>
                    <c:if test="${employee.division_id == 5}">
                        <c:out value="${'Other'}"/>
                    </c:if>
                </td>
                <td>
                    <a class="btn btn-primary" href="/EmployeeServlet?actionUser=update&id=${employee.employee_id}"
                       role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-primary" href="/EmployeeServlet?actionUser=delete&id=${employee.employee_id}"
                       role="button">Delete</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <script>
        $(document).ready(function () {
            $('#tableEmployee').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 3
            });
        });
    </script>
</body>
</html>
