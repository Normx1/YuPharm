<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 28.04.2021
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
<jsp:include page="../WEB-INF/otherElements/_header.jsp"></jsp:include>

<h3><fmt:message key="loginView.Tittle"/></h3>
<p style="color: red;">${errorString}</p>
<form method="POST" action="${pageContext.request.contextPath}/login">
	<table border="0">
		<tr>
			<td><fmt:message key="loginView.UserName"/></td>
			<td><input type="text" name="name" value="${user.name}"/></td>
		</tr>
		<tr>
			<td>Mail</td>
			<td><input type="text" name="mail" value="${user.mail}"/></td>
		</tr>
		<tr>
			<td><fmt:message key="loginView.Password"/></td>
			<td><input type="text" name="password" value="${user.password}"/></td>
		</tr>

		<tr>
			<td><fmt:message key="loginView.RememberMe"/></td>
			<td><input type="checkbox" name="rememberMe" value="Y"/></td>
		</tr>

		<tr>
			<td colspan="2">
				<input type="submit" value=<fmt:message key="Sumbit"/>>
				<a href="${pageContext.request.contextPath}/"><fmt:message key="Cancel"/></a>
			</td>
		</tr>
	</table>
	<br><br>
	<b3><fmt:message key="loginView.NoAcc"/></b3>
	<br><br>
	<a href="${pageContext.request.contextPath}/user/create"> <fmt:message key="Registration"/></a>

</form>


<jsp:include page="../WEB-INF/otherElements/_footer.jsp"></jsp:include>
</body>
</html>
