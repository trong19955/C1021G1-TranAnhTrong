<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/3/2022
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Declaration</title>
</head>
<body>
<h1>Settings</h1>
<a style="margin:auto" href="/create">Back to Setting</a>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Year Of Birth</th>
        <th>Gender</th>
        <th>Nationality</th>
        <th>Identity Card Number</th>
        <th>Travel Information</th>
        <th>Seats</th>
        <th>DepartureDay</th>
        <th>End Date</th>
        <th>Question And Answer 14 Day</th>
        <th>Conscious</th>
        <th>District</th>
        <th>Commune</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Symptom</th>
        <th>Exposure History</th>
    </tr>
    <c:forEach items="${medicals}" var="medicals" varStatus="list">
        <tr>
            <td>${list.count}</td>
            <td>${medicals.name}</td>
            <td>${medicals.yearOfBirth}</td>
            <td>${medicals.gender}</td>
            <td>${medicals.nationality}</td>
            <td>${medicals.identityCardNumber}</td>
            <td>${medicals.travelInformation}</td>
            <td>${medicals.vehicleNumber}</td>
            <td>${medicals.seats}</td>
            <td>${medicals.departureDay}</td>
            <td>${medicals.endDate}</td>
            <td>${medicals.questionAndAnswer14Day}</td>
            <td>${medicals.conscious}</td>
            <td>${medicals.district}</td>
            <td>${medicals.commune}</td>
            <td>${medicals.address}</td>
            <td>${medicals.phone}</td>
            <td>${medicals.email}</td>
            <td>${medicals.symptom}</td>
            <td>${medicals.exposureHistory}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>