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
    <title>Thêm Mới Hợp Đồng</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css"/>
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
    <div class="row" style="margin-right: 40px">
        <div class="col-lg-4" style="padding: 0">
            <div class="sidebar">
                <img src="https://dulichtour.vn/wp-content/uploads/2017/05/CauRongDaNang.jpg"
                     style="width: 95%;height:100%">
            </div>
        </div>

        <div class="col-lg-8" style="padding: 0">
            <div class="body" style="text-align: center">
                <h2>Thêm mới hợp đồng</h2>
                <form method="post">
                    <table cellpadding="5">
                        <tr>
                            <th>Ngày bắt đầu:</th>
                            <td>
                                <input type="date" name="start_date" size="45"/>
                            </td>
                        </tr>
                        <tr>
                        <tr>
                            <th>Ngày kết thúc:</th>
                            <td>
                                <input type="date" name="end_date" size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Tiền đặt cọc:</th>
                            <td>
                                <input type="text" name="deposit" size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Tổng tiền:</th>
                            <td>
                                <input type="text" name="total" size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>ID nhân viên:</th>
                            <td>
                                <input type="text" name="id_employee" size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>ID khách hàng:</th>
                            <td>
                                <input type="text" name="id_customer" size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>ID dịch vụ:</th>
                            <td>
                                <input type="text" name="id_service" size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Tạo mới"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
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

<script>
    $('#datepicker').datepicker({
        uiLibrary: 'bootstrap'
    });
</script>
</body>
</html>
