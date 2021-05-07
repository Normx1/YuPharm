<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 01.05.2021
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="../WEB-INF/otherElements/_header.jsp"></jsp:include>

<body>
<form>
<p><a href='<c:url value="/adminDrugList" />'>Drugs</a></p>
<br>
<p><a href='<c:url value="/adminUserList" />'>Users</a></p>
<br>
<a href="${pageContext.request.contextPath}/">Orders</a>
<br>
<a href="${pageContext.request.contextPath}/">Recipes</a>
<%--<a href='<c:url value="/drug/edit?id=${drug.id}" />'>Edit</a> |--%>
</form>
</body>
</html>
