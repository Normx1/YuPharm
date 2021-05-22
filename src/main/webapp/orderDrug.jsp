<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 10.05.2021
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<jsp:include page="WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="WEB-INF/otherElements/_menu.jsp"/>
<h3>Your order # ${order.id_Order}</h3>
<br>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>Drug</th>
		<th>Count</th>
		<th>Cost</th>
		<th>Date of order</th>
	</tr>
	<c:forEach var="Order" items="${requestScope.order}">
		<tr>
			<td>${Order.drug}</td>
			<td>${Order.count}</td>
			<td>${Order.cost}</td>
			<td> </td>
		</tr>
	</c:forEach>
</table>
<br>
<td colspan="2">
	<a href="${pageContext.request.contextPath}/">Return</a>
</td>
<br>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</body>
</html>
