<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 28.04.2021
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<jsp:include page="../WEB-INF/otherElements/_header.jsp"></jsp:include>
<jsp:include page="../WEB-INF/otherElements/_menu.jsp"></jsp:include>

<h3>Hello: ${user.name}</h3>
<p style="color: red;">${requestScope.errorString}</p>
User Name: <b>${user.name}</b>
<br />
Mail: ${user.mail } <br/>

<a href='<c:url value="/UserOrders" />'>My Orders</a> |

<form method="get" action='<c:url value="/logout" />' style="display:inline;">
	<input type="submit" value="Logout">
</form>


<jsp:include page="../WEB-INF/otherElements/_footer.jsp"></jsp:include>

</body>
</html>
