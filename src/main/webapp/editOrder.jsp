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
	<label>Id Order</label><br>
	<input name="id_Order" value="${order.id_Order}"/>
	<br><br>
	<label>Drug</label><br>
	<input name="drug" value="${order.drug}" />
	<br><br>
	<label>User</label><br>
	<input name="user" value="${order.user}" />
	<br><br>

	<label>Count</label><br>
	<input name="count" value="${order.count}" />
	<br><br>

	<label>Cost</label><br>
	<input name="cost" value="${order.cost}" />
	<br><br>


<input type="hidden" name="id_order" value="${order.id_Order}">
<input type="submit" value="Save"/>|
<td colspan ="2">

	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
</form>
<br><br>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>

 </html>