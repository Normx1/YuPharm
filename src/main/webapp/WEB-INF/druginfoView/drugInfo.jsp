<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 29.04.2021
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Drug Info</title>
</head>
<body>
<jsp:include page=" /WEB-INF/otherElements/_header.jsp"></jsp:include>

<h3> Cure: "${drugs.id}"</h3>
<form>
    <table border="1" cellpadding="5" cellspacing="1">
        <h3>Users</h3>
        <tr>
            <th>${drugs.name}</th>
            <br>
            <th>${drugs.count}</th>
            <br>
            <th>${drugs.cost}</th>
            <br>
            <th>${drugs.recipe}</th>
            <br>
        </tr>
        <td colspan ="2">
            <a href="${pageContext.request.contextPath}/">Cancel</a>
        </td>

    </table>
    <jsp:include page="../otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>
