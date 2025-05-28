<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Browse Products</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS (optional) -->
    <link rel="stylesheet" href="/css/style.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Available Products</h3>
        </div>
        <div class="card-body">
            <table class="table table-striped table-bordered text-center">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price (₹)</th>
                        <th>Warranty</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.warranty}</td>
                            <td>
                                <a href="/order/place?productId=${product.id}" class="btn btn-sm btn-success">Place Order</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/dashboard" class="btn btn-secondary mt-3">Back to Dashboard</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>














<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Browse Products</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <h2>Available Products</h2>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price (₹)</th>
            <th>Warranty</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.warranty}</td>
                <td>
                    <a href="/order/place?productId=${product.id}">Place Order</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="/dashboard">Back to Dashboard</a>
</body>
</html> -->
