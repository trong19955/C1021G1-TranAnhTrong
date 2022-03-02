<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/15/2022
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
</head>
<body>
<h2>List Student</h2>
<a href="/student?action=create">Create Student</a>
<h2>${message}</h2>
<table border="1" id="c10" class="table table-striped table-bordered" style="width:70%">
    <thead>
    <tr>
        <th>Code Student</th>
        <th>Name Student</th>
        <th>Birthday</th>
        <th>Email</th>
        <th>Point</th>
        <th>Rank</th>
        <th>Edit</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="student" items="${list}">
        <tr>

            <td><c:out value="${student.codeStudent}"></c:out></td>

            <td>${student.nameStudent}</td>
            <td>${student.birthday}</td>
            <td>${student.email}</td>
            <td>${student.point}</td>
            <td>

                <c:choose>
                    <c:when test="${student.point <8}">Good</c:when>
                    <c:when test="${student.point <=10}">Very good</c:when>
                    <c:otherwise>Rank not know</c:otherwise>
                </c:choose>
            </td>
            <td><a href="/student?action=update&codeStudent=${student.codeStudent}">Edit</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#c10').DataTable();
    } );
</script>

</body>
</html>

