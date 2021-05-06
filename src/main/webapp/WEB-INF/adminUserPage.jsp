<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 01.05.2021
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<br>
<br>
<h2>Админ Лекарства</h2>
<p><a href='<c:url value="../createUser.jsp" />'>Create new cure</a></p>

<table border="1" cellpadding="5" cellspacing="1">
    <h2>Medicine Users </h2>
    <tr>
        <th>№</th>
        <th>id</th>
        <th>Name</th>
        <th>Mail</th>
        <th>Password</th>
        <th></th>
    </tr>
    <c:forEach var="users" items="${requestScope.table_name}">
        <tr>
            <td> </td>
            <td>${users.name}</td>
            <td>${users.mail}</td>
            <td>${users.password}</td>
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
</body>
</html>
<th>№</th>
<th>id</th>
<th>Name</th>
<th>Count</th>
<th>Cost</th>
<th>Recipe</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="drugs" items="${requestScope.drugs}">
    <tr>
        <th></th>
        </td>
        <td>${drugs.id}</td>
        <td>${drugs.name}</td>
        <td>${drugs.count}</td>
        <td>${drugs.cost}</td>
        <td>${drugs.recipe}</td>
        <td>
            <a href='<c:url value="/drug/edit?id=${drugs.id}"/>'>Edit</a>
        </td>
        <td>
            <form method="post" action='<c:url value="/drug/delete" />' style="display:inline;">
                <input type="hidden" name="id" value="${drugs.id}">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
</c:forEach>
</table>

</body>
</html>