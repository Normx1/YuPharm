<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit </title>
</head>
<body>
<h3>Edit drug</h3>
<form method="post"  action="/drug/edit" >
    <label>Name</label><br>
    <input name="name" value="${drug.name}"/>
    <br><br>
    <label>Cost</label><br>
    <input name="cost" value="${drug.cost}" />
    <br><br>
    <label>Count</label><br>
    <input name="count" value="${drug.count}" />
    <br><br>

    <label>Recipe</label><br>
    <input name="recipe" value="${drug.recipe}" />
    <br><br>

    <br><br>
<%--    <label>Description1</label><br>--%>
<%--    <input name="description"/><br><br>--%>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
