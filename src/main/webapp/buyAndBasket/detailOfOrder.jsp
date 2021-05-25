<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 15.05.2021
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<jsp:include page="../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../WEB-INF/otherElements/_menu.jsp"/>

<h3><fmt:message key="detaiOfOrder.Title"/></h3>
<form method="post" action="/createUserOrder">
	<label><fmt:message key="orderDetail.name"/></label><br>
	<input required name="name" value="${sessionScope.user.name}"/><br><br>
	<label>Mail:</label><br>
	<input required name="mail", value="${sessionScope.user.mail}"/><br><br>
	<label><fmt:message key="orderDetail.Phone"/></label><br>
	<input required name="phone" pattern="[0-9]{,15}"/><br><br>
	<label><fmt:message key="orderDetail.Address"/></label><br>
	<input required name="address"/><br><br>
	<label><fmt:message key="orderDetail.Payment"/></label><br>
	<%--@elvariable id="Payment" type="com.yu_pharm.model.Payment"--%>
	<%@ page import="com.yu_pharm.model.Payment" %>

	<c:forEach var="payment" items="${Payment.values()}">
		<label>
			<input required type="radio" name="payment" value="${payment.name()}">
			<fmt:message key="${payment.key}"/>
			<br/>
		</label>
	</c:forEach>
	<br/>
	<input type="submit" value=<fmt:message key="Next"/>>
</form>
<td colspan="2">
	<a href="${pageContext.request.contextPath}/"><fmt:message key="Return"/></a>
</td>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"/>
</body>
</html>
