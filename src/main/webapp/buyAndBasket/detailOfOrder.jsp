<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<input name="name"/><br><br>
	<label>Mail</label><br>
	<input name="mail"/><br><br>
	<label><fmt:message key="orderDetail.Phone"/></label><br>
	<input name="phone"/><br><br>
	<label><fmt:message key="orderDetail.Address"/></label><br>
	<input name="address"/><br><br>
	<label><fmt:message key="orderDetail.Payment"/></label><br>
	<input type="radio" name="payment" value="0"/> <fmt:message key="orderDetail.Payment.Card.Now"/>
	<br>
	<input type="radio" name="payment" value="1"/> <fmt:message key="orderDetail.Payment.Card.Leter"/>
	<br>
	<input type="radio" name="payment" value="2"/> <fmt:message key="orderDetail.Payment.Pay.Money"/>
	<br>
	<br><br>
	<input type="submit" value=<fmt:message key="Next"/>>
</form>
<td colspan="2">
	<a href="${pageContext.request.contextPath}/"><fmt:message key="Return"/></a>
</td>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</body>
</html>
