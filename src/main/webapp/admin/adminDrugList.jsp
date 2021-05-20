<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<jsp:include page="../WEB-INF/otherElements/_header.jsp"/>
<jsp:include page="../WEB-INF/otherElements/_menu.jsp"/><p>
<h2>Админ Лекарства</h2>
<p><a href='<c:url value="/drug/create" />'>Create new cure</a></p>
<table border="1" cellpadding="5" cellspacing="1">
    <h3>Drugs</h3>
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Count</th>
        <th>Cost</th>
        <th>Recipe</th>
        <th>Info</th>
        <th>Action</th>
    </tr>
    <c:forEach var="drug" items="${requestScope.drug}">
        <tr>
            <td>${drug.id()}</td>
            <td>${drug.name()}</td>
            <td>${drug.count()}</td>
            <td>${drug.cost()} $</td>
            <td>
                <div align="center"> ${drug.recipe()}
                </div>
            </td>
            <td>
                <a href='<c:url value="drug/info?id=${drug.id()}"/>'>Details</a>

            </td>
            <td>
                <a href='<c:url value="drug/edit?id=${drug.id()}" />'>Edit</a> |
                <form method="post" action='<c:url value="/drug/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${drug.id()}">
                    <input type="submit" value="Delete">
                </form>
        </tr>
    </c:forEach>
</table>
<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
	<tr>
		<c:forEach begin="1" end="${noOfPages}" var="i">
			<c:choose>
				<c:when test="${currentPage eq i}">
					<td>${i}</td>
				</c:when>
				<c:otherwise>
					<td><a href="${pageContext.request.contextPath}/adminDrugList?page=${i}">${i}</a></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tr>
</table>
<br>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
	<td><a href="${pageContext.request.contextPath}/adminDrugList?page=${currentPage - 1}">Previous</a></td>
</c:if>
<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
	<td><a href="${pageContext.request.contextPath}/adminDrugList?page=${currentPage + 1}">Next</a></td>
</c:if>
<br><br>
<td colspan ="2">

	<a href="${pageContext.request.contextPath}/">Cancel</a>
</td>
<table>
    <jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</table>
</body>
</html>
