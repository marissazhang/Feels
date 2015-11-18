<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="style/theme.css">

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>MIE350 Sample DB Web App: Add/Update A User</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>.

	<div class="container">
		<center>
			<h1>Edit Account</h1>
		Note: Only users that are from University of Toronto with an official utoronto email 
		will be accepted in our system. <br> <br>
		
		If your email is mail.utoronto.ca, you will be designated as a Student, 
		and if your email is utoronto.ca, you will be designated as a Professional. <br> <br>
		</center>
		<script>
			$(function() {
				$('input[name=dob]').datepicker();
			});
		</script>
		<form action='UserController?action=editUser' method="POST" >
			Username: <input type="text" name="userName"
				value="<c:out value="${user.username}" />"><br>
			Password: <input type="text" name="password"
				value="<c:out value="${user.password}" />"><br>
			Email: <input type="text" name="email"
				value="<c:out value="${user.email}" />"><br>
			Status: <input type="text" name="status"
				value="<c:out value="${user.status}" />"><br>
			Bio: <textarea type="text" name="bio"><c:out value="${user.bio}" /></textarea><br><br>
			<input type="submit" value="Edit Profile" />
				
		</form>
	</div>
</body>
</html>