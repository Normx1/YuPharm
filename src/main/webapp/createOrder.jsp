<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>
<h3>New Order</h3>
<form method="post" action="/createOrder">
    <label>Drug</label><br>
    <input name="drug"/><br><br>
    <label>User</label><br>
    <input name="user"/><br><br>
    <label>Count</label><br>
    <input name="count"/><br><br>
	<label>Cost</label><br>
    <input name="cost"/><br><br>
</form>
<input type="submit" value="Save"/>
<td colspan="2">
	<a href="/allOrders">Return</a>
</td>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>

</body>
</html>
