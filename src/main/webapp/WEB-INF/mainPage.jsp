<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 26.04.2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.DrugDao" %>
<%@ page import="model.Drug" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<h2>Админ Лекарства</h2>
<p><a href='<c:url value="../createDrug.jsp" />'>Create new cure</a></p>
<p><a href='<c:url value="../createUser.jsp" />'>Create new user</a></p>

<table border="1" cellpadding="5" cellspacing="1">
    <h3>Drugs</h3>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Count</th>
        <th>Cost</th>
        <th>Recipe</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="drug" items="${requestScope.drugs}">
        <tr>
            <td>${drug.id}</td>
            <td>${drug.name}</td>
            <td>${drug.count}</td>
            <td>${drug.cost}</td>
            <td>${drug.recipe}</td>
            <td>
                <a href='<c:url value="drug/edit?id=${drug.id}" />'>Edit</a>
            </td>
            <td>
                <form method="post" action='<c:url value="drug/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${drug.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<table border="1" cellpadding="5" cellspacing="1">
    <h3>Users</h3>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Mail</th>
        <th>Password</th>
    </tr>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.mail}</td>
            <td>${user.password}</td>
            <td>
                <a href='<c:url value="user/edit?id=${user.id}" />'>Edit</a>
            </td>
            <td>
                <form method="post" action='<c:url value="user/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
