<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
	<div style="padding: 5px; text-align: left;">

		<a href="${pageContext.request.contextPath}/info/news.jsp"><fmt:message key="_menu.News"/></a>
		|
		<a href="${pageContext.request.contextPath}/info/aboutUs.jsp"><fmt:message key="_menu.AboutUs"/></a>
		|
		<a href="${pageContext.request.contextPath}/userInfo"><fmt:message key="_menu.UserInfo"/></a>
		|
		<a href="${pageContext.request.contextPath}/login"><fmt:message key="_menu.Login"/></a>
		|
		<%@ page import="com.yu_pharm.model.Role" %>

		<c:if test="${applicationScope.user.roles.contains(Role.Admin)}">
			<a href="${pageContext.request.contextPath}/admin/AdminMainPage"><fmt:message key="_menu.Admin"/></a>
			|
		</c:if>
		<a href="${pageContext.request.contextPath}/">Return</a>
		<form method="post" action="${pageContext.request.contextPath}/locale">
			<select name="language" onchange="submit()">
				<option value="en_EN" ${language == "en_EN" ? "selected" : ""}>English</option>
				<option value="ru_RU" ${language == "ru_RU" ? "selected" : ""}>Русский</option>
			</select>
			<input type="hidden" name="from" value="${pageContext.request.requestURI}"/>
		</form>
	</div>
</div>
