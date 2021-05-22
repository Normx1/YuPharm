<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>

<body>
<jsp:include page="../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../WEB-INF/otherElements/_menu.jsp"/>
<h2>Your order is successfully confirmed!</h2>
<h3>Our operator will call you soon</h3>
<table border="1" cellpadding="5" cellspacing="1">
	<h3>Your order is № ${sessionScope.idOfOrder} </h3>
	<tr>
		<%--		<th>№</th>--%>
		<th>Name</th>
		<th><fmt:message key="userBasket.Cost"/></th>
		<th><fmt:message key="userBasket.Recipe"/></th>
	</tr>
	<c:forEach var="cure" items="${requestScope.cures}">
		<tr>
			<td>${cure.name()}</td>
			<td>${cure.cost()}</td>
			<td>${cure.recipe()}</td>
		</tr>
	</c:forEach>

</table>
<br>
<h3><fmt:message key="userBasket.Address"/>:</h3>
<br>
<td rowspan="${applicationScope.drugs.all().size()}">${sessionScope.order.address}</td>
<br>
<br>
<td colspan="2"><a href="${pageContext.request.contextPath}/"><fmt:message key="Return"/></a></td>

<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</body>
</html>
