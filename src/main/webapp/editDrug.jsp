<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit </title>
</head>
<body>
<jsp:include page="WEB-INF/otherElements/_header.jsp"></jsp:include>
<h3>Edit medicine:</h3>
<form method="post" action="/drug/edit">
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
    Recipe: <input type="radio" name="recipe" value="1" checked/>Yes
    <input type="radio" name="recipe" value="0" checked/>No
    <br><br>
    <label>Main action</label><br>
    <input name="Main_action" value="Some Main action" />
    <br><br>
    <label>Description</label><br>
    <input name="description" value="description"/>
    <br><br>
    <label>Application</label><br>
    <input name="Application" value="Application"/>
    </textarea>
    <br><br>
    <input type="hidden" name="id" value="${drug.id}">

    <%--    <label>Description</label><br>--%>
    <%--    <input name="description"/><br><br>--%>
    <input type="submit" value="Save"/>|
    <td colspan ="2">

        <a href="${pageContext.request.contextPath}/">Cancel</a>
    </td>
    <jsp:include page="WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>