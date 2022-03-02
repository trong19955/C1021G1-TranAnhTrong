<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/31/2022
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List Student</h2>
<table border="1">
    <tr>
        <td> Code Student</td>
        <td> Name Student</td>
        <td> Birthday</td>
        <td> Email</td>
        <td> Point</td>
    </tr>

    <c:forEach var="student" items="${list}">
        <tr>
<%--            c:out thì sẽ hiển thị --%>
            <td><c:out value="${student.codeStudent}"></c:out></td>
<%--    hiển thị những sẽ dịch sang html--%>
            <td>${student.nameStudent}</td>
            <td>${student.birthday}</td>
            <td>${student.email}</td>
            <td>${student.point}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
