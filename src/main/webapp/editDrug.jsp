<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit </title>
</head>
<body>
<h3>Edit drug</h3>
<form method="post" >
    <label>Name</label><br>
    <input name="name" value="${drug.name}"/>
    <br><br>
    <label>Cost</label><br>
    <input name="cost" value="${drug.cost}" />
    <br><br>
    <label>Count</label><br>
    <input name="count" value="${drug.count}" />
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
