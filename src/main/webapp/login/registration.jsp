<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit </title>
</head>
<body>

<jsp:include page="../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../WEB-INF/otherElements/_menu.jsp"/>

<h3></h3>
<form method="post" action="/user/create">
	<label><fmt:message key="regictration.InputName"/></label><br>
	<input name="name" required value="${user.name}"/>
	<br><br>
	<label><fmt:message key="regictration.InputMail"/></label><br>
	<input name="mail" required value="${user.mail}"/>
	<br><br>
	<label><fmt:message key="regictration.InputPassword"/></label><br>
	<input name="password" required value="${user.password}"/>
	<br><br>

	<%--    <label>Repeat password</label><br>--%>
	<%--    <input name="password" value="${user.password}"/>--%>
	<%--    <br><br>--%>

	<fmt:message key="paymentCart.Confirmation"/>
	<label class="switch">
		<input required type="checkbox">
		<span class="slider"></span>
	</label>
	<br><br>
	<input  type="submit" value=<fmt:message key="Sumbit"/>>
	<a href="${pageContext.request.contextPath}/"><fmt:message key="Return"/></a>
	</td>
	<jsp:include page="../WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>
