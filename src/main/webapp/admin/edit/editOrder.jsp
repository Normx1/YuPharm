<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 10.05.2021
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<jsp:include page="../../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../../WEB-INF/otherElements/_menu.jsp"/>
<h3>Edit order:</h3>
<form method="post" action="/order/edit">

	<br><br>
	<label>Drug</label><br>
	<input required name="drugs" value="${order.drugs}"/>
	<br><br>
	<label>User</label><br>
	<input required name="user" value="${order.user}"/>
	<br><br>
	<label>Mail</label><br>
	<input required name="mail" value="${order.mail}"/>
	<br><br>
	<label>Phone</label><br>
	<input required name="phone" value="${order.phone}"/>
	<br><br>
	<label>Address</label><br>
	<input required name="address" value="${order.address}"/>
	<br><br>
	<label>Address</label><br>
	<input required name="payment" value="${order.payment}"/>
	<br><br>
	<label>Cost</label><br>
	<input required name="cost" value="${order.cost}"/>
	<br><br>

	<input type="hidden" name="id_order" value="${order.id}"/>
	<input type="submit" value="Save"/>|
	<td colspan="2">
		<a href="/allOrders">Return</a>
	</td>
</form>
<br><br>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>

</html>
