<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/28/2022
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1 ALIGN="CENTER"> ỨNG DỤNG CHUYỂN ĐỔI TIỀN TỆ</h1>
  <form method="post" action="/currency">
    <label for="usd">USD:</label>
    <input type="text" id="usd" name="usd"><br><br>
    <input type="submit" value="Submit">
  </form>
  <h3>RESULT :${result}</h3>
  </body>
</html>
