<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Setting</h1>

<form:form action="/update" method="post" modelAttribute="config">
    <form:hidden path="idConfig"/>
    <form:hidden path="configName"/>
    <table>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td>
                <form:select path="languages">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size: </form:label></td>
            <td>
                <span>Show</span>
                <form:select path="pageSize">
                    <form:options items="${pages}"/>
                </form:select>
                <span>emails per page</span>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spam filter: </form:label></td>
            <td>
                <form:checkbox path="spamsFilter"/>
                <span>Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update" style="background: dodgerblue"/>
                <a href="/"><input type="button" value="Cancel"></a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
