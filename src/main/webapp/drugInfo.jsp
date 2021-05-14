<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 29.04.2021
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Drug Info</title>
</head>
<body>
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>

<h3> Cure:"${drugs.name}"</h3>

<table>
	<tr><label>Name:</label><br>
	<tr>

		<b>${drugs.name}</b>
		<br><br>
		<label>Cost:</label><br>
		<b>${drugs.cost}</b>
		<br><br>
		<label>Count:</label><br>
		<b>${drugs.count}</b>
		<br><br>
		<label>Recipe:</label><br>
		<b>SomeText</b>
		<br><br>
		<label>Main action:</label><br>
		<b>SomeText</b>
		<br><br>
		<label>Description:</label><br>
		<b>SomeText</b>
		<br><br>

		<label>Application:</label><br>
		<b>SomeText</b>
		<br><br>


		<td colspan="2">
			<a href="${pageContext.request.contextPath}/">Return</a>
		</td>
</table>
</body>
</html>
