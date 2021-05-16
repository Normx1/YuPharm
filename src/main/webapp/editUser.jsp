<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 10.05.2021
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<jsp:include page="WEB-INF/otherElements/_header.jsp"></jsp:include>
<h3>Edit User id = ${users.id}:</h3>
<form method="post" action="/user/edit">
	<label>Name</label><br>
	<input name="name" value="${users.name}"/>
	<br><br>
	<label>Mail</label><br>
	<input name="mail" value="${users.mail}" />
	<br><br>
	<label>Password</label><br>
	<input name="password" value="${users.password}" />
	<br><br><br>
	<label>Role</label><br>
	<input name="role" value="${users.role}" />
	<br><br><br>
	<input type="hidden" name="id" value="${users.id}">

	<input type="submit" value="Save"/>|

	<td colspan ="2">
		<a href="/adminUserList">Return</a>
	</td>

</form>
 <%--    <label>Description</label><br>--%>
<%--    <input name="description"/><br><br>--%>
<jsp:include page="WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>
