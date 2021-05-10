<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 28.04.2021
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<jsp:include page="../otherElements/_header.jsp"></jsp:include>

<h3>Login Page</h3>
<p style="color: red;">${errorString}</p>
<form method="POST" action="${pageContext.request.contextPath}/login">
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="name" value="${user.name}"/></td>
        </tr>
        <tr>
            <td>Mail</td>
            <td><input type="text" name="mail" value="${user.mail}"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" value="${user.password}"/></td>
        </tr>

        <tr>
            <td>Remember me</td>
            <td><input type="checkbox" name="rememberMe" value="Y"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
         <br><br>
        <b3>I have no account</b3>
        <br><br>
    <a href= "${pageContext.request.contextPath}/user/create"> Registration</a>

 </form>


<jsp:include page="../otherElements/_footer.jsp"></jsp:include>
</body>
</html>
