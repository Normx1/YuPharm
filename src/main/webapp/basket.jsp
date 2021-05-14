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
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>

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
			<td>${cure.id}</td>
			<td>${cure.name}</td>
 			<td>${cure.cost} $</td>
 			<td>
				<div align="center"> ${cure.recipe}
				</div>
			</td>
			<td>
				<a href='<c:url value="drug/drugInfo?id=${cure.id}"/>'>Details</a>

			</td>
			<td>
				<form method="get" action='<c:url value="/remove/basket" />' style="display:inline;">
					<input type="hidden" name="id" value="${cure.id}">
					<input type="submit" value="Delete">
				</form>
			</td>

		</tr>
	</c:forEach>
</table>
<form>
	<a href="${pageContext.request.contextPath}/">Return</a>
	<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>

</form>
<br><br>


</body>
</html>
