<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Place Order</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body class="container mt-5">

    <h2>Place Order</h2>

    <form action="/order/submit" method="post">
        <input type="hidden" name="productId" value="${product.id}" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    
        <p><strong>Product:</strong> ${product.name}</p>
        <p><strong>Price:</strong> ₹${product.price}</p>
        <p><strong>Warranty:</strong> ${product.warranty}</p>
    
        <label>Quantity:</label>
        <input type="number" name="quantity" min="1" required />
    
        <br><br>
        <button type="submit">Submit Order</button>
    </form>
    

    <br>
    <a href="/buyer/products">Back to Products</a>
</body>
</html>









<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Place Order</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <h2>Place Order</h2>

    <form action="/buyer/order/confirm" method="post">
        <input type="hidden" name="productId" value="${product.id}" />

        <p><strong>Product Name:</strong> ${product.name}</p>
        <p><strong>Price:</strong> ₹${product.price}</p>
        <p><strong>Warranty:</strong> ${product.warranty}</p>

        <label for="quantity">Quantity:</label>
        <input type="number" name="quantity" min="1" required />

        <br/><br/>
        <input type="submit" value="Confirm Order" />
    </form>

    <br/>
    <a href="/buyer/products">Back to Products</a>
</body>
</html> -->
