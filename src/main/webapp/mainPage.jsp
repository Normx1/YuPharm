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
	<fmt:message key="_menu.hi"/> <b>${sessionScope.user.name} </b>
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
<p style="color: red;">${errorString}</p>
<table border="1" cellpadding="5" cellspacing="1">

	<tr>
		<th><fmt:message key="userBasket.№"/></th>
		<th><fmt:message key="userBasket.Id"/></th>
		<%--		<th>Count</th>--%>
		<th><fmt:message key="userBasket.Cost"/></th>
		<th><fmt:message key="userBasket.Recipe"/></th>
		<th><fmt:message key="details"/></th>
		<th><fmt:message key="Basket"/></th>
	</tr>
	<c:forEach var="Order" items="${applicationScope.drug}">
		<tr>
			<td>${Order.id()}</td>
			<td>${Order.name()}</td>
				<%--			<td>${drug.count()}</td>--%>
			<td>${Order.cost()} $</td>
			<td>
				<c:set var="recipe" scope="session" value="${Order.recipe()}"/>
				<c:if test="${recipe == 1}">
					<div align="center"><fmt:message key="recipe.Yes"/></div>
				</c:if>
				<c:if test="${recipe == 0}">
					<div align="center"><fmt:message key="recipe.No"/></div>
				</c:if>
			</td>
			<td><a href='<c:url value="/all/drug/info?id=${Order.id()}"/>'><fmt:message key="details"/></a></td>
			<td>
				<form method="post" action='<c:url value="/drugBuy"/>' style="display:inline;">
					<input type="hidden" name="drug_id" value="${Order.id()}">
					<input type="submit" value=<fmt:message key="AddToBasket"/>>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
	<tr>
		<c:forEach begin="1" end="${applicationScope.noOfPages}" var="i">
			<c:choose>
				<c:when test="${applicationScope.currentPage eq i}">
					<td>${i}</td>
				</c:when>
				<c:otherwise>
					<td><a href="${pageContext.request.contextPath}/?page=${i}">${i}</a></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tr>
</table>
<br>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
	<td><a href="/?page=${currentPage - 1}">Previous</a></td>
</c:if>
<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
	<td><a href="${pageContext.request.contextPath}/?page=${currentPage + 1}">Next</a></td>
</c:if>
<br><br>
<table>
	<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</table>
</body>
</html>
