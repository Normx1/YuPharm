<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Лекарство</title>
</head>

<body>
<jsp:include page="../../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../../WEB-INF/otherElements/_menu.jsp"/>


<h3>Create new medicine:</h3>
<form method="post" action="/drug/create">
    <label>Name</label><br>
    <input name="name"/>
    <br><br>
    <label>Cost</label><br>
    <input  name="cost"/>
    <br><br>
    <label>Count</label><br>
    <input name="count"/>
    <br><br>
    Recipe: <input type="radio"  name="recipe" value="1" checked/>Yes
    <input type="radio" name="recipe" value="0" checked/>No
    <br><br>
    <label>Main action</label><br>
    <textarea inputmode="text" name="main_action" style="width: 300px; height: 50px;"> </textarea><br><br>
    <label>Description</label><br>
    <textarea inputmode="text" name="description" style="width: 300px; height: 50px;"> </textarea><br><br>
    <label>Application</label><br>
    <textarea inputmode="text" name="application" style="width: 300px; height: 50px;">
    </textarea>
    <br><br>

    <%--    <label>Description</label><br>--%>
    <%--    <input name="description"/><br><br>--%>
    <input type="submit" value="Save"/>|
    <td colspan ="2">

        <a href="/adminDrugList">Cancel</a>
    </td>
    <jsp:include page="../../WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>
