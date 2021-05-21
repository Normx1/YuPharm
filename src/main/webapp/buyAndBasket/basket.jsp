<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
<jsp:include page="../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../WEB-INF/otherElements/_menu.jsp"/>
<div align="left">
	<h2><fmt:message key="Basket"/></h2>
</div>
<br>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>Id</th>
		<th><fmt:message key="basket.Name"/></th>
		<th><fmt:message key="basket.Cost"/></th>
		<th><fmt:message key="basket.Recipe"/></th>
		<th><fmt:message key="basket.Info"/></th>
		<th><fmt:message key="Delete"/></th>
	</tr>
	<c:forEach var="cure" items="${sessionScope.cure}">
		<tr>
			<td>${cure.id()}</td>
			<td>${cure.name()}</td>
			<td>${cure.cost()} $</td>
			<td>
				<c:set var="recipe" scope="session" value="${cure.recipe()}"/>
				<c:if test="${recipe == 1}">
					<div align="center"><fmt:message key="recipe.Yes"/></div>
				</c:if>
				<c:if test="${recipe == 0}">
					<div align="center"><fmt:message key="recipe.No"/></div>
				</c:if>

			</td>
			<td>
				<a href='<c:url value="drug/info?id=${cure.id()}"/>'><fmt:message key="details"/></a>

			</td>
			<td>
				<form method="get" action='<c:url value="/remove/basket" />' style="display:inline;">
					<input type="hidden" name="id" value="${cure.id()}">
					<input align="center" type="submit" value=<fmt:message key="Delete"/>>
				</form>
			</td>
		</tr>
	</c:forEach>

</table>
<table>
	<tr>
		<td>
			<h2>
				<fmt:message key="totalCost"/> ${totalCost}$
		</td>
		<td>
			<form method="get" action='<c:url value="createUserOrder"/>' style="display:inline;">
				<input type="hidden" name="cure" value="${sessionScope.cure}">
				<input type="submit" value=<fmt:message key="Basket.buy"/>>

			</form>
		</td>
	</tr>
</table>

<form>
	<a href="${pageContext.request.contextPath}/"><fmt:message key="Return"/></a>
	<jsp:include page="/WEB-INF/otherElements/_footer.jsp"/>

</form>
</body>
</html>
