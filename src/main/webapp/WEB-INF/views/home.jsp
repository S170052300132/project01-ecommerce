<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>online shopping</title>
</head>
<style>
p {
	color: red;
	text-align: center;
}
</style>
<body>
	<p>welcome to online shopping</p>
	<br>
	<c:if test="${empty successMsg}">
	<b> <a href="login"> LOGIN </a></b>
	<br>
	<b><a href="register"> REGISTER </a></b>
	<hr>
	</c:if>
	<p>${successMsg}</p>
	<c:if test="${showLoginPage}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>

	<c:if test="${not empty errorMsg}">
		<p>${errorMsg}</p>
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${showRegistrationPage}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>



</body>
</html>