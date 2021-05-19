<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title>Title</title>
</head>
<body>
<jsp:include page="WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="WEB-INF/otherElements/_menu.jsp"/>
<h2>About Us</h2>
<fmt:message key="aboutUs"></fmt:message>

<br>
<br>
<a href="${pageContext.request.contextPath}/">Return</a>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"/>
</body>
</html>
