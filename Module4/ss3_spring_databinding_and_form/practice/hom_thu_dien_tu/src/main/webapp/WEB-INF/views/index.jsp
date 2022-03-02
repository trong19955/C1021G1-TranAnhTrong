<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/2/2022
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<h1>Settings</h1>
<h3 style="color: green">${mess}</h3>
<form:form modelAttribute="" action="/showForm" method="post"> <br>
  <table>
    <tr>
      <td><b>Languages</b></td>
      <td><form:select path="languages" items="${languages}"/></td>
    </tr>
    <tr>
      <td><b>Page Size: </b></td>
      <td>Show <form:select path="pageSize" items="${pageSizes}"/> email per page</td>
    </tr>
    <tr>
      <td><b>Spams filter :</b></td>
      <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
    </tr>
    <tr>
      <td><b>Siganture:</b></td>
      <td><form:textarea path="signature"/></td>
    </tr>
    <tr>
      <td>
      </td>
      <td>
        <button type="submit">Update</button>
        <button>Cancel</button>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>