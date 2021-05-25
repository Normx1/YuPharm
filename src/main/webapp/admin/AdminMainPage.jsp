<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>

<body>
<form>
	<p><a href='<c:url value="/admin/adminDrugList" />'><fmt:message key="drug"></fmt:message> </a></p>
<%--	<p><a href='<c:url value="/admin/adminUserList" />'>Users</a></p>--%>
	<p><a href='<c:url value="/admin/allOrders" />'>Orders</a></p>
	<p><a href='<c:url value="/admin/PaginationUser" />'>Pagination of User</a></p>
<%--	<p><a href='<c:url value="/allRecipes"/>'>Recipes</a></p>--%>

</form>
<td colspan="2">

	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>

</body>
</html>
