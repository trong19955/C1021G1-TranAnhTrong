<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Settings</h1>
<h3 style="color: green">${message}</h3>
<form:form modelAttribute="mail" action="/" method="post"> <br>
    <table>
        <tr>
            <td><b>Languages</b></td>
            <td><form:select path="language" items="${languageList}"/></td>
        </tr>
        <tr>
            <td><b>Page Size: </b></td>
            <td>Show <form:select path="pageSize" items="${pageSizeList}"/> email per page</td>
        </tr>
        <tr>
            <td><b>Spams filter :</b></td>
            <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td><b>Signature:</b></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <button type="submit">Update</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
