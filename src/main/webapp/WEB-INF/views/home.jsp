<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>online shopping</title>
</head>

<body>
	<marquee>
		<font size="5" color="#0000ee">Wishing You a STYLISH and

			COMFORTABLE 2017</font><br>
		<center>
			<font size="3" color="#ff0000">CHEERS!!</font>
		</center>
	</marquee>
	<br>
			<jsp:include page="menu.jsp"></jsp:include>
	
	<c:if test="${empty successMsg}">
		<b> <a href="login"> LOGIN </a></b>
		<br>
		<b><a href="register"> REGISTER </a></b>
		<hr>
	</c:if>
	<center>
		<b>${successMsg}</b>
	</center>
	<c:if test="${showLoginPage}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>

	<c:if test="${not empty errorMsg}">
		<center>
			<b><font size="2" color="blue"><u>${errorMsg} </u></font></b>
		</center>
		<jsp:include page="403.jsp"></jsp:include>
	</c:if>
	<c:if test="${showRegistrationPage}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>	
	
			<jsp:include page="footer.jsp"></jsp:include>
	
	
</body>
</html>