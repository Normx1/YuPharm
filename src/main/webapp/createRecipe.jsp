<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 15.05.2021
  Time: 14:49
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
<br>
<h3>New Recipe</h3>
<form method="post" action="/createRecipe">
	<label>Drug Id</label><br>
	<input name="drugId"/><br><br>
	<label>User Id</label><br>
	<input name="userId"/><br><br>
	<label>Expiration Date</label><br>
	<input name="expirationDate"/><br><br>
	<label>Count</label><br>
	<input name="recipeCount"/><br><br>
	<input type="submit" value="Save"/>
</form>
<td colspan ="2">
	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
</body>
</html>
