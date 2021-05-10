<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 10.05.2021
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>
<h3>Edit medicine:</h3>
<form method="post" action="/order/edit">
	<label>Id Order</label><br>
	<input name="id_order" value="${order.id_order}"/>
	<br><br>
	<label>id User</label><br>
	<input name="id_user" value="${order.id_user}" />
	<br><br>
	<label>id Drug</label><br>
	<input name="id_drug" value="${order.id_drug}" />
	<br><br>

	<label>Count</label><br>
	<input name="count" value="${order.count}" />
	<br><br>

	<label>Cost</label><br>
	<input name="cost" value="${order.recipe}" />
	<br><br>

</form>
<br><br>
<input type="hidden" name="id" value="${order.id_order}">

<%--    <label>Description</label><br>--%>
<%--    <input name="description"/><br><br>--%>
<input type="submit" value="Save"/>|
<td colspan ="2">

	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>

 </html>
