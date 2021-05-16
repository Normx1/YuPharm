<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/otherElements/_header.jsp" />
<div align="left">
	<h2>Basket</h2>
</div>
<br>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Cost</th>
		<th>Recipe</th>
		<th>Info</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="cure" items="${sessionScope.cure}">
		<tr>
			<td>${cure.id()}</td>
			<td>${cure.name()}</td>
			<td>${cure.cost()} $</td>
			<td>
				<div align="center"> ${cure.recipe()}
				</div>
			</td>
			<td>
				<a href='<c:url value="drug/info?id=${cure.id()}"/>'>Details</a>

			</td>
			<td>
				<form method="get" action='<c:url value="/remove/basket" />' style="display:inline;">
					<input type="hidden" name="id" value="${cure.id()}">
					<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
	</c:forEach>

</table>
 	<table>
		<tr>
			<td>
		<h2>Total cost: ${totalCost}$
			</td>
			<td>
	<form method="get" action='<c:url value="createUserOrder"/>' style="display:inline;">
		<input type="hidden" name="cure" value="${sessionScope.cure}">
		<input type="submit" value="Buy">

	</form>
			</td>
		</tr>
	</table>

<form>
	<a href="${pageContext.request.contextPath}/">Return</a>
	<jsp:include page="/WEB-INF/otherElements/_footer.jsp" />

</form>
</body>
</html>
