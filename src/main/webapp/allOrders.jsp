<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 10.05.2021
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>All Orders</title>
</head>
<body>
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>
<h3>Orders</h3>
<br>
 <form method="get" action='<c:url value="/createOrder" />' style="display:inline;">
 	<input type="submit" value="Create New">
</form>
<br><br>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>ID Order</th>
		<th>Drug</th>
		<th>User</th>
		<th>Count</th>
		<th>Cost</th>
 		<th>Action</th>
	</tr>
	<c:forEach var="order" items="${requestScope.order}">
		<tr>
			<td>${order.id_Order}</td>
			<td>${order.drug}</td>
			<td>${order.user}</td>
			<td>${order.count}</td>
			<td>${order.cost}</td>
	 			 			<td>
				<a href='<c:url value="order/edit?id=${order.id_Order}" />'>Edit</a> |
				<form method="post" action='<c:url value="/order/delete" />' style="display:inline;">
					<input type="hidden" name="id_Order" value="${order.id_Order}">
					<input type="submit" value="Delete">
				</form>
		</tr>
	</c:forEach>
</table>
<br>
<td colspan ="2">

	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
<br>

<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>

</body>
</html>
