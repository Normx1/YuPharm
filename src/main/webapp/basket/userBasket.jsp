<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="1">
	<h2><fmt:message key="userBasket.Your_order"/>
	</h2>
	<tr>
		<th><fmt:message key="userBasket.№"/></th>
		<th><fmt:message key="userBasket.OrdrId"/></th>
		<th><fmt:message key="userBasket.UserId"/></th>
		<th><fmt:message key="userBasket.Count"/></th>
		<th><fmt:message key="userBasket.Cost"/></th>
		<th><fmt:message key="userBasket.Recipe"/></th>
		<th><fmt:message key="userBasket.Address"/></th>
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
			<td><a href='<c:url value="/drug/edit?id=${drugs.id}"/>'>Edit</a></td>
			<td>

				<form method="post" action='<c:url value="/drug/delete"/>' style="display:inline;">
					<input type="hidden" name="id" value="${drugs.id}">
					<input type="submit" value="<fmt:message key="Delete" />">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
