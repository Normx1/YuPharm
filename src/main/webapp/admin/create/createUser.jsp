<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User</title>
</head>
<body>
<jsp:include page="../../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../../WEB-INF/otherElements/_menu.jsp"/>
<br>
<h3>New user</h3>
<form method="post" action="/user/create">
	<label>Name</label><br>
	<input required name="name"/><br><br>
	<label>Mail</label><br>
	<input required name="mail"/><br><br>
	<label>Password</label><br>
	<input required name="password"/><br><br>
	<label>Role</label><br>
	<form>
	<input type="radio" name="role" value="0"/> Viewer
	<input type="radio" name="role" value="1"/> Customer
	<input type="radio" name="role" value="2"/> Pharmacist
	<input type="radio" name="role" value="3"/> Doctor
	<input type="radio" name="role" value="4"/> Admin
	<input type="radio" name="role" value="5"/> SuperAdmin
	</form>
</form>
<td colspan="2">
	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
</body>
</html>
