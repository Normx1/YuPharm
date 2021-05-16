<%--@elvariable id="drug" type="com.yu_pharm.model.drug.Drug.Smart"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit </title>
	<style>
		form > label {
			display: table;
			width: 300px;
		}

		form > label > * {
			float: right;
		}
	</style>
</head>
<body>
<jsp:include page="WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="WEB-INF/otherElements/_menu.jsp"/>
<h3>Edit medicine:</h3>
<form method="post" action="/drug/edit">
	<input type="hidden" name="id" value="${drug.id()}">
	<label>Name
		<input name="name" value="${drug.name()}"/>
	</label>
	<label>Cost
		<input name="cost" value="${drug.cost()}"/>
	</label>
	<label>Count
		<input name="count" value="${drug.count}"/>
	</label>
	<label>Recipe:
		<label><input type="radio" name="recipe" value="1" checked/>Yes</label>
		<label><input type="radio" name="recipe" value="0"/>No</label>
	</label>
	<label>Main action
		<input name="Main_action" value="Some Main action"/>
	</label>
	<label>Description
		<input name="description" value="description"/>
	</label>
	<label>Application
		<input name="Application" value="Application"/>
	</label>
	<input type="submit" value="Save"/>
</form>
<a href="${pageContext.request.contextPath}/">Cancel</a>
<jsp:include page="WEB-INF/otherElements/_footer.jsp"/>
</body>
</html>
