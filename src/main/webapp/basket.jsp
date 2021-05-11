<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 11.05.2021
  Time: 17:18
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
	<h3>Your basket</h3>
</div>
<table border="1" cellpadding="5" cellspacing="1">

	<tr>
		<th>№</th>
		<th>Name</th>
		<th>Count</th>
		<th>Cost</th>
		<th>Recipe</th>
		<th>Info</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="drug" items="${requestScope.drugs}">
		<tr>
			<td>${drug.id}</td>
			<td>${drug.name}</td>
			<td>${drug.count}</td>
			<td>${drug.cost} $</td>
			<td>
				<div align="center"> ${drug.recipe}
				</div>
			</td>
			<td>
				<a href='<c:url value="drug/drugInfo?id=${drug.id}"/>'>Details</a>

			</td>
			<td>
				<form method="post" action='<c:url value="" />' style="display:inline;">
					<input type="hidden" name="id" value="${drug.id}">
					<input type="submit" value="Delete">
				</form>
		</tr>

	</c:forEach>
</table>
<br><br>
<form method="post" action='<c:url value="/drugBuy"/>' style="display:inline;">
	<input type="hidden" name="drug_id" value="${drug.id}">
	<input type="submit" value="Add to basket">
</form>
<br>
<td colspan="2">

	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
<br>
<table>
	<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</table>

</body>
</html>
