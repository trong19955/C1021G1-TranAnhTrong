<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/1/2022
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Sandwich Condiments</h1>
  <form method="post">
    <div class="condiment">
      <input id="radio-1" name="condiment" value="lettuce" type="checkbox">
      <label for="radio-1" class="radio-label">Lettuce</label>
    </div>
    <div class="condiment">
      <input id="radio-2" name="condiment" value="tomato" type="checkbox">
      <label for="radio-2" class="radio-label">Tomato</label>
    </div>
    <div class="condiment">
      <input id="radio-3" name="condiment"  value="mustard" type="checkbox" >
      <label for="radio-3" class="radio-label">Mustard</label>
    </div>
    <div class="condiment">
      <input id="radio-4" name="condiment" type="checkbox" value="sprouts">
      <label for="radio-4" class="radio-label">Sprouts</label>
    </div>
    <input type="submit" name="save" value="submit"/>
  </form>
<p>danh sách gia vị đã chọn: </p>
  <c:forEach var="condiment" items="${result}">
      ${condiment}
  </c:forEach>
  </body>
</html>
