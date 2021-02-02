<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Furama Resort</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        .header img {
            float: left;
            height: 10%;
            width: 13%;
        }

        .dropdown-item{
            margin: 0;
            background: #1b1e21;
            color: white;
        }

        .header {
            height: 100px;
        }

        .header h5 {
            color: cornflowerblue;
            float: right;
            padding: 5%;
        }

        .margin-navbar {
            margin-left: 10%;
        }

        a:hover {
            text-decoration: underline black !important;
        }

        .image1 {
            box-sizing: border-box;
            height: 500px;
        }
        .image2 {
            box-sizing: border-box;
            height: 500px;
        }
        .image3 {
            box-sizing: border-box;
            height: 500px;
        }

        .footer {
            margin-bottom: 0;
        }

        body {
            height: 100%;
            margin-bottom: 0;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="header">
        <div class="row">
            <div class="col-lg-6">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png">
            </div>
            <div class="col-lg-6">
                <h5>Phạm Hồng Sơn</h5>
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
                        <a class="nav-link" href="/furamaServlet"><h6>Home</h6><span
                                class="sr-only">(current)</span></a>
                    </li>
                </div>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink1" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
                        Customer
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/furamaServlet?actionUser=listCustomer">List Customer</a>
                        <a class="dropdown-item" href="/furamaServlet?actionUser=create">Create Customer</a>
                    </div>
                </li>
                <li class="nav-item dropdown margin-navbar">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
                        Employee
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/furamaServlet?actionUser=listEmployee">List Employee</a>
                        <a class="dropdown-item" href="/furamaServlet?actionUser=createEmployee">Create Employee</a>
                    </div>
                </li>
                <li class="nav-item dropdown margin-navbar">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink3" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
                        Service
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/furamaServlet?actionUser=listService">List Service</a>
                        <a class="dropdown-item" href="/furamaServlet?actionUser=createService">Create Service</a>
                    </div>
                </li>
                <li class="nav-item dropdown margin-navbar">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink4" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
                        Contract
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/furamaServlet?actionUser=createContract">Create Contract</a>
                        <a class="dropdown-item" href="/furamaServlet?actionUser=listContract">List Contract</a>
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
                <a href=""><h3>Khách đang lưu trú !!</h3></a>
            </div>
        </div>

        <div class="col-lg-8" style="padding: 0">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <div class="image">
                            <img src="bootstrap/img/62371531.jpg" class="d-block w-100 image1" alt="..."  >
                        </div>
                        <div class="carousel-caption d-none d-md-block">
                            <h5>FURAMA RESORT & VILLAS ĐÀ NẴNG</h5>
                            <p>Giữa lòng thành phố Đà Nẵng, khu nghỉ dưỡng Furama Resort & Villas Đà Nẵng hiện lên
                                tựa một 'ốc đảo xanh'</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="image">
                            <img src="bootstrap/img/furama-da-nang-850x638.jpg" class="d-block w-100 image2" alt="..." >
                        </div>
                        <div class="carousel-caption d-none d-md-block">
                            <h5>FURAMA RESORT & VILLAS ĐÀ NẴNG</h5>
                            <p>Và rồi khi dừng chân tại nơi đây, bạn tựa như lạc vào một không gian mang đậm đà nét văn
                                hóa
                                Việt pha lẫn với sự hiện đại </p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div>
                            <img src="bootstrap/img/furama-resort-da-nang.jpg" class="d-block w-100 image3" alt="..." >
                        </div>
                        <div class="carousel-caption d-none d-md-block">
                            <h5>FURAMA RESORT & VILLAS ĐÀ NẴNG</h5>
                            <p>Xứng tầm đẳng cấp 5 sao quốc tế.</p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-12" style="padding: 0">
        <div class="footer">
            <p style="text-align: center;background-color: black;color: white;padding: 1%">© 2013 Luxury Booking
                |
                Theme by Booking Agent</p>
        </div>
    </div>
</div>
<script src="bootstrap/js/jquery-3.5.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
