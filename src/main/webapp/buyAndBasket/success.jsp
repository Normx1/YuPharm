<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<h3>Your order is № ${sessionScope.order.id_Order} </h3>
	<tr>
<%--		<th>№</th>--%>
		<th>Name</th>
		<th><fmt:message key="userBasket.Cost"/></th>
		<th><fmt:message key="userBasket.Recipe"/></th>
		<th><fmt:message key="userBasket.Address"/></th>
	</tr>
	<c:forEach var="order" items="${sessionScope.order.all()}">
		<tr>
			<td>${order.name()}</td>
			<td>${order.cost()}</td>
			<td>${order.recipe()}</td>
			<td rowspan="${applicationScope.drugs.all().size()}">${sessionScope.order.address}</td>
		</tr>
	</c:forEach>

</table>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</body>
</html>
