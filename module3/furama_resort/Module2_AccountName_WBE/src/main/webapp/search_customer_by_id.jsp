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

        .container {
            padding: 2rem 0rem;
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

        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }

        .modal textarea.form-control {
            resize: vertical;
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
</nav>

<div class="container">
    <div class="row">
        <div class="col-12">
            <table class="table table-bordered">
                <h2>Customer List</h2>
                <p style="color: red"><c:out value="${message}"/></p>
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

                    <tr>
                        <th scope="row"><c:out value="${customerInfo.customer_id}"/></th>
                        <td><c:out value="${customerInfo.customer_name}"/></td>
                        <td><c:out value="${customerInfo.customer_code}"/></td>
                        <td><c:out value="${customerInfo.customer_birthday}"/></td>
                        <td><c:out value="${customerInfo.customer_email}"/></td>
                        <td><c:out value="${customerInfo.customer_phone}"/></td>
                        <td><c:if test="${customerInfo.customer_type_id == 1}">
                            Diamond
                        </c:if>
                            <c:if test="${customerInfo.customer_type_id == 2}">
                                Platinum
                            </c:if><c:if test="${customerInfo.customer_type_id == 3}">
                                Gold
                            </c:if><c:if test="${customerInfo.customer_type_id == 4}">
                                Silver
                            </c:if><c:if test="${customerInfo.customer_type_id == 5}">
                                Member
                            </c:if></td>
                        <td><c:out value="${customerInfo.customer_address}"/></td>
                        <td>
                            <a href="#editEmployeeModal" class="edit"
                               title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#exampleModal">
                                <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                            </button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
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
                                                <a href="/furamaServlet?actionUser=delete&value=yes&id=${customerInfo.customer_id}"
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

                    <div id="editEmployeeModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form>
                                    <div class="modal-header">
                                        <h4 class="modal-title">Edit Customer</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                            &times;
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label>Name</label>
                                            <input type="text"
                                                   value="<c:out value="${customerInfo.getCustomer_name()}"/>"
                                                   name="customer_name">
                                        </div>
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="email" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Address</label>
                                            <textarea class="form-control" required></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Phone</label>
                                            <input type="text" class="form-control" required>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal"
                                               value="Cancel">
                                        <input type="submit" class="btn btn-info" value="Save">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
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
