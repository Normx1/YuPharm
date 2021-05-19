<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 28.04.2021
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding: 5px;  align: left;">

    <a href="${pageContext.request.contextPath}/news"><fmt:message key="_menu.News"/></a>
    |
    <a href="${pageContext.request.contextPath}/aboutUs"><fmt:message key="_menu.AboutUs"/></a>
    |
    <a href="${pageContext.request.contextPath}/userInfo"><fmt:message key="_menu.UserInfo"/></a>
    |
    <a href="${pageContext.request.contextPath}/login"><fmt:message key="_menu.Login"/></a>
    |
    <a href="${pageContext.request.contextPath}/AdminMainPage"><fmt:message key="_menu.Admin"/></a>



<div
<jsp:include page="/WEB-INF/otherElements/locale.jsp"></jsp:include>
</div>
