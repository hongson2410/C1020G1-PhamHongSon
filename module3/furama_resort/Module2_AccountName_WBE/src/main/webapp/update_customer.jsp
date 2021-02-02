<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh Sửa Thông Tin Khách Hàng</title>
    <script src="bootstrap/js/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <style>
        header {
            height: 100px;
        }

        .header h5 {
            color: lightskyblue;
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
                <img src="bootstrap/img/logo1.png">
            </div>
            <div class="col-lg-6">
                <h5>Phạm Hồng Sơn</h5>
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
                <a class="nav-link" href="/furamaServlet" style="padding: 0;width: 150px"><h6>Home</h6><span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid" style="padding: 0">
    <div class="row">
        <div class="col-12" style="padding: 0">
            <div class="body">
                <h2 style="text-align: center; color: dodgerblue">Edit Information Customer</h2>
                <h3 style="color: red"><c:out value="${message}"/></h3>
                <form method="post">
                    <input type="hidden" name="actionUser" value="update"/>
                    <table cellpadding="5" style="margin-left: 500px">
                        <tr>
                            <th>Customer Code:</th>
                            <td>
                                <input type="text" value="<c:out value="${customerInfo.customer_code}"/>" name="customer_code" size="45">
                            </td>
                        </tr>
                        <tr>
                            <th>Customer Type:</th>
                            <td>
                                <select name="customer_type_id" id="customer_type_id">
                                    <option value="1">Diamond</option>
                                    <option value="2">Platinum</option>
                                    <option value="3">Gold</option>
                                    <option value="4">Silver</option>
                                    <option value="5">Member</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Name :</th>
                            <td>
                                <input type="text" value="<c:out value="${customerInfo.getCustomer_name()}"/>" name="customer_name" size="45">
                            </td>
                        </tr>
                        <tr>
                            <th>Birthday(MM/dd/YYYY):</th>
                            <td>
                                <input type="date" id="datepicker" value="${customerInfo.getCustomer_birthday()}" width="200" name="customer_birthday" id="customer_birthday" style="height: 25px" />
                            </td>
                        </tr>
                        <tr>
                            <th>Gender:</th>
                            <td>
                                <select name="customer_gender" id="customer_gender">
                                    <option value="1">Nam</option>
                                    <option value="0">Nữ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>CMND:</th>
                            <td>
                                <input type="text" value="<c:out value="${customerInfo.getCustomer_id_card()}"/>" name="customer_id_card" size="45">
                            </td>
                        </tr>
                        <tr>
                            <th>Phone Number:</th>
                            <td>
                                <input type="text" value="<c:out value="${customerInfo.getCustomer_phone()}"/>" name="customer_phone" size="45">
                            </td>
                        </tr>
                        <tr>
                            <th>Email:</th>
                            <td>
                                <input type="text" value="<c:out value="${customerInfo.getCustomer_email()}"/>" name="customer_email" size="45">
                            </td>
                        </tr>
                        <tr>
                            <th>Address:</th>
                            <td>
                                <input type="text" value="<c:out value="${customerInfo.getCustomer_address()}"/>" name="customer_address" size="45">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Update"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <div class="row" style="width: 100%">
        <div class="col-lg-12" style="padding: 0">
            <div class="footer">
                <p style="text-align: center;background-color: black;color: white;padding: 1%">© 2013 Luxury Booking |
                    Theme by Booking Agent</p>
            </div>
        </div>
    </div>
</div>
<script>
    #datepicker.datepicker({
        uiLibrary: 'bootstrap'
    });
</script>
</body>
</html>
