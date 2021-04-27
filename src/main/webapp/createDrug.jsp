<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Лекарство</title>
</head>
<body>ee
<h3>New medicine</h3>
<form method="post" action="drug/create">
    <label>Name</label><br>
    <input name="name"/>
    <br><br>
    <label>Cost</label><br>
    <input name="cost" />
    <br><br>
    <label>Count</label><br>
    <input name="count" />
    <br><br>
    Recipe: <input type="radio" name="recipe" value="1" checked />Yes
    <input type="radio" name="recipe" value="0" checked />No

<%--//   <p> Recipe: <%= request.getParameter("recipe") %></p> - Для обработки данных--%>
    <br><br>
    <label>Description</label><br>
    <input name="description"/><br><br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
