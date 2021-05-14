<%@ page import="com.yu_pharm.dao.DrugDao" %>
<%@ page import="com.yu_pharm.model.Drug" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>

<div align="left">
	<h3>Cure recipe</h3>
</div>
<body>

<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Count</th>
		<th>Cost</th>
		<th>Recipe</th>
  	</tr>
	<c:forEach var="cure" items="${sessionScope.cure}">
		<tr>
			<td>${cure.id}</td>
			<td>${cure.name}</td>
			<td>${cure.count}</td>
			<td>${cure.cost} $</td>
			<td>
				<div align="center"> ${cure.recipe}
				</div>
			</td>
			<td>
				<a href='<c:url value="drug/drugInfo?id=${cure.id}"/>'>Details</a>

			</td>

		</tr>
	</c:forEach>
</table>
<br><br>


</body>
</html>
