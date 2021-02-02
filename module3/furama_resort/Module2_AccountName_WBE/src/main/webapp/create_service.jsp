<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Service</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new service</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/furamaServlet">Back to home</a>
</p>
<form method="post">
    <input type="hidden" name="actionUser" value="createService"/>
    <fieldset>
        <legend>Service information</legend>
        <table>
            <tr>
                <td>Service Code: </td>
                <td><input type="text" name="service_code" id="service_code"></td>
            </tr>
            <tr>
                <td>Service Name: </td>
                <td><input type="text" name="service_name" id="service_name"></td>
            </tr>
            <tr>
                <td>Service Area: </td>
                <td><input type="text" name="service_area" id="service_area"></td>
            </tr>
            <tr>
                <td>Service Cost: </td>
                <td><input type="text" name="service_cost" id="service_cost"></td>
            </tr>
            <tr>
                <td>Service Max People: </td>
                <td><input type="text" name="service_max_people" id="service_max_people"></td>
            </tr>
            <tr>
                <td>Rent Type Id: </td>
                <td><input type="text" name="rent_type_id" id="rent_type_id"></td>
            </tr>
            <tr>
                <td>Service Type Id: </td>
                <td><input type="text" name="service_type_id" id="service_type_id"></td>
            </tr>
            <tr>
                <td>Standard Room: </td>
                <td><input type="text" name="standard_room" id="standard_room"></td>
            </tr>
            <tr>
                <td>Description Other Convenience: </td>
                <td><input type="text" name="description_other_convenience" id="description_other_convenience"></td>
            </tr>
            <tr>
                <td>Pool Area: </td>
                <td><input type="text" name="pool_area" id="pool_area"></td>
            </tr>
            <tr>
                <td>Number Of Floors: </td>
                <td><input type="text" name="number_of_floors" id="number_of_floors"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
