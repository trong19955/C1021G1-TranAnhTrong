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

</head>
<body>
<h1 align="center"> PRODUCT</h1>
<form action="/product?action=searchName" method="post" align="center">
    <button type="submit">Search</button>
    <input type="text" name="name" placeholder="name product">
</form>
<form action="/product?action=searchId" method="post" align="center">
    <button type="submit">Search</button>
    <input type="text" name="id" placeholder="Id product">
</form>
<a class="btn btn-success" href="/product?action=create">Add new product</a>
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
    <tbody>
    <c:forEach var="product" items='${requestScope["product"]}'>
        <tr>

            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.nameCategory}</td>
            <td>
                <button class="btn btn-warning"><a href="/product?action=edit&id=${product.id}"><i
                        style='font-size:24px' class='fas'>&#xf044;</i>Edit</a></button>
                <button onclick="deleteCustomer('${product.id}','${product.name}')" type="button"
                        class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                    <i class="material-icons">&#xe872;</i>Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure delete <span class="text-danger" id="name"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>


<form hidden id="form-delete" method="post" action="/product">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="id">
</form>


<script>
    function deleteCustomer(id, name) {
        document.getElementById("id").value = id;
        document.getElementById("name").innerText = name;
    }

    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>


<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap413/js/popper.min.js"></script>
<%--<script src="/static/datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>--%>
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