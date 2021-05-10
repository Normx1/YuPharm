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
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>

<p><h2>Users List</h2>
<p><a href='<c:url value="createUser.jsp" />'>Create new User</a></p>
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
<td colspan ="2">

	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
<table>
    <jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</table>
</body>
</html>
