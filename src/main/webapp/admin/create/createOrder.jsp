<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User</title>
</head>
<body>
<jsp:include page="../../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../../WEB-INF/otherElements/_menu.jsp"/>

<h3>New Order</h3>
<form method="post" action="/createOrder">
	<label>Drug</label><br>
	<input required name="drug"/><br><br>
	<label>User</label><br>
	<input required  name="user"/><br><br>
	<label>Mail</label><br>
	<input required name="mail"/><br><br>
	<label>Phone</label><br>
	<input required name="phone"/><br><br>
	<label>Address</label><br>
	<input required name="address"/><br><br>
	<label>Payment</label><br>
	<input required name="payment"/><br><br>
	<label>Cost</label><br>
	<input required name="cost"/><br><br>
	<br>
	<input type="submit" value="Save"/>

</form>
<br><br>
<td colspan="2">
	<a href="/allOrders">Return</a>
</td>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>

</body>
</html>
