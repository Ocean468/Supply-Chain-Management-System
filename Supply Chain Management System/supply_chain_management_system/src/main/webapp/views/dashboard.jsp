<!-- <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Supply Chain</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Supply Chain Dashboard</a>
        <div class="ms-auto">
            <a href="/logout" class="btn btn-outline-light">Logout</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <h2>Welcome to your Dashboard!</h2>
    <p>This is a protected page visible only after login.</p>

    <div class="card mt-4">
        <div class="card-body">
            <h5>What do you want to do?</h5>
            <ul>
                <li>View Products</li>
                <li>Place Orders</li>
                <li>Track Shipments</li>
                <li>More to come...</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html> -->





<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">

    <h2 class="mb-4">Welcome to Supply Chain Dashboard</h2>

    <sec:authorize access="hasAuthority('FARMER')">
        <div class="alert alert-success">You are logged in as <strong>FARMER</strong></div>
        <a href="/products" class="btn btn-primary">Manage Products</a>
    </sec:authorize>

    <sec:authorize access="hasAuthority('BUYER')">
        <div class="alert alert-info">You are logged in as <strong>BUYER</strong></div>
        <a href="/buyer/products" class="btn btn-success">Browse Products</a>
        <a href="/order/place" class="btn btn-warning">Place Order</a>

    </sec:authorize>

    <sec:authorize access="hasAuthority('ADMIN')">
        <div class="alert alert-warning">You are logged in as <strong>ADMIN</strong></div>
        <a href="/admin/users" class="btn btn-danger">Manage Users</a>
    </sec:authorize>

    <hr>
    <a href="/login" class="btn btn-outline-secondary">Logout</a>
</div>
</body>
</html>
