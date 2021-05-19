<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<html>
<head>
	<title>Title</title>
</head>
<body>
<jsp:include page="WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="WEB-INF/otherElements/_menu.jsp"/>
<h2><fmt:message key="aboutUs.headline"></fmt:message>
	<br></h2>
<fmt:message key="aboutUs.Text"></fmt:message>
<br>
<br>
<a href="${pageContext.request.contextPath}/">Return</a>
<jsp:include page="/WEB-INF/otherElements/_footer.jsp"/>
</body>
</html>
