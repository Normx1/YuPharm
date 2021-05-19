<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<jsp:include page="WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="WEB-INF/otherElements/_menu.jsp"/>


</div>
<div style=" align: left;">
	<br>
	<!-- User store in session with attribute: loginedUser -->
	<fmt:message key="_menu.hi"/> <b>${loginedUser.name} </b>
	<br/>
	<a href="${pageContext.request.contextPath}/basket"> <fmt:message key="_menu.Basket"/> </a>


</div>
<br>
<div style="align: right;">
	<fmt:message key="_menu.Search"/> <label>
	<input name="search"/>
</label>
</div>

<div align="left">
	<h3><fmt:message key="MainPage.Tittle"/></h3>
</div>
<table border="1" cellpadding="5" cellspacing="1">

	<tr>
 		<th><fmt:message key="userBasket.№"/></th>
		<th><fmt:message key="userBasket.Id"/></th>
<%--		<th>Count</th>--%>
		<th><fmt:message key="userBasket.Cost"/></th>
		<th><fmt:message key="userBasket.Recipe"/></th>
		<th><fmt:message key="details"/></th>
		<th><fmt:message key="buy"/></th>
	</tr>
	<c:forEach var="drug" items="${applicationScope.drugs.all()}">
		<tr>
			<td>${drug.id()}</td>
			<td>${drug.name()}</td>
<%--			<td>${drug.count()}</td>--%>
			<td>${drug.cost()} $</td>
			<td>
				<div align="center"> ${drug.recipe()} </div>
			</td>
			<td><a href='<c:url value="drug/info?id=${drug.id()}"/>'><fmt:message key="details"/></a></td>
			<td>
				<form method="post" action='<c:url value="/drugBuy"/>' style="display:inline;">
					<input type="hidden" name="drug_id" value="${drug.id()}">
					<input type="submit" value=<fmt:message key="AddToBasket"/>>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="WEB-INF/otherElements/_footer.jsp"/>
</body>
</html>
