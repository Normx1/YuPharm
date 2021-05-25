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
<h3> ${sessionScope.user.name} Orders</h3>
<br><br>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>ID Order</th>
		<th>Drug</th>
 		<th>Mail</th>
		<th>Phone</th>
		<th>Address</th>
		<th>Payment</th>
		<th>Cost</th>
	</tr>
	<c:forEach var="Order" items="${requestScope.orderList}">
		<tr>
			<td>${Order.id}</td>
			<td>${Order.drugs}
				<table>
					<c:forEach var="d" items="${Order.drugs.entrySet()}">
						<tr>
							<td>${applicationScope.drugs.findById(d.key).name()}</td>
							<td>${d.value}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
 			<td>${Order.mail}</td>
			<td>${Order.phone}</td>
			<td>${Order.address}</td>
			<td>${Order.cost}</td>
			<td>${Order.payment}</td>
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
					<td><a href="/UserOrders?page=${i}">${i}</a></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tr>
</table>
<br>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
	<td><a href="/UserOrders?page=${currentPage - 1}">Previous</a></td>
</c:if>
<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
	<td><a href="${pageContext.request.contextPath}/UserOrders?page=${currentPage + 1}">Next</a></td>
</c:if>
<br><br>

<td colspan="2">

	<a href="${pageContext.request.contextPath}/userInfo"/>Return</a>
</td>
<br>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</body>
</html>
