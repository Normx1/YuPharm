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
<body>
<h2>Админ Лекарства</h2>
<p><a href='<c:url value="createDrug.jsp" />'>Create new cure</a></p>
<p><a href='<c:url value="WEB-INF/createUser.jsp" />'>Create new user1</a></p>
<table>
    <h3>Drugs</h3>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Count</th>
        <th>Cost</th>
        <th></th>
    </tr>
    <%! List<Drug> drugs = new DrugDao().getAll(); %>
    <% for (Drug drug : drugs) { %>
    <tr>
        <td><%= drug.getName() %>
        </td>
    </tr>
    <%} %>
    <c:forEach var="drugs" items="${requestScope.drugs}">
        <tr>
            <td>${drugs.id}</td>
            <td>${drugs.name}</td>
            <td>${drugs.count}</td>
            <td>${drugs.cost}</td>
            <td>
                <a href='<c:url value="drug/edit?id=${drugs.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/drug/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${drugs.id}">
                    <input type="submit" value="Delete+${drugs.id}">
                </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
