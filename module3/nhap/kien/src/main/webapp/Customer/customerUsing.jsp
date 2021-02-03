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
    <title>Danh sách khách hàng</title>
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
    <div class="row" style="align-content: center">
        <div class="body" style="text-align: center;margin-left: 17%">
            <h2>Khách Hàng Đang Lưu Trú</h2>
            <form>
                <label>Tên khách hàng:</label>
                <input type="hidden" name="actionUser" value="searchCustomer">
                <input type="text" name="name" placeholder="Tìm kiếm...">
                <input type="submit" value="Tìm kiếm">
            </form>
            <table border="1" cellpadding="5">
                <tr>
                    <th>Tên khách hàng</th>
                    <th>CMND</th>
                    <th>Số điện thoại</th>
                    <th>Tên dịch vụ</th>
                    <th>Dịch vụ đi kèm</th>
                    <th>Sửa dịch vụ</th>
                    <th>Xoá</th>
                </tr>
                <c:forEach var="customerUsing" items="${listCustomerUsing}">
                    <tr>
                        <td><c:out value="${customerUsing.nameCustomer}"/></td>
                        <td><c:out value="${customerUsing.idCardCustomer}"/></td>
                        <td><c:out value="${customerUsing.phoneCustomer}"/></td>
                        <td><c:out value="${customerUsing.nameService}"/></td>
                        <td><c:out value="${customerUsing.attachService}"/></td>

                        <td><a class="btn btn-primary"
                               href="?actionUser=editService&id=${customerUsing.idService}&idType=${customerUsing.idServiceType}"
                               role="button" style="margin-left: 20%">Sửa</a></td>

                        <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                            Xoá
                        </button>

                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Bạn có muốn xoá dịch vụ này
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary" name="delete" value="yes">
                                                <a href="?actionUser=deleteService&value=yes&id=${customerUsing.idService}"
                                                   style="color: white;text-decoration: none">
                                                    Đồng Ý</a></button>

                                            <button type="button" class="btn btn-secondary"
                                                    data-dismiss="modal">
                                                <a style="color: white;text-decoration: none">
                                                    Huỷ</a></button>
                                        </div>
                                    </div>
                                </div>
                            </div></td>
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


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</body>
</html>
