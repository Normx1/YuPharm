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
<%--<%@include file="nav_bar.jsp" %>--%>
<%--<%@include file="lang_bar.jsp" %>--%>
<%--<ul>
    <li><a href="?lang=en"><fmt:message key="lang.en" /></a></li>
    <li><a href="?lang=ru"><fmt:message key="lang.ru" /></a></li>
</ul>--%>
<%--<h2>--%>
<%--    <fmt:message key="lang.en" />--%>
<%--</h2>--%>




<h2>Users List</h2>
<p><a href='<c:url value="createUser.jsp" />'>Create new</a></p>
<table>
    <tr>
        <th>Name</th>
        <th>Mail</th>
        <th></th>
    </tr>
    <c:forEach var="users" items="${requestScope.table_name}">
        <tr>
            <td>${users.table_name.name}</td>
            <td>${users.table_name.mail}</td>
            <td>
                <a href='<c:url value="user/edit?id=${table_name.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="user/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${users.table_name.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>