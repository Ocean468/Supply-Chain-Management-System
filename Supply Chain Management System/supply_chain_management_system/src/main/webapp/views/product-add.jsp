<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Add Product</h2>
    
    <form:form method="post" action="/products/add" modelAttribute="product">
        <div class="mb-3">
            <label for="name" class="form-label">Product Name</label>
            <form:input path="name" cssClass="form-control" id="name" required="true" />
        </div>
        
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <form:input path="description" cssClass="form-control" id="description" required="true" />
        </div>
        
        <div class="mb-3">
            <label for="price" class="form-label">Price (₹)</label>
            <form:input path="price" cssClass="form-control" id="price" type="number" required="true" />
        </div>
        
        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity</label>
            <form:input path="quantity" cssClass="form-control" id="quantity" type="number" required="true" />
        </div>

        <div class="mb-3">
            <label for="warranty" class="form-label">Warranty</label>
            <form:input path="warranty" cssClass="form-control" id="warranty" required="true" />
        </div>

        <button type="submit" class="btn btn-success">Add Product</button>
        <a href="/products" class="btn btn-secondary">Cancel</a>
    </form:form>
</div>
</body>
</html>
