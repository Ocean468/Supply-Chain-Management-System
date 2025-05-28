<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Orders</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card">
        <div class="card-header bg-success text-white">
            <h3 class="mb-0">My Orders</h3>
        </div>
        <div class="card-body">
            <table class="table table-bordered table-hover text-center">
                <thead class="table-dark">
                    <tr>
                        <th>Order ID</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Status</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.product.name}</td>
                            <td>${order.quantity}</td>
                            <td>
                                <span class="badge bg-${order.status eq 'SHIPPED' ? 'success' : 'warning'}">
                                    ${order.status}
                                </span>
                            </td>
                            <td>${order.orderDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/dashboard" class="btn btn-secondary mt-3">Back to Dashboard</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>











<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Orders</title>
</head>
<body>
    <h2>My Orders</h2>

    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Product</th>
            <th>Quantity</th>
            <th>Status</th>
            <th>Date</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.product.name}</td>
                <td>${order.quantity}</td>
                <td>${order.status}</td>
                <td>${order.orderDate}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="/dashboard">Back to Dashboard</a>
</body>
</html> -->
