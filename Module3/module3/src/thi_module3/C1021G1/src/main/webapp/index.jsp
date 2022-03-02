<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/24/2022
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
  <meta name='viewport' content='width=device-width, initial-scale=1'>
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<h1 align="center"> PRODUCT</h1>
<form action="/product?action=searchName" method="post" align="center">
  <button action="/product?action=search"  type="submit">Search</button>
  <input type="text" name="name" placeholder="name product">
</form>
<a class="btn btn-success" href="/product?action=list"><i class="material-icons">&#xe8ba;</i>PRODUCT MAIN</a>
<table id="product" class="table table-striped table-bordered" style="width:70% ">
  <thead>
  <tr>
    <th scope="col">Id</th>
    <th scope="col">Name</th>
    <th scope="col">Price</th>
    <th scope="col">Quantity</th>
    <th scope="col">Color</th>
    <th scope="col">Category</th>
    <th scope="col">Action</th>
  </tr>
  </thead>
</table>
<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>

<script>
  $(document).ready(function () {
    $('#product').DataTable({
              "pageLength": 5
            }
    );
  });
</script>
</body>
</html>
