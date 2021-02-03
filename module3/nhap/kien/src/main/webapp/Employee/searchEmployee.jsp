<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/29/2021
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách nhân viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        .header img {
            float: left;
            height: 90%;
            width: 30%;
        }

        .header h5 {
            color: lawngreen;
            float: right;
            padding: 5%;
        }

        .margin-navbar {
            margin-left: 10%;
        }

    </style>
</head>
<body>
<div class="container-fluid">
    <div class="header">
        <div class="row">
            <div class="col-lg-6">
                <img src="https://wikiland.vn/images/FuramaPhuQuoc/logo-furama-resort-phu-quoc.png">
            </div>
            <div class="col-lg-6">
                <h5>Nguyễn Thanh Tùng</h5>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav" style="width: auto">
            <li class="nav-item active margin-navbar">
                <a class="nav-link" href="home" style="padding: 0;width: 150px"><h6>Trang chủ</h6><span
                        class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid" style="padding: 0">
    <div class="row" style="align-content: center">a
        <div class="body" style="text-align: center;margin-left: 25%">
            <h2>Danh Sách Nhân Viên</h2>
            <table border="1" cellpadding="5">
                <tr>
                    <th>Tên Nhân viên</th>
                    <th>Giới tính</th>
                    <th>Ngày sinh</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Vị trí</th>
                    <th>Địa chỉ</th>
                </tr>
                <c:forEach var="employee" items="${listEmployee}">
                    <tr>
                        <td><c:out value="${employee.employee_name}"/></td>

                        <td><c:if test="${employee.employee_gender == 1}">
                            Nam
                        </c:if>
                            <c:if test="${employee.employee_gender == 0}">
                                Nữ
                            </c:if></td>

                        <td><c:out value="${employee.employee_birthday}"/></td>

                        <td><c:out value="${employee.employee_email}"/></td>

                        <td><c:out value="${employee.employee_phone}"/></td>
                        <td><c:if test="${employee.employee_position == 1}">
                            Lễ tân
                        </c:if>
                            <c:if test="${employee.employee_position == 2}">
                                Phục vụ
                            </c:if>
                            <c:if test="${employee.employee_position == 3}">
                                Chuyên viên
                            </c:if>
                            <c:if test="${employee.employee_position == 4}">
                                Giám sát
                            </c:if>
                            <c:if test="${employee.employee_position == 5}">
                                Quản Lý
                            </c:if>
                            <c:if test="${employee.employee_position == 6}">
                                Giám đốc
                            </c:if></td>

                        <td><c:out value="${employee.employee_address}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="row" style="margin-right: 3px">
        <div class="col-lg-12" style="padding: 0">
            <div class="footer">
                <p style="text-align: center;background-color: black;color: white;padding: 1%">© 2013 Luxury Booking |
                    Theme by Booking Agent</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>

