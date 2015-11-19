<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Recommendations</title>
<link rel="stylesheet" type="text/css" href="style/theme.css">

</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container">
	
		<h3><b><c:out value="${user.getUsername()}" /></b></h3>
		Designation: <c:out value="${user.getDesignation()}" /> 
		<br>Status: <c:out value="${user.getStatus()}" /> 
		<br>Bio: <c:out value="${user.getBio()}" /> 
		
		<br><br><a href="UserController?action=deletePage&username=<c:out value="${user.getUsername()}" />">Delete User</a><br>
		<br><br><a href="UserController?action=editUserVerification&username=<c:out value="${user.getUsername()}" />">Edit User</a><br>
		
		
	<%@ include file="footer.jsp"%>
</body>
</html>

