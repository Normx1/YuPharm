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
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>

<h3>Detail of order</h3>
<form method="post" action="/createUserOrder">
	<label>Name</label><br>
	<input name="name"/><br><br>
	<label>Mail</label><br>
	<input name="mail"/><br><br>
	<label>Phone</label><br>
	<input name="phone"/><br><br>
	<label>Address</label><br>
	<input name="address"/><br><br>
	<label>Choose method of payment</label><br>
	<input type="checkbox" name="payment" value="0" checked/> Pay by Card Now
	<input type="checkbox" name="payment" value="1" checked/> Pay by Card upon delivery
	<input type="checkbox" name="payment" value="2" checked/> Pay by money
	<br><br>
	<input type="submit" value="Submit"/>

</form>
<td colspan="2">
	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</body>
</html>
