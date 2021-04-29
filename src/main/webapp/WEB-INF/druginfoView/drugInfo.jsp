<%--
  Created by IntelliJ IDEA.
  User: qa
  Date: 29.04.2021
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Drug Info</title>
</head>
<body>
<jsp:include page="../otherElements/_header.jsp"></jsp:include>

<h3> Cure: "${drug.name}"</h3>
<form>

    <label>Description</label><br>
    <textarea inputmode="text" name="description" style="width: 400px; height: 200px;"
              required>${drugs_info.description}</textarea><br><br>
    <input type="submit" value="Send"/>
    <br>
    <label>Main_action</label><br>
    <textarea inputmode="text" name="Main_action" style="width: 400px; height: 200px;"
              required>${drugs_info.Main_action}</textarea><br><br>
    <input type="submit" value="Send"/>
    <br>
    <label>Aplication</label><br>
    <textarea inputmode="text" name="Aplication" style="width: 400px; height: 200px;"
              required>${drugs_info.Aplication}</textarea><br><br>
    <input type="submit" value="Send"/>
    <br>
    <jsp:include page="../otherElements/_footer.jsp"></jsp:include>
</form>
</body>
</html>
