<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/19/2022
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h1> CREATE CUSTOMER</h1>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/customer?action=create" method="post">
                <div class="form-group">
                    <label for="customer-code">Code Customer</label>
                    <input type="text" class="form-control" id="customer-code" name="customer_code">
                </div>
                <div class="form-group">
                    <label for="customer-name">Name Customer</label>
                    <input type="text" class="form-control" id="customer-name" name="customer_name">
                </div>
                <div class="form-group">
                    <label for="customer-birthday">Birthday</label>
                    <input type="date" class="form-control" id="customer-birthday" name="customer_birthday">
                </div>
                <div class="form-group">
                    <label for="customer-gender">Gender Customer</label>
                    <input type="text" class="form-control" id="customer-gender" name="customer_gender">
                </div>
                <div class="form-group">
                    <label for="customer-id-card">Id Card Customer</label>
                    <input type="text" class="form-control" id="customer-id-card" name="customer_id_card">
                </div>
                <div class="form-group">
                    <label for="customer-phone">Phone</label>
                    <input type="text" class="form-control" id="customer-phone" name="customer_phone">
                </div>
                <div class="form-group">
                    <label for="customer-email">Email</label>
                    <input type="text" class="form-control" id="customer-email" name="customer_email">
                </div>
                <div class="form-group">
                    <label for="customer-address">Address</label>
                    <input type="text" class="form-control" id="customer-address" name="customer_address">
                </div>
                <div class="form-group">
                    <label for="category">CustomerType</label>
                    <select class="form-control" id="category" name="customer_type_id">
                        <c:forEach var="type" items="${customerTypeList}">
                            <option value="${type.idCustomerType}">${type.nameCustomerType}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
