<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<label>
		<div>
			<%@ page import="com.yu_pharm.model.Role" %>
			<c:forEach var="role" items="${Role.values()}">
				<label>
					<input type="radio" name="role" value="${role.name()}">${role.name()}
				</label>
				<br>
			</c:forEach>
		</div>
		<input type="hidden" name="id" value="${users.id}"/>
	</label><br>

	<input type="submit" value="Save"/>|
	<td colspan="2">
		<a href="/admin/adminUserList">Return</a>
	</td>

</form>
<%--    <label>Description</label><br>--%>
<%--    <input name="description"/><br><br>--%>
<jsp:include page="../../WEB-INF/otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>
