<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.min.css">
</head>

<body>
<h1> CREATE PRODUCT</h1>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/product?action=create" method="post">
                <div class="form-group">
                    <label for="name">Name Product</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="price">Price Product</label>
                    <input type="text" class="form-control" id="price" name="price">
                </div>

                <div class="form-group">
                    <label for="quantity">Quantity Product</label>
                    <input type="text" class="form-control" id="quantity" name="quantity">
                </div>
                <div class="form-group">
                    <label for="color">Color Product</label>
                    <input type="text" class="form-control" id="color" name="color">
                </div>

                <div class="form-group">
                    <label for="category">Product Type</label>
                    <select class="form-control" id="category" name="id_category">
                        <c:forEach var="type" items="${categoryList}">
                            <option value="${type.idCategory}">${type.nameCategory}</option>
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