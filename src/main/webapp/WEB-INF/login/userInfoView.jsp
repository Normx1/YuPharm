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

<jsp:include page="../otherElements/_header.jsp"></jsp:include>
<jsp:include page="../otherElements/_menu.jsp"></jsp:include>

<h3>Hello: ${user.name}</h3>

User Name: <b>${user.name}</b>
<br />
Mail: ${user.mail } <br/>

<a href='<c:url value="/userOrders?name=${user.name}" />'>My Orders</a> |

<jsp:include page="../otherElements/_footer.jsp"></jsp:include>

</body>
</html>
