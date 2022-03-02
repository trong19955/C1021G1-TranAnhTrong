<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/1/2022
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<h1 style="color: crimson">CALCULATOR</h1>
<form method="post" action="/calculator">
  <input name="number1" value="" type="text" placeholder="">
  <input name="number2" value="" type="text" placeholder="">
  <input type="submit" value="Addition (+)" name="calculator"/>
  <input type="submit" value="Subtraction (-)" name="calculator"/>
  <input type="submit" value="Multiplication (*)" name="calculator"/>
  <input type="submit" value="Division (/)" name="calculator"/>

</form>
${result}
</body>
</html>