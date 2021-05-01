<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit </title>
</head>
<body>
<jsp:include page="otherElements/_header.jsp"></jsp:include>
<h3>Edit medicine:</h3>
<form method="post" action="/user/create">
    <label>Input Name:</label><br>
    <input name="name" value="${user.name}"/>
    <br><br>
    <label>Input mail</label><br>
    <input name="mail" value="${user.mail}"/>
    <br><br>
    <label>Input password</label><br>
    <input name="password" value="${user.password}"/>
    <br><br>

<%--    <label>Repeat password</label><br>--%>
<%--    <input name="password" value="${user.password}"/>--%>
<%--    <br><br>--%>

    I agree with rules:
    <label class="switch">
        <input type="checkbox">
        <span class="slider"></span>
    </label>
    <br><br>
    <input type="submit" value="Save"/>
    <a href="${pageContext.request.contextPath}/">Cancel</a>
    </td>
    <jsp:include page="otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>