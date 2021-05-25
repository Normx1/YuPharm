<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>Exception/Error Details</title>
</head>
<body>
<jsp:include page="WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="WEB-INF/otherElements/_menu.jsp"/>
<div>
	<h3>Details</h3>
	<strong>Status Code</strong>: ${requestScope.get("javax.servlet.error.status_code")}<br/>
	<strong>Requested URI</strong>: ${requestScope.get("javax.servlet.error.request_uri")}<br/>
	<strong>Servlet Name</strong>: ${requestScope.get("javax.servlet.error.servlet_name")}<br/>
	<strong>Exception Name:</strong> ${(requestScope.get("javax.servlet.error.exception")).message}<br/>
	<pre>
	<% StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		((Throwable) request.getAttribute("javax.servlet.error.exception")).printStackTrace(pw);
		out.print(sw.toString()); %>
	</pre>
</div>
<jsp:include page="WEB-INF/otherElements/_footer.jsp"/>
</body>
</html>
