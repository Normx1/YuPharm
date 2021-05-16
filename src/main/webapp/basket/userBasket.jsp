<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="1">
	<h2>Your order</h2>
	<tr>
		<th>№</th>
		<th>Order id</th>
		<th>User id</th>
		<th>Id drug</th>
		<th>Count</th>
		<th>Cost</th>
		<th>Recipe</th>
		<th>Address</th>
	</tr>
	<c:forEach var="drugs" items="${requestScope.drugs}">
		<tr>
			<th></th>
			</td>
			<td>${drugs.id}</td>
			<td>${drugs.name}</td>
			<td>${drugs.count}</td>
			<td>${drugs.cost}</td>
			<td>${drugs.recipe}</td>
			<td>				<a href='<c:url value="/drug/edit?id=${drugs.id}"/>'>Edit</a>			</td>
			<td>
				<form method="post" action='<c:url value="/drug/delete"/>' style="display:inline;">
					<input type="hidden" name="id" value="${drugs.id}">
					<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
