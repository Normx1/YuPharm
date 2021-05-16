<%--@elvariable id="drug" type="com.yu_pharm.model.drug.Drug.Smart"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Drug Info</title>
</head>
<body>
<jsp:include page="WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="WEB-INF/otherElements/_menu.jsp"/>
<h3> Cure:"${drug.name()}"</h3>

<table>
	<tr>
		<td>Name:</td>
		<td>${drug.name()}</td>
	</tr>
	<tr>
		<td>Cost:</td>
		<td>${drug.cost()}</td>
	</tr>
	<tr>
		<td>Count:</td>
		<td>${drug.count()}</td>
	</tr>
	<tr>
		<td>Recipe:</td>
		<td>Not implemented yet</td>
	</tr>
	<tr>
		<td>Main action:</td>
		<td>Not implemented yet</td>
	</tr>
	<tr>
		<td>Description:</td>
		<td>Not implemented yet</td>
	</tr>
	<tr>
		<td>Application:</td>
		<td>Not implemented yet</td>
	</tr>
	<tr>
		<td colspan="2"><a href="${pageContext.request.contextPath}/">Return</a></td>
	</tr>
</table>
</body>
</html>
