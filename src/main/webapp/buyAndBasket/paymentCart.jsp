<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 15.05.2021
  Time: 18:44
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

<h3><fmt:message key="paymentCart.Title"/></h3>
<form method="post" action="/payment">
	<label>Card number</label><br>
	<input required name="CardNumber"/>
	<br><br>
	<label>Name</label><br>
	<input required name="name"/>
	<br><br>
	<label>Valid to</label><br>
	<input required name="valid"/>
	<br><br>
	<input required type="checkbox" name="rules" value="1" checked/> <fmt:message key="paymentCart.Confirmation"/>
	<br><br>
	<input type="submit" value="<fmt:message key="Basket.buy"/>">

	<h4>Bank card payments are processed and stored through the electronic PayPaid system, </h4>
	<h4> which meets all data transfer security requirements (PCI DSS, level 1).
	</h4>
	<td colspan="2">
		<a href="${pageContext.request.contextPath}/"><fmt:message key="Cancel"/></a>
	</td>
</form>
<br><br>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>

</html>
