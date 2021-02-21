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

        th {
            background: #1d2124;
            color: white;
           text-align: center;
        }

        td {
            background: #6c757d;
            color: black;
            font-size: 15px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav" style="width: auto">
            <li class="nav-item active margin-navbar">
                <a class="nav-link" href="/productServlet?actionUser=create" style="padding: 0;width: 150px"><h6>Thêm Mới</h6><span
                        class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid" style="padding: 0">
    <div class="row">
        <div class="col-12">
            <table class="table table-bordered">
                <h2>Product List</h2>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Stock</th>
                </tr>

                <c:forEach var="product" items="${productListFromServlet}">

                    <tr>
                        <td><c:out value="${product.product_id}"/></td>
                        <td><c:out value="${product.product_name}"/></td>
                        <td><c:out value="${product.price}"/></td>
                        <td><c:out value="${product.discount}"/></td>
                        <td><c:out value="${product.stock}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script src="bootstrap/js/jquery-3.5.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>