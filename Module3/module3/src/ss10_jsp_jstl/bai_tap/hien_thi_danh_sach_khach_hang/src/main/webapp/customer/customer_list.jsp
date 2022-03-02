<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/31/2022
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> List Customer</h2>
<table border="1">
<tr>
    <th> Name Customer</th>
    <th> Birth OF Date</th>
    <th> Address</th>
    <th> Photo</th>
</tr>
    <c:forEach var="customer" items="${list}">
        <tr>
            <td><c:out value="${customer.nameCustomer}"></c:out></td>
            <td>${customer.dateOfbirth}</td>
            <td>${customer.address}</td>
            <td><img style="width: 70px;height: 70px" src="<c:out value=" ${customer.photo}" />"></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
