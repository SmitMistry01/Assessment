<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h2>Products</h2>

<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Action</th>
</tr>

<c:forEach var="product" items="${products}">
<form action="add" method="post">
<tr>
    <td>${product.name}</td>
    <td>${product.price}</td>
    <td><input type="number" name="quantity" value="1"/></td>
    <td>
        <input type="hidden" name="productId" value="${product.id}"/>
        <input type="submit" value="Add to Cart"/>
    </td>
</tr>
</form>
</c:forEach>

</table>

<a href="cart">View Cart</a>

</body>
</html>