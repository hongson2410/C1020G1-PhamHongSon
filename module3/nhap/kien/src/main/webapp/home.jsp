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
  <title>Title</title>
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

    a:hover{
      text-decoration: underline black !important;
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
  <div class="col-lg-9">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <div class="col-lg-3">
          <li class="nav-item active margin-navbar">
            <a class="nav-link" href="home"><h6>Trang chủ</h6><span class="sr-only">(current)</span></a>
          </li>
        </div>


        <li class="nav-item dropdown" style="margin-left: 45%">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink1" role="button"
             data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
            Khách Hàng
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="customer?actionUser=showListCustomer">Danh Sách</a>
            <a class="dropdown-item" href="customer?actionUser=addCustomer">Thêm Mới</a>
          </div>
        </li>

        <li class="nav-item dropdown margin-navbar">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2" role="button"
             data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
            Nhân Viên
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="employee?actionUser=showListEmployee">Danh Sách</a>
            <a class="dropdown-item" href="employee?actionUser=addEmployee">Thêm mới</a>
          </div>
        </li>

        <li class="nav-item dropdown margin-navbar">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink3" role="button"
             data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
            Dịch Vụ
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink11" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;text-align: center">
              Xem dịch vụ
            </a>
            <div class="dropdown-item" aria-labelledby="navbarDropdownMenuLink12">
              <a class="dropdown-item" href="villa?actionUser=showVilla">Villa</a>
              <a class="dropdown-item" href="house?actionUser=showHouse">House</a>
              <a class="dropdown-item" href="room?actionUser=showRoom">Room</a>
            </div>
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink10" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;text-align: center">
            Thêm dịch vụ
          </a>
          <div class="dropdown-item" aria-labelledby="navbarDropdownMenuLink13">
            <a class="dropdown-item" href="villa?actionUser=addVilla">Villa</a>
            <a class="dropdown-item" href="house?actionUser=addHouse">House</a>
            <a class="dropdown-item" href="room?actionUser=addRoom">Room</a>
          </div>
          </div>
        </li>

        <li class="nav-item dropdown margin-navbar">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink4" role="button"
             data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
            Hợp Đồng
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="contract?actionUser=addContract">Thêm Mới Hợp Đồng</a>
            <a class="dropdown-item" href="contract?actionUser=showListContract">Danh Sách Hợp Đồng</a>
          </div>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid" style="padding: 0">
  <div class="row" style="margin-right: 40px">
    <div class="col-lg-4" style="padding: 0">
      <div class="sidebar" style="text-align: center;margin-top: 10%">
        <a href="customerUsing?actionUser=showCustomerUsing"><h3>Khách đang lưu trú !!</h3></a>
      </div>
    </div>

    <div class="col-lg-8" style="padding: 0">
      <div class="body" style="text-align: center">
        <fieldset>
          <h1>FURAMA RESORT & VILLAS ĐÀ NẴNG</h1>
          <p>Giữa lòng thành phố Đà Nẵng, khu nghỉ dưỡng Furama Resort & Villas Đà Nẵng hiện lên
            tựa một ‘’ốc đảo xanh’’ làm mê đắm lòng người. Và rồi khi dừng chân tại nơi đây, bạn tựa
            như lạc vào một không gian mang đậm đà nét văn hóa Việt pha lẫn với sự hiện đại cùng với
            sự du lịch thời thượng xứng tầm đẳng cấp 5 sao quốc tế.</p>
          <img src="https://furama-booking.com/wp-content/uploads/2018/11/thien-duong-nghi-duong-furama-da-nang-768x480.jpg">
        </fieldset>
      </div>
    </div>
  </div>

  <div class="row" style="margin-right: 3px">
    <div class="col-lg-12" style="padding: 0">
      <div class="footer">
        <p style="text-align: center;background-color: black;color: white;padding: 1%">© 2013 Luxury Booking | Theme by Booking Agent</p>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</body>
</html>
