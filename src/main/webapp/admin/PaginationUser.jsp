<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--На этой странице мы используем тег
<fmt: setBundle> для установки пакета ресурсов.--%>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="/config/messages"/>

<%--<fmt:setLocale value="${sessionScope.lang}"/>--%>
<%----%>
<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
	<meta charset="UTF-8">
	<title>Users</title>

</head>
<body>
<jsp:include page="../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../WEB-INF/otherElements/_menu.jsp"/>
<p>
<h2>Users List</h2>
<p><a href='<c:url value="/user/create" />'>Create new User</a></p>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>Name</th>
		<th>Mail</th>
		<th>Action</th>
	</tr>
	<c:forEach var="users" items="${requestScope.users}">
		<tr>
			<td>${users.name}</td>
			<td>${users.mail}</td>
			<td>
				<a href='<c:url value="user/edit?id=${users.id}" />'>Edit</a> |
				<form method="post" action='<c:url value="user/delete" />' style="display:inline;">
					<input type="hidden" name="id" value="${users.id}">
					<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
	<tr>
		<c:forEach begin="1" end="${noOfPages}" var="i">
			<c:choose>
				<c:when test="${currentPage eq i}">
					<td>${i}</td>
				</c:when>
				<c:otherwise>
					<td><a href="/PaginationUser?page=${i}">${i}</a></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tr>
</table>
<br>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
	<td><a href="PaginationUser?page=${currentPage - 1}">Previous</a></td>
</c:if>
<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
	<td><a href="${pageContext.request.contextPath}/PaginationUser?page=${currentPage + 1}">Next</a></td>
</c:if>
<br><br>
<td colspan="2">

	<a href="${pageContext.request.contextPath}/AdminMainPage">To Admin main page</a>
</td>
<br>
<table>
	<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</table>
</body>
</html>
