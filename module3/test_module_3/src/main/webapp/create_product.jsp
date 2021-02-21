<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Mới Sản Phẩm</title>
    <script src="bootstrap/js/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <style>
        header {
            height: 100px;
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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav" style="width: auto">
            <li class="nav-item active margin-navbar">
                <a class="nav-link" href="/productServlet" style="padding: 0;width: 150px"><h6>Back</h6><span
                        class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
<div class="container" style="padding: 0">
    <div class="row">
        <div class="col-lg-12" style="padding: 0; text-align: center">
            <div class="body" style="text-align: center; margin-left: 10px">
                <h2 style="margin-left: 10px; color: dodgerblue">Create Product</h2>
                <div style="text-align: center" >
                    <c:if test='${requestScope["messenger"] == "Product was create"}'>
                        <div class="alert alert-success" role="alert">
                            Product created successfully
                        </div>
                    </c:if>
                    <c:if test='${(requestScope["messenger"] != "Product was create") && (requestScope["messenger"] != null)}'>
                        <div class="alert alert-danger" role="alert">
                                ${requestScope["messenger"]}
                        </div>
                    </c:if>
                </div>
                <form method="post">
                    <input type="hidden" name="actionUser" value="create"/>
                    <table cellpadding="5">
                        <tr>
                            <th>Name:(*) </th>
                            <td><input type="text" name="product_name" id="product_name" size="45"></td>
                        </tr>
                        <tr>
                            <th>Price:(*) </th>
                            <td><input type="text" name="price" id="price" size="45"/></td>
                        </tr>
                        <tr>
                            <th>Discount:(*) :</th>
                            <td>
                                <select name="discount" id="discount">
                                    <option value="5">5 (%)</option>
                                    <option value="10">10 (%)</option>
                                    <option value="15">15 (%)</option>
                                    <option value="20">20 (%)</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Stock:(*) </th>
                            <td><input type="text" name="stock" id="stock" size="45"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Save"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>