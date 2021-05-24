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
<jsp:include page="../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../WEB-INF/otherElements/_menu.jsp"/>
<h3>Orders</h3>
<br>
<form method="get" action='<c:url value="/admin/createOrder" />' style="display:inline;">
	<input type="submit" value="Create New">
</form>
<br><br>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>ID Order</th>
		<th>Drug</th>
		<th>User name</th>
		<th>Mail</th>
		<th>Phone</th>
		<th>Address</th>
		<th>Payment</th>
		<th>Cost</th>
		<th>Action</th>
	</tr>
	<c:forEach var="Order" items="${requestScope.orders}">
		<tr>
			<td>${Order.id}</td>
			<td>${Order.drugs}</td>
			<td>${Order.user}</td>
			<td>${Order.mail}</td>
			<td>${Order.phone}</td>
			<td>${Order.address}</td>
			<td>${Order.cost}</td>
			<td>${Order.payment}</td>
			<td>
				<a href='<c:url value="/admin/order/edit?id=${Order.id}" />'>Edit</a> |
				<form method="post" action='<c:url value="/admin/order/delete" />' style="display:inline;">
					<input type="hidden" name="id_Order" value="${Order.id}">
					<input type="submit" value="Delete">
				</form>
		</tr>
	</c:forEach>
</table>
<br>
<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
	<tr>
		<c:forEach begin="1" end="${noOfPages}" var="i">
			<c:choose>
				<c:when test="${currentPage eq i}">
					<td>${i}</td>
				</c:when>
				<c:otherwise>
					<td><a href="/admin/allOrders?page=${i}">${i}</a></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tr>
</table>
<br>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
	<td><a href="/admin/allOrders?page=${currentPage - 1}">Previous</a></td>
</c:if>
<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
	<td><a href="${pageContext.request.contextPath}//admin/allOrders?page=${currentPage + 1}">Next</a></td>
</c:if>
<br><br>
<td colspan="2">

	<a href="${pageContext.request.contextPath}/admin/allOrders">To Admin main page</a>
</td>

<td colspan="2">

	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
<br>

<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>

</body>
</html>
