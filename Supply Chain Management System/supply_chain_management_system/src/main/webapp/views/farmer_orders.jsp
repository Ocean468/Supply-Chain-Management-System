<html>
<head><title>Farmer Orders</title></head>
<body>
    <h2>Orders on Your Products</h2>

    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Product</th>
            <th>Buyer</th>
            <th>Quantity</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.product.name}</td>
                <td>${order.buyer.username}</td>
                <td>${order.quantity}</td>
                <td>${order.status}</td>
                <td>
                    <form action="/farmer/order/ship" method="post">
                        <input type="hidden" name="orderId" value="${order.id}"/>
                        <button type="submit">Mark as Shipped</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
