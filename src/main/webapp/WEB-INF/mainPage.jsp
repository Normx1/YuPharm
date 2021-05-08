<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 26.04.2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yu_pharm.dao.DrugDao" %>
<%@ page import="com.yu_pharm.model.Drug" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<jsp:include page="otherElements/_header.jsp"></jsp:include>
<jsp:include page="otherElements/_menu.jsp"></jsp:include>
<div align="left">
    <h3>Cure recipe</h3>
</div>
<table border="1" cellpadding="5" cellspacing="1">

    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Count</th>
        <th>Cost</th>
        <th>Recipe</th>
        <th>info</th>
        <th>Buy</th>
    </tr>
    <c:forEach var="drug" items="${requestScope.drugs}">
        <tr>
            <td>${drug.id}</td>
            <td>${drug.name}</td>
            <td>${drug.count}</td>
            <td>${drug.cost} $</td>
            <td>
                <div align="center"> ${drug.recipe}
                </div>
            </td>
            <td>
                <a href='<c:url value="drug/drugInfo?id=${drug.id}"/>'>Details</a>

            </td>
            <td>
                <a href='<c:url value="/drug/edit?id=${drug.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/drug/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="7">
                    <input type="submit" value="Delete">
                </form>
<%--                <a href="/drug/delete?id=${drug.id}">Delete</a>--%>
            </td>
        </tr>
    </c:forEach>
</table>
<%--<table--%>
<%--<jsp:include page="/adminListDrugs.jsp"></jsp:include>--%>
<%--</table--%>
<table>
    <jsp:include page="otherElements/_footer.jsp"></jsp:include>
</table>
</body>
</html>
