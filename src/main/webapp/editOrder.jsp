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
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>
<h3>Edit medicine:</h3>
<form method="post" action="/order/edit">

	<br><br>
	<label>Drug</label><br>
	<input name="drug" value="${order.drug}" />
	<br><br>
	<label>User</label><br>
	<input name="user" value="${order.user}" />
	<br><br>
	<label>Mail</label><br>
	<input name="mail" value="${order.mail}" />
	<br><br>
	<label>Phone</label><br>
	<input name="phone" value="${order.phone}" />
	<br><br>
	<label>Address</label><br>
	<input name="address" value="${order.address}" />
	<br><br>
	<label>Address</label><br>
	<input name="payment" value="${order.payment}" />
	<br><br>
	<label>Cost</label><br>
	<input name="cost" value="${order.cost}" />
	<br><br>

<input type="hidden" name="id_order" value="${order.id_Order}"/>
<input type="submit" value="Save"/>|
<td colspan ="2">

c</td>
</form>
<br><br>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>

 </html>
