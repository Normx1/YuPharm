<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 26.04.2021
  Time: 01:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyPharm</title>
</head>
<table>
    <tr>
        <th>Name</th>
        <th>Count</th>
        <th>Cost</th>
        <th>Choose</th>
        <th></th>
    </tr>
<c:forEach var="drug" items="${requestScope.drug}">
    <td>${drug.name}</td>
    <td>${drug.count}</td>
    <td>${drug.cost}</td>
    <td>${drug.recipe}</td>
    <td>${drug.description}</td>
    <input type="checkbox" name="checkBuy" value="Buy" checked />
    </table>
</c:forEach>
</body>
</html>
