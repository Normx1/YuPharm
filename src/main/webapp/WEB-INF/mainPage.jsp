<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
<jsp:include page="otherElements/_header.jsp"/>
<jsp:include page="otherElements/_menu.jsp"/>
<div align="left">
	<h3>Cure recipe</h3>
</div>
<table border="1" cellpadding="5" cellspacing="1">

	<tr>
		<th>№</th>
		<th>Name</th>
		<th>Count</th>
		<th>Cost</th>
		<th>Recipe</th>
		<th>info</th>
		<th>Buy</th>
	</tr>
	<c:forEach var="drug" items="${applicationScope.drugs.all()}">
		<tr>
			<td>${drug.id()}</td>
			<td>${drug.name()}</td>
			<td>${drug.count()}</td>
			<td>${drug.cost()} $</td>
			<td>
				<div align="center"> ${drug.recipe()} </div>
			</td>
			<td><a href='<c:url value="drug/info?id=${drug.id()}"/>'>Details</a></td>
			<td>
				<form method="post" action='<c:url value="/drugBuy"/>' style="display:inline;">
					<input type="hidden" name="drug_id" value="${drug.id()}">
					<input type="submit" value="Add to basket">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="otherElements/_footer.jsp"/>
</body>
</html>
