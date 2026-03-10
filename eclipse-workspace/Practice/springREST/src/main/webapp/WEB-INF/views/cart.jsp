<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h2>Cart</h2>

<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Total</th>
</tr>

<c:forEach var="item" items="${cartItems}">
<tr>
    <td>${item.product.name}</td>
    <td>${item.product.price}</td>
    <td>${item.quantity}</td>
    <td>${item.totalPrice}</td>
</tr>
</c:forEach>

</table>

<h3>Total Amount: ${total}</h3>

<a href="products">Back to Products</a>

</body>
</html>