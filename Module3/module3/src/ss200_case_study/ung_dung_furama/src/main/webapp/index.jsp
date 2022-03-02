<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/16/2022
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
  <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<form>
  <div class="container-fluid ">
    <div class="border border-3 row">
      <div class="col-lg-6">
        <img style="width: 75px"
             src="#">
      </div>
      <div class="col-lg-6 mt-lg-3 pe-lg-5">
        <a href="#" class="nav-link float-lg-end">Nguyen Van A</a>
      </div>
    </div>
    <div class="border border-3 row">
      <div class="col-lg-9 row float-lg-end">
        <p class="col-lg-2"></p>
        <a class="nav-link col-lg-2" href="#">Home</a>
        <a class="nav-link col-lg-2" href="/employee">Employee</a>
        <a class="nav-link col-lg-2" href="http://localhost:8080/customer">Customer</a>
        <a class="nav-link col-lg-2" href="/service">Service</a>
        <a class="nav-link col-lg-2" href="#">Contact</a>
      </div>
      <div class="col-lg-3 pt-lg-1">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
             viewBox="0 0 16 16">
          <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
        </svg>
        <input class="rounded-pill w-75" type="text" placeholder=" search">
      </div>
    </div>
    <div class="border border-3 row h-75">
      <div class="col-lg-3 border border-3">
        <a class="nav-link " href="#">Item 1</a>
        <a class="nav-link " href="#">Item 2</a>
        <a class="nav-link " href="#">Item 3</a>
      </div>
      <div class="col-lg-9 text-center">
        Body
      </div>
    </div>
    <div class="border border-3 row text-center">
      <p>Footer</p>
    </div>
  </div>
</form>

<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.min.js"></script>
<script src="/static/bootstrap413/js/bootstrap.bundle.js"></script>


</body>
</html>