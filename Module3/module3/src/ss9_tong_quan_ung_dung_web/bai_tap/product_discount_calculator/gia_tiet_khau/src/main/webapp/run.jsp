<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/25/2022
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Discount Amount: <%=request.getAttribute("discountAmount")%>
<br>
Discount Price: <%=request.getAttribute("discountPrice")%>
</body>
</html>
