<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 15.05.2021
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/otherElements/_menu.jsp"></jsp:include>
<div align="left">
	<h3>Cure recipes</h3>
	<br>
</div>

<p><a href='<c:url value="createRecipe.jsp" />'>Create new recipe</a></p>
<br>

<table border="1" cellpadding="5" cellspacing="1">

	<tr>
		<th>ID</th>
		<th>Drug Id</th>
		<th>User Id</th>
		<th>Expiration Date</th>
		<th>Count</th>
		<th>Action</th>
	</tr>
	<c:forEach var="recipe" items="${requestScope.recipe}">
		<tr>
			<td>${recipe.recId}</td>
			<td>${recipe.drugId}</td>
			<td>${recipe.userId}</td>
			<td>${recipe.expDate} $</td>
			<td>${recipe.recipeCount} $</td>
			<td>
				<a href='<c:url value="/recipe/edit?id=${recipe.recId}" />'>Edit</a> |
				<form method="post" action='<c:url value="/deleteRecipe" />' style="display:inline;">
					<input type="hidden" name="recId" value="${recipe.recId}">
					<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<table>
	<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</table>

</body>
</html>
