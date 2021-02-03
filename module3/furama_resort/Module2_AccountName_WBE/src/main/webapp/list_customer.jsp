<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <style>
        header {
            height: 100px;
        }

        header h5 {
            color: lawngreen;
            float: right;
            padding: 5%;
        }

        .margin-navbar {
            margin-left: 10%;
        }

        h4 {
            margin: 2rem 0rem 1rem;
        }

        .table-image td, th {
            vertical-align: middle;
        }

        .footer {
            text-align: center;
            width: 100%;
        }

        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
        }

    </style>
</head>
<body>
<header>
    <div class="container-fluid">
        <div class="row">
            <div class="col-6">
                <img src="bootstrap/img/logo1.png" alt="#">
            </div>
            <div class="col-6">
                <h5>Phạm Hồng Sơn</h5>
            </div>
        </div>
    </div>
</header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav" style="width: auto">
            <li class="nav-item active margin-navbar">
                <a class="nav-link" href="/furamaServlet" style="padding: 0;width: 150px"><h6>Home</h6><span
                        class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
    <div class="collapse navbar-collapse" id="navbarNavDropdown2">
        <ul class="navbar-nav" style="width: auto">
            <li class="nav-item active margin-navbar">
                <form>
                    <input type="hidden" name="actionUser" value="searchById"/>
                    <input type="text" name="id" placeholder="Search By Id"/>
                    <input type="submit" value="Search"/>
                </form>
            </li>
        </ul>
    </div>
    <div class="collapse navbar-collapse" id="navbarNavDropdown3">
        <ul class="navbar-nav" style="width: auto">
            <li class="nav-item active margin-navbar">
                <form>
                    <input type="hidden" name="actionUser" value="searchByName"/>
                    <input type="text" name="name" placeholder="Search By Name"/>
                    <input type="submit" value="Search"/>
                </form>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid" style="padding: 0">
    <div class="row">
        <div class="col-12">
            <table class="table table-bordered">
                <h2>Customer List</h2>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Customer Code</th>
                    <th>Birthday</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Customer type</th>
                    <th>Address</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>

                <c:forEach var="customer" items="${customerListFromServlet}">

                    <tr>
                        <th><c:out value="${customer.customer_id}"/></th>
                        <td><c:out value="${customer.customer_name}"/></td>
                        <td><c:out value="${customer.customer_code}"/></td>
                        <td><c:out value="${customer.customer_birthday}"/></td>
                        <td><c:out value="${customer.customer_email}"/></td>
                        <td><c:out value="${customer.customer_phone}"/></td>
                        <td><c:if test="${customer.customer_type_id == 1}">
                                Diamond
                            </c:if><c:if test="${customer.customer_type_id == 2}">
                                Platinum
                            </c:if><c:if test="${customer.customer_type_id == 3}">
                                Gold
                            </c:if><c:if test="${customer.customer_type_id == 4}">
                                Silver
                            </c:if><c:if test="${customer.customer_type_id == 5}">
                                Member
                            </c:if></td>
                        <td><c:out value="${customer.customer_address}"/></td>
                        <td>
                            <a href="/furamaServlet?actionUser=update&id=${customer.customer_id}" class="edit"
                               title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                <i class="material-icons" >&#xE872;</i>
                            </button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Are you sure you want to delete these Records?</p>
                                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary" name="delete" value="yes">
                                                <a href="/furamaServlet?actionUser=delete&id=${customer.customer_id}"
                                                   style="color: white;text-decoration: none">
                                                    Yes</a></button>
                                            <button type="button" class="btn btn-secondary"
                                                    data-dismiss="modal">
                                                <a style="color: white;text-decoration: none">
                                                    Cancel</a></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12" style="padding: 0">
            <div class="footer">
                <p style="text-align: center;background-color: black;color: white;padding: 1%">© 2013 Luxury Booking
                    | Theme by Booking Agent</p>
            </div>
        </div>
    </div>
</div>
<script src="bootstrap/js/jquery-3.5.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>