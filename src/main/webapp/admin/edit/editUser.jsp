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
<jsp:include page="../../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../../WEB-INF/otherElements/_menu.jsp"/>
<h3>Edit User id = ${users.id}:</h3>
<form method="post" action="/user/edit">
	<label>Name</label><br>
	<input required name="name" value="${users.name}"/>
	<br><br>
	<label>Mail</label><br>
	<input required name="mail" value="${users.mail}"/>
	<br><br>
	<label>Password</label><br>
	<input required name="password" value="${users.password}"/>
	<br><br><br>
	<label>Role:
		<label>
			<input type="radio" name="role" value="0"/>
		</label> Viewer
		<label>
			<input type="radio" name="role" value="1"/>
		</label> Customer
		<label>
			<input type="radio" name="role" value="2"/>
		</label> Pharmacist
		<label>
			<input type="radio" name="role" value="3"/>
		</label> Doctor
		<label>
			<input type="radio" name="role" value="4"/>
		</label> Admin
		<label>
			<input type="radio" name="role" value="5"/>
		</label> SuperAdmin
	<br>
	<input type="hidden" name="id" value="${users.id}"/>
	</label><br>

	<input type="submit" value="Save"/>|
	<td colspan="2">
		<a href="/adminUserList">Return</a>
	</td>

</form>
<%--    <label>Description</label><br>--%>
<%--    <input name="description"/><br><br>--%>
<jsp:include page="../../WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>
