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
<body>
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>
<h3>Edit medicine: ${recipe.recId} </h3>
<form method="post" action="/recipe/edit">

	<label>Drug ID</label><br>
	<input  required name="drugId" value="${recipe.drugId}"/>
	<br><br>
	<label>User ID</label><br>
	<input required name="userId" value="${recipe.userId}"/>
	<br><br>

	<label>Expiration Date</label><br>
	<input required name="expDate" value="${recipe.expDate}"/>
	<br> <br>

	<label> Count </label><br>
	<input required name="recipeCount" value="${recipe.recipeCount}"/>
	<br><br>

	<input type="hidden" name="recId" value="${recipe.recId}">
	<input type="submit" value="Save"/>|
	<td colspan="2">

		<a href="${pageContext.request.contextPath}/">Cancel</a>
	</td>
</form>
<br><br>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>

</html>
