<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
	<div style="padding: 5px;  align: left;">

		<a href="${pageContext.request.contextPath}/info/news.jsp"><fmt:message key="_menu.News"/></a>
		|
		<a href="${pageContext.request.contextPath}/info/aboutUs.jsp"><fmt:message key="_menu.AboutUs"/></a>
		|
		<a href="${pageContext.request.contextPath}/userInfo"><fmt:message key="_menu.UserInfo"/></a>
		|
		<a href="${pageContext.request.contextPath}/login"><fmt:message key="_menu.Login"/></a>
		|
		<a href="${pageContext.request.contextPath}/AdminMainPage"><fmt:message key="_menu.Admin"/></a>

		<jsp:include page="/WEB-INF/otherElements/locale.jsp"/>
	</div>
</div>
