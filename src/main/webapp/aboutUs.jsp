<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 16.05.2021
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/otherElements/_header.jsp"></jsp:include>

<h2>About Us</h2>
ABOUT THE YuPharm NETWORK»
YuPharm is a popular pharmacy chain in Belarus, specializing in natural products for health and beauty.
We have a wide selection of high-quality products at affordable prices: natural and medicinal cosmetics, vitamins, essential oils, dietary and sports nutrition, medical products, dietary supplements, herbal teas and fees, and many others. All products have documents confirming the quality and pass strict control.
More than 140 pharmacies and shops throughout Belarus. Call us and we will tell you the nearest pharmacy to your home or work.
Also, residents of Minsk can order goods with home delivery through our online store. And residents of other cities — delivery by mail with payment by cash on delivery.
YuPharm — MORE THAN A PHARMACY
<br>
<br>
<a href="${pageContext.request.contextPath}/">Return</a>
<table>
	<jsp:include page="/WEB-INF/otherElements/_footer.jsp"></jsp:include>
</table>
</body>
</html>
