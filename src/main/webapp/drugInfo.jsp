<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h3><fmt:message key="userBasket.Id"/>"${drug.name()}"</h3>

<table>
	<tr>
		<td><fmt:message key="userBasket.Id"/></td>
		<td>${drug.name()}</td>
	</tr>
	<tr>
		<td><fmt:message key="userBasket.Cost"/></td>
		<td>${drug.cost()}</td>
	</tr>
	<tr>
		<td><fmt:message key="userBasket.Count"/></td>
		<td>${drug.count()}</td>
	</tr>
	<tr>
		<td><fmt:message key="userBasket.Recipe"/></td>
		<td>${drug.recipe()}</td>
	</tr>
	<tr>
		<td><fmt:message key="drugInfo.MainAction"/></td>
 		<td>Not implemented yet</td>
	</tr>
	<tr>
		<td><fmt:message key="drugInfo.Description"/></td>
 		<td>Not implemented yet</td>
	</tr>
	<tr>
		<td><fmt:message key="drugInfo.Application"/></td>
 		<td>Not implemented yet</td>
	</tr>
	<tr>
		<td colspan="2"><a href="${pageContext.request.contextPath}/"><fmt:message key="Return"/></a></td>
	</tr>
</table>
</body>
</html>
